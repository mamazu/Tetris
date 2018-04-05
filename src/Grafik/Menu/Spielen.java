/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik.Menu;

import tools.Board;
import Grafik.Grafik;
import Input.Maus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Spielen extends Menue{
    
    private Board Brett;
    private Color Feld[][];
    private int b;
    
    public Spielen(int b){
        this.b = b;
        Brett = new Board();
        Feld = new Color[Brett.getDimension().height][Brett.getDimension().width];
        
    }
    
    public int mausUpdate(Maus m){
        return -1;
    }
    
    public void render(Graphics g, Grafik gg){
        Grafik.clear(g);    //Init
        
        //Tetris-Ueberschrift
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        Grafik.drawStringMitte(g, "Tetris", b/2, 60);
        
        g.drawRect(175, 110, 150, 66);
        g.drawRect(80, 110, 66, 66);
        
        int rand = 40;
        int xx = 190;
        g.drawRect(rand, xx, 400-2*rand, 585-xx-rand);
        
    }
}
