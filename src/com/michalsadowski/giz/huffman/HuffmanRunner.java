package com.michalsadowski.giz.huffman;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;

import java.util.HashMap;
import java.util.Map;

import static com.michalsadowski.giz.huffman.service.HuffmanConst.HUFFMAN_INIT_CODE;
import static com.michalsadowski.giz.tree.HuffmanTreeDraw.drawHuffmanTree;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class HuffmanRunner {
    private final HuffmanEncoder huffmanEncoder;
    private final HuffmanTreeBuilder huffmanTreeBuilder;

    public HuffmanRunner(HuffmanEncoder huffmanEncoder, HuffmanTreeBuilder huffmanTreeBuilder) {
        this.huffmanEncoder = huffmanEncoder;
        this.huffmanTreeBuilder = huffmanTreeBuilder;
    }

    public void run(String text) {
        Map<Character, String> encodingMap = new HashMap<>();
        HuffmanNode huffmanNode = huffmanTreeBuilder.buildTree(
                MapToNodeConverter.convert(huffmanEncoder.encode(text)));
        huffmanTreeBuilder.huffmanCodeGenerator(huffmanNode, encodingMap, HUFFMAN_INIT_CODE);
        encodingMap.forEach((x,y) -> System.out.println(x + " " + y));
        drawHuffmanTree(huffmanNode);
    }
}
