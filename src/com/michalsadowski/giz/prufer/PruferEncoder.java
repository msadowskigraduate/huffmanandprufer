package com.michalsadowski.giz.prufer;

import com.michalsadowski.giz.huffman.domain.HuffmanNode;

import java.util.*;
import java.util.function.Predicate;

import static com.michalsadowski.giz.huffman.service.HuffmanUtils.isChildless;

/**
 * Created by sadowsm3 on 20.05.2018
 */
public class PruferEncoder {

    private Predicate<Map.Entry<HuffmanNode, Integer>> isAParentToThatNode(HuffmanNode node) {
        return parent -> parent.getKey().getLeftNode() == node || parent.getKey().getRightNode() == node;
    }

    public List<Integer> encode(Map<HuffmanNode, Integer> map) {
        System.out.println("**************************PRUFER CODE**********************************");
        List<Integer> pruferSequence = new ArrayList<>();
        encodeTreeToPrufer(map, pruferSequence, map.size());
        System.out.println(pruferSequence);
        return pruferSequence;
    }

    private void encodeTreeToPrufer(Map<HuffmanNode, Integer> map, List<Integer> pruferSequence, Integer initialSize) {
        if(initialSize > pruferSequence.size() + 2) {
            Optional<Map.Entry<HuffmanNode, Integer>> entry = findLeafWithLowestLabel(map); //find leaf with lowest label
            if(entry.isPresent()) {
                pruferSequence.add(findNeighbouringNode(map, entry.get().getKey()));// add parent node
                map.remove(entry.get().getKey()); //remove it from the tree
                encodeTreeToPrufer(map, pruferSequence, initialSize);
            }
        }
    }

    private Optional<Map.Entry<HuffmanNode, Integer>> findLeafWithLowestLabel(Map<HuffmanNode, Integer> map) {
        return map.entrySet().stream().filter(entry -> isChildless(entry.getKey())).min(Comparator.comparingInt(Map.Entry::getValue));
    }

    private Integer findNeighbouringNode(Map<HuffmanNode, Integer> map, HuffmanNode node) {
        Optional<Map.Entry<HuffmanNode, Integer>> entry = map.entrySet().stream().filter(isAParentToThatNode(node)).findFirst();
        if(entry.isPresent()) {
           if(entry.get().getKey().getRightNode().equals(node)) {
               entry.get().getKey().setRightNode(null);
           }
           else if(entry.get().getKey().getRightNode().equals(node)){
               entry.get().getKey().setLeftNode(null);
           }
        }
       return entry.get().getValue();
    }
}
