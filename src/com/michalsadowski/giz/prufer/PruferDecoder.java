package com.michalsadowski.giz.prufer;

import com.michalsadowski.giz.prufer.domain.PruferCode;
import com.michalsadowski.giz.services.GraphViewer;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by sadowsm3 on 21.05.2018
 */
public class PruferDecoder {

    private Predicate<Integer> findNotPresentInOriginalCode(List<String> pruferVertex) {
        return vertex -> !pruferVertex.contains(vertex.toString());
    }

    public String decode(PruferCode pruferCode) {
        Set<Integer> originalVertices = new HashSet<>();
        originalVertices = restoreOriginalVertices(originalVertices, pruferCode);
        Graph graph = new SingleGraph("Prufer");
        restoreOriginalTreeFromPruferCode(originalVertices, pruferCode.getIdentifierList(), graph);
        addLiteralLabellingToNodes(graph, pruferCode.getNodeList());
        GraphViewer.viewGraph(graph);
        return originalVertices.toString();
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
        while (iterator.hasNext()) {
            String pruferVertex = iterator.next().toString();
            Optional<Integer> min = originalVertices.stream().filter(findNotPresentInOriginalCode(pruferCodeList)).min(Integer::compareTo);
            if (min.isPresent()) {
                addNodes(graph, pruferVertex, min.get().toString());
                originalVertices.remove(min.get());
                iterator.remove();
            }
        }

        if (originalVertices.size() == 2) {
            Iterator originalIterator = originalVertices.iterator();
            while (originalIterator.hasNext()) {
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

    private void addLiteralLabellingToNodes(Graph graph, String[] labels) {
        Collection<Node> nodeSet = graph.getNodeSet();
        Iterator nodeIterator = nodeSet.iterator();
        Iterator labelIterator = Arrays.stream(labels).iterator();
        while (nodeIterator.hasNext()) {
            Node node = (Node) nodeIterator.next();
            if (node.getDegree() < 2 && labelIterator.hasNext()) {
                node.clearAttributes();
                String label = (String) labelIterator.next();
                System.out.println(label);
                node.setAttribute("ui.label", label);
            }
        }
    }
}
