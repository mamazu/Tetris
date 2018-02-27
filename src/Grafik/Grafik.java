/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import Grafik.Input.Maus;
import Grafik.Input.Tastatur;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
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
    private final Maus maus = new Maus();
    private final Tastatur tastatur = new Tastatur();
    
    private int Modus = 0;      //0 -> Init; 1-> Hauptmenü; 
    private Hauptmenue hm;
    
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
        
        addMouseListener(maus);
        addMouseMotionListener(maus);
        addKeyListener(tastatur);
        
        Modus = 1;
        hm = new Hauptmenue(Grafik.WIDTH);
        
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        
        //Zeichnen, Fkt
        if(Modus == 1)  hm.render(g);
        
        g.dispose();
        bs.show();
        
    }
    
    public void mausUpdate(){
        if(Modus == 1)  hm.mausUpdate(maus);
        
        if(this.maus.getMaustasteStatus(1)){
        }
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
