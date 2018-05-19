package com.michalsadowski.giz.huffman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class HuffmanEncoder {

    public void encode(String textToEncode) {
       encodeText(CharacterConverter.convert(textToEncode));
    }

    public void encode(Character[] charsToEncode) {
        encodeText(charsToEncode);
    }

    private void encodeText(Character[] charsToEncode) {
        Map<Character, Integer> occuranceFreqMap = new HashMap<>();
        createFrequenceMap(occuranceFreqMap, charsToEncode);
    }

    private void createFrequenceMap(Map<Character, Integer> occuranceFreqMap, Character[] charsToEncode) {
        Arrays.stream(charsToEncode).forEach( character -> {
            if(occuranceFreqMap.containsKey(character)) {
                occuranceFreqMap.compute(character, (x,y) -> y +1 );
            }
            else {
                occuranceFreqMap.put(character, 1);
            }
        });
    }
}
