/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik.Menu;

import Exceptions.FeldgroesseFalschException;
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
        
        g.drawRect(260, 110, 126, 33);  //Punkte
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        Grafik.drawStringMitte(g, "0999999990", 323, 127);
        //g.drawRect(80, 110, 66, 66);    //nächster Stein
        
        //Spielfeld
        
        // => Breite: 300, Höhe: 345
        
        //g.drawRect(45, 100, 200, 400);
        
        assert Brett.getDimension().width == 10 && Brett.getDimension().height ==20: "Dimensionen des Spielbrettes passen nicht zur GUI!";
        //if(Brett.getDimension().width != 10 || Brett.getDimension().height != 20)   throw new FeldgroesseFalschException("Die Feldgroesse muss 20x10 betragen!");
        
        for(int i=0; i<20; i++){
            for(int j=0; j<10; j++){
                g.setColor(Feld[i][j]);
                g.fillRect(45 + j * 20, 100 + i * 20, 20, 20);
                g.setColor(Color.BLACK);
                g.drawRect(45+j*20, 100+i*20, 20, 20);
            }
        }
        
    }
}
