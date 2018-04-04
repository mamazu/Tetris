/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Grafik extends Canvas{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 585;
    private String Titel = "Tetris";
    
    

    
    public Grafik(){
    
    }
    
    public static int getWIDTH(){
        return Grafik.WIDTH;
    }
    
    public static int getHEIGHT(){
        return Grafik.HEIGHT;
    }
    
    
    public void render(){    
    }
    
    public void setTitel(String Titel){
        this.Titel = Titel;
    }
    
    public String getTitel(){
        return this.Titel;
    }
    
    public static void drawStringMitte(Graphics g, String S, int x, int y){
        FontMetrics m = g.getFontMetrics(g.getFont());
        int breit = m.stringWidth(S);
        int hoch = m.getDescent();
        int xx = x - breit/2;
        int yy = y + hoch/1;
        g.drawString(S, xx, yy);
    }
    
    public static void drawStringLinks(Graphics g, String S, int x, int y){
        FontMetrics m = g.getFontMetrics(g.getFont());
        int breit = m.stringWidth(S);
        int hoch = m.getDescent();
        int xx = x - breit;
        int yy = y + hoch;
        g.drawString(S, xx, yy);
    }
    
    public static void drawStringRechts(Graphics g, String S, int x, int y){
        FontMetrics m = g.getFontMetrics(g.getFont());
        int hoch = m.getDescent();
        int yy = y + hoch;
        g.drawString(S, x, yy);
    }
    
    public static void clear(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 585);
    }
}
