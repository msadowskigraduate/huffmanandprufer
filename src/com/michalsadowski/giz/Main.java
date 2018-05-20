package com.michalsadowski.giz;

import com.michalsadowski.giz.huffman.HuffmanEncoder;
import com.michalsadowski.giz.huffman.HuffmanRunner;
import com.michalsadowski.giz.huffman.HuffmanTreeBuilder;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class Main {

    public static void main(String[] args) {

        HuffmanRunner runner = new HuffmanRunner(new HuffmanEncoder(), new HuffmanTreeBuilder());
        runner.run("The syntax of a style sheet is very similar to the one seen in the cascading style sheets of HTML. The CSS of GraphStream mostly follows the same rules, including inheritance and composition of styles. A style sheet is a sequence of styling rules. A styling rule is made of a selector and a set of style properties.");
    }
}
