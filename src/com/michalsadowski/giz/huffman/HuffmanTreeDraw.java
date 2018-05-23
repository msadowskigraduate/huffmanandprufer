package com.michalsadowski.giz.huffman;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;
import com.michalsadowski.giz.services.GraphViewer;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

import java.util.Map;

import static com.michalsadowski.giz.huffman.service.HuffmanUtils.hasLeftChild;
import static com.michalsadowski.giz.huffman.service.HuffmanUtils.hasRightChild;

/**
 * Created by sadowsm3 on 20.05.2018
 */
public class HuffmanTreeDraw {
    private static Integer edgeID = 1;

    public static void drawHuffmanTree(HuffmanNode node, Map<Integer, HuffmanNode> valueMap) {
        Graph graph = new SingleGraph("Huffman Tree");
        Node rootNode = graph.addNode(getNodeName(node)); //draw root node
        rootNode.setAttribute("ui.label", getNodeLabel(node, valueMap));
        drawNode(graph, rootNode, node, valueMap);
        System.out.println(graph.getNodeSet().size());
        GraphViewer.viewGraph(graph);
    }

    private static void drawNode(Graph graph, Node parentNode, HuffmanNode node, Map<Integer,HuffmanNode> valueMap) {
        if(hasRightChild(node)) {
            Node rightChildNode = graph.addNode(getNodeName(node.getRightNode()));
            rightChildNode.setAttribute("ui.label", getNodeLabel(node.getRightNode(), valueMap));
            graph.addEdge(getEdgeID(), parentNode, rightChildNode);
            drawNode(graph, rightChildNode, node.getRightNode(), valueMap);
        }
        if(hasLeftChild(node)) {
            Node leftChildNode = graph.addNode(getNodeName(node.getLeftNode()));
            leftChildNode.setAttribute("ui.label", getNodeLabel(node.getLeftNode(), valueMap));
            graph.addEdge(getEdgeID(), parentNode, leftChildNode);
            drawNode(graph, leftChildNode, node.getLeftNode(), valueMap);
        }
    }

    private static String getEdgeID() {
        edgeID = edgeID + 1;
        return edgeID.toString();
    }

    private static String getNodeName(HuffmanNode node) {
        if(node.getCharacter() != null) {
            return node.getCharacter().toString();
        }
        return node.toString();
    }

    private static Integer getNodeLabel(HuffmanNode node, Map<Integer, HuffmanNode> map) {
        return map.entrySet().stream().filter(x-> x.getValue() == node).findFirst().map(Map.Entry::getKey).get();
    }
}
