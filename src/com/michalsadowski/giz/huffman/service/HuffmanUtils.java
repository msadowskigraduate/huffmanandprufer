package com.michalsadowski.giz.huffman.service;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;

/**
 * Created by sadowsm3 on 20.05.2018
 */
public class HuffmanUtils {
    public static boolean isChildless(HuffmanNode node) {
        return node!= null && node.getRightNode() == null && node.getLeftNode() == null;
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
}
