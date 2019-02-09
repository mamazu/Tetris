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
    private int Fenster_Breite = 400;
    private int Fenster_Hoehe = 585;
    
    private Board Brett;
    private Color Feld[][];
    private int b;
    
    public Spielen(int b, int h){
        this.b = b;
        this.Fenster_Breite = b;
        this.Fenster_Hoehe = h;
        Brett = new Board();
        Feld = new Color[Brett.getDimension().height][Brett.getDimension().width];
        for(int i=0; i < Brett.getDimension().height; i++){
            for(int j=0; j < Brett.getDimension().width; j++){
                Feld[i][j] = Color.MAGENTA;
            }
        }
        
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
        
        g.drawRect(175, 110, 150, 66);  //Punkte
        g.drawRect(80, 110, 66, 66);    //nächster Stein
        
        //Spielfeld
        
        int rand = 50;
        int xx = 190;
        g.drawRect(rand, xx, this.Fenster_Breite-2*rand, this.Fenster_Hoehe-xx-rand);
        
        int bb = this.Fenster_Breite-2*rand;
        int hh = this.Fenster_Hoehe-xx-rand;
        int fff = Math.max((int) bb/Brett.getDimension().width, (int) hh/Brett.getDimension().height);
        
        for(int i=0; i< Brett.getDimension().width; i++){
            for(int j=0; j < Brett.getDimension().height; j++){
                g.setColor(Feld[j][i]);
                //g.fillRect(rand + i * ( (int) bb/Brett.getDimension().width), xx + j * ((int) hh/Brett.getDimension().height), (int) bb/Brett.getDimension().width, (int) hh/Brett.getDimension().height);
                g.fillRect(rand + i * (fff), xx + j * (fff), fff, fff);
                g.setColor(Color.BLACK);
                //g.drawRect(rand + i * ( (int) bb/Brett.getDimension().width), xx + j * ((int) hh/Brett.getDimension().height), (int) bb/Brett.getDimension().width, (int) hh/Brett.getDimension().height);
                g.drawRect(rand + i * (fff), xx + j * (fff), fff, fff);
            }   
        }
        
    }
}
