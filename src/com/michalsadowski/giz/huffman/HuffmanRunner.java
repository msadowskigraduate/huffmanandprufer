package com.michalsadowski.giz.huffman;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;
import com.michalsadowski.giz.huffman.service.HuffmanUtils;
import com.michalsadowski.giz.huffman.service.MapToNodeConverter;

import java.util.HashMap;
import java.util.Map;

import static com.michalsadowski.giz.huffman.service.HuffmanConst.HUFFMAN_INIT_CODE;
import static com.michalsadowski.giz.huffman.HuffmanTreeDraw.drawHuffmanTree;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class HuffmanRunner {
    private final HuffmanEncoder huffmanEncoder;
    private final HuffmanTreeBuilder huffmanTreeBuilder;

    public Map<Character, String> encodingMap = new HashMap<>();
    public Map<HuffmanNode, Integer> valuemap = new HashMap<>();

    public HuffmanRunner(HuffmanEncoder huffmanEncoder, HuffmanTreeBuilder huffmanTreeBuilder) {
        this.huffmanEncoder = huffmanEncoder;
        this.huffmanTreeBuilder = huffmanTreeBuilder;
    }

    public void run(String text) {
        HuffmanNode huffmanNode = huffmanTreeBuilder.buildTree(
                MapToNodeConverter.convert(huffmanEncoder.encode(text)));
        huffmanTreeBuilder.huffmanCodeGenerator(huffmanNode, encodingMap, HUFFMAN_INIT_CODE);
        encodingMap.forEach((x,y) -> System.out.println(x + " " + y));
        drawHuffmanTree(huffmanNode);
        HuffmanUtils.assignNodeNumeration(huffmanNode, valuemap);
        valuemap.forEach((x,y) -> System.out.println(x.toString() + " : " + y));
    }
}