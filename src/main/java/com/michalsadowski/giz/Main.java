package com.michalsadowski.giz;

import com.michalsadowski.giz.gui.JForm;

import javax.swing.*;

/**
 * Created by sadowsm3 on 19.05.2018
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GIZ");
        frame.setContentPane(new JForm().getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
