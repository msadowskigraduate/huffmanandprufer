package com.michalsadowski.giz.huffman;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;
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

    public static void drawHuffmanTree(HuffmanNode node, Map<HuffmanNode, Integer> valueMap) {
        Graph graph = new SingleGraph("Huffman Tree");
        Node rootNode = graph.addNode(getNodeName(node)); //draw root node
        rootNode.setAttribute("ui.label", valueMap.get(node));
        drawNode(graph, rootNode, node, valueMap);
        System.out.println(graph.getNodeSet().size());
        Viewer viewer = graph.display(true);
        HierarchicalLayout h1 = new HierarchicalLayout();
        viewer.enableAutoLayout(h1);
    }

    private static void drawNode(Graph graph, Node parentNode, HuffmanNode node, Map<HuffmanNode, Integer> valueMap) {
        if(hasRightChild(node)) {
            Node rightChildNode = graph.addNode(getNodeName(node.getRightNode()));
            rightChildNode.setAttribute("ui.label", valueMap.get(node.getRightNode()));
            graph.addEdge(getEdgeID(), parentNode, rightChildNode);
            drawNode(graph, rightChildNode, node.getRightNode(), valueMap);
        }
        if(hasLeftChild(node)) {
            Node leftChildNode = graph.addNode(getNodeName(node.getLeftNode()));
            leftChildNode.setAttribute("ui.label", valueMap.get(node.getLeftNode()));
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
}
