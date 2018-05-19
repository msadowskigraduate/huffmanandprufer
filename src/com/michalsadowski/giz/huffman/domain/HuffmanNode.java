package com.michalsadowski.giz.huffman.domain;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private final Character character;
    private final Integer frequency;
    private HuffmanNode leftNode;
    private HuffmanNode rightNode;

    public HuffmanNode(Character character, Integer frequency, HuffmanNode leftNode, HuffmanNode rightNode) {
        this.character = character;
        this.frequency = frequency;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public HuffmanNode(Character character, Integer frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode node2) {
        return this.getFrequency() - node2.getFrequency();
    }

    public Character getCharacter() {
        return character;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public HuffmanNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(HuffmanNode leftNode) {
        this.leftNode = leftNode;
    }

    public HuffmanNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(HuffmanNode rightNode) {
        this.rightNode = rightNode;
    }

}
