package com.michalsadowski.giz;

import com.michalsadowski.giz.gui.JForm;
import com.michalsadowski.giz.huffman.HuffmanEncoder;
import com.michalsadowski.giz.huffman.HuffmanRunner;
import com.michalsadowski.giz.huffman.HuffmanTreeBuilder;
import com.michalsadowski.giz.prufer.PruferEncoder;
import com.michalsadowski.giz.prufer.PruferRunner;

import javax.swing.*;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class Main {

    public static void main(String[] args) {
//
        HuffmanRunner runner = new HuffmanRunner(new HuffmanEncoder(), new HuffmanTreeBuilder());
//        runner.run("The syntax of a style sheet is very similar to the one seen in the cascading style sheets of HTML. The CSS of GraphStream mostly follows the same rules, including inheritance and composition of styles. A style sheet is a sequence of styling rules. A styling rule is made of a selector and a set of style properties.");
        runner.run("Test!");
        PruferRunner prunner = new PruferRunner(new PruferEncoder());
        prunner.encode(runner.getValuemap());

//        PruferCode code = new PruferCode();
//        code.setRootNode("1");
//        code.setIdentifierList(new String[] {"1", "3", "6", "11", "5", "5", "3", "6", "11"});
//        code.setNodeList(new String[] {"a", ";", "e", "c", "b", "d"});
//        PruferDecoder decoder = new PruferDecoder();
//        decoder.decode(code);

//
//        JFrame frame = new JFrame("GIZ");
//        frame.setContentPane(new JForm().getMainPanel());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
    }
}
