package com.michalsadowski.giz.huffman;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class HuffmanTreeBuilder implements Serializable {
    public void buildTree(Queue<HuffmanNode> priorityQueue) {
        Iterator iterator = priorityQueue.iterator();
        while(iterator.hasNext()) {
            
        }
    }
}
