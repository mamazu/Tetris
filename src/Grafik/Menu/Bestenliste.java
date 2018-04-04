/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik.Menu;

import Grafik.Grafik;
import Grafik.Knopf;
import Input.Maus;
import Score.Highscore;
import Score.Score;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Bestenliste extends Menue{
    
    private Knopf hm;
    private Highscore hs;
    private Score[] s;
    private int b;
    
    public Bestenliste(int b){
        this.b = b;
        hm  = new Knopf(b/2, 510, 250, 50, "Hauptmenü", Color.LIGHT_GRAY);
        hs_init();
    }
    
    public int mausUpdate(Maus m){
        boolean ck = m.getMaustasteStatus(1);
        if(hm.mausUpdate(m) && ck)  return 0;
        return -1;
    }
    
    public void render(Graphics g, Grafik gg){
        Grafik.clear(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        Grafik.drawStringMitte(g, "Tetris", b/2, 100);
        hm.render(g);
        
        //Highscore-Texte
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        int y_off = 175;
        int x_off = 50;
        Grafik.drawStringRechts(g, "Spieler", x_off, y_off);
        Grafik.drawStringLinks(g, "Punkte", this.b - x_off, y_off);
        Grafik.drawStringLinks(g, "#", x_off - 7, y_off);
        int abst = 20;
        for(int i=0; i<10; i++){
            Grafik.drawStringLinks(g, (i+1) + ".", x_off - 7, y_off + abst * (i+1));
            Grafik.drawStringRechts(g, this.s[i].getUsername(), x_off, y_off + abst *(i + 1));
            Grafik.drawStringLinks(g, this.s[i].getScore() + "", this.b - x_off, y_off + abst * (i + 1));
            
        }
    }
    
    public void hs_init(){
        this.hs = new Highscore("Tetris_Bestenliste");
        s = this.hs.getTop(10);
    }
    
}

