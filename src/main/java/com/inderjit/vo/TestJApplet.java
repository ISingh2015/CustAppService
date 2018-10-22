/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inderjit.vo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JApplet;

/**
 *
 * @author Zed
 */
public class TestJApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        System.out.println("Game Init");
        // TODO start asynchronous download of heavy resources
    }

    @Override
    public void paint(Graphics gr) {
        System.out.println("Game paint");        
        setBackground(Color.GRAY);
        gr.drawString("Loveliest of trees, the cherry now", 25, 30);
        gr.drawString("Is hung with bloom along the bough,", 25, 50);
        gr.drawString("And stands about the woodland ride", 25, 70);
        gr.drawString("Wearing white for Eastertide.", 25, 90);
        gr.drawString("--- A. E. Housman", 50, 130);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
