package com.michalsadowski.giz.huffman.service;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;

import java.util.Map;

/**
 * Created by sadowsm3 on 20.05.2018
 */
public class HuffmanUtils {
    public static boolean isChildless(HuffmanNode node) {
        return node != null && node.getRightNode() == null && node.getLeftNode() == null;
    }

    public static boolean hasRightChild(HuffmanNode node) {
        return node.getRightNode() != null;
    }

    public static boolean hasLeftChild(HuffmanNode node) {
        return node.getLeftNode() != null;
    }

    public static boolean isNodeValid(HuffmanNode node) {
        return node.getFrequency() != null && node.getCharacter() != null;
    }

    public static void assignNodeNumeration(HuffmanNode huffmanNode, Map<HuffmanNode, Integer> map) {
        map.put(huffmanNode, map.size() + 1);
        if (hasLeftChild(huffmanNode)) {
            assignNodeNumeration(huffmanNode.getLeftNode(), map);
        }
        if (hasRightChild(huffmanNode)) {
            assignNodeNumeration(huffmanNode.getRightNode(), map);
        }
    }
}
