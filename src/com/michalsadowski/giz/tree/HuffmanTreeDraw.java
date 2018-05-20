package com.michalsadowski.giz.tree;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

import static com.michalsadowski.giz.huffman.service.HuffmanUtils.hasLeftChild;
import static com.michalsadowski.giz.huffman.service.HuffmanUtils.hasRightChild;

/**
 * Created by sadowsm3 on 20.05.2018
 */
public class HuffmanTreeDraw {
    private static Integer edgeID = 1;
    public static void drawHuffmanTree(HuffmanNode node) {
        Graph graph = new SingleGraph("Huffman Tree");
        Node rootNode = graph.addNode(getNodeName(node)); //draw root node
        rootNode.setAttribute("ui.label", node.getCharacter() == null ? node.getFrequency() : node.getCharacter().toString());
        drawNode(graph, rootNode, node);
        System.out.println(graph.getNodeSet().size());
        Viewer viewer = graph.display(false);
        HierarchicalLayout h1 = new HierarchicalLayout();
        viewer.enableAutoLayout(h1);
        graph.display();
    }

    private static void drawNode(Graph graph, Node parentNode, HuffmanNode node) {
        if(hasRightChild(node)) {
            Node rightChildNode = graph.addNode(getNodeName(node.getRightNode()));
            rightChildNode.setAttribute("ui.label", node.getRightNode().getCharacter() == null ? node.getRightNode().getFrequency() : node.getRightNode().getCharacter().toString());
            graph.addEdge(getEdgeID(), parentNode, rightChildNode);
            drawNode(graph, rightChildNode, node.getRightNode());
        }
        if(hasLeftChild(node)) {
            Node leftChildNode = graph.addNode(getNodeName(node.getLeftNode()));
            leftChildNode.setAttribute("ui.label", node.getLeftNode().getCharacter() == null ? node.getLeftNode().getFrequency() : node.getLeftNode().getCharacter().toString());
            graph.addEdge(getEdgeID(), parentNode, leftChildNode);
            drawNode(graph, leftChildNode, node.getLeftNode());
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
