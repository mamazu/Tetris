/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author simon
 */
public class Grafik extends Canvas{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 585;
    private String Titel = "Tetris";
    
    private JFrame frame;

    
    public Grafik(){
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle(Titel);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);        
    }
    
    public static int getWIDTH(){
        return Grafik.WIDTH;
    }
    
    public JFrame getJFrame(){
        return frame;
    }
    
    public void render(){    
    }
    
    public static void drawStringMitte(Graphics g, String S, int x, int y){
        FontMetrics m = g.getFontMetrics(g.getFont());
        int breit = m.stringWidth(S);
        int hoch = m.getDescent();
        int xx = x - breit/2;
        int yy = y + hoch/1;
        g.drawString(S, xx, yy);
    }
}
