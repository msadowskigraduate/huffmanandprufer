package com.michalsadowski.giz.prufer;

import com.michalsadowski.giz.prufer.domain.PruferCode;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by sadowsm3 on 21.05.2018
 */
public class PruferDecoder {

    private Predicate<Integer> findNotPresentInOriginalCode(List<String> pruferVertex) {
        return vertex -> !pruferVertex.contains(vertex.toString());
    }

    public void decode(PruferCode pruferCode) {
        Set<Integer> originalVertices = new HashSet<>();
        originalVertices = restoreOriginalVertices(originalVertices, pruferCode);
        Graph graph = new SingleGraph("Prufer");
        System.out.println(originalVertices);
        restoreOriginalTreeFromPruferCode(originalVertices, pruferCode.getIdentifierList(), graph);
        System.out.println(originalVertices);
        graph.display();
    }

    private Set<Integer> restoreOriginalVertices(Set<Integer> originalVertices, PruferCode pruferCode) {
        for (int i = 1; i <= pruferCode.getIdentifierList().length + 2; i++) {
            originalVertices.add(i);
        }
        return originalVertices;
    }

    private void restoreOriginalTreeFromPruferCode(Set<Integer> originalVertices, String[] pruferCode, Graph graph) {
        List<String> pruferCodeList = new ArrayList<>(Arrays.asList(pruferCode));
        System.out.println(pruferCodeList);
        Iterator iterator = pruferCodeList.listIterator();
        while(iterator.hasNext()) {
            String pruferVertex = iterator.next().toString();
            Optional<Integer> min = originalVertices.stream().filter(findNotPresentInOriginalCode(pruferCodeList)).min(Integer::compareTo);
            if (min.isPresent()) {
                addNodes(graph, pruferVertex, min.get().toString());
                originalVertices.remove(min.get());
                iterator.remove();
            }
        }

        if(originalVertices.size() == 2) {
            Iterator originalIterator = originalVertices.iterator();
            while(originalIterator.hasNext()) {
                String one = originalIterator.next().toString();
                String two = originalIterator.next().toString();
                addNodes(graph, one, two);
            }
        }
    }

    private void addNodes(Graph graph, String pruferVertex, String min) {
        Node node1 = graph.getNode(pruferVertex);
        Node node2 = graph.getNode(min);
        if (node1 == null) {
            node1 = graph.addNode(pruferVertex);
            node1.setAttribute("ui.label", pruferVertex);
        }

        if (node2 == null) {
            node2 = graph.addNode(min);
            node2.setAttribute("ui.label", min);
        }
        graph.addEdge(pruferVertex.concat(" ").concat(min), node1, node2);
    }
}
