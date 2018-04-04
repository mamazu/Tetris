/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik.Menu;

import Grafik.Grafik;
import Grafik.Knopf;
import Input.Maus;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Hauptmenue extends Menue{
    private Knopf Spielen;
    private Knopf Bestenliste;
    private Knopf Steuerung;
    private Knopf Mitwirkende;
    private Knopf Beenden;
    private int b;
    
    public Hauptmenue(int GesBreite){
        this.b = GesBreite;
        Spielen = new Knopf(b/2, 190, 250, 50, "Spielen", Color.LIGHT_GRAY);  //x, y, Breite, Höhe, Text, Hintergrundfarbe, Rahmenfarbe, Textfarbe
        Bestenliste = new Knopf(b/2, 270, 250, 50, "Bestenliste", Color.LIGHT_GRAY);
        Steuerung = new Knopf(b/2, 350, 250, 50, "Steuerung", Color.LIGHT_GRAY);
        Mitwirkende = new Knopf(b/2, 430, 250, 50, "Mitwirkende", Color.LIGHT_GRAY);
        Beenden = new Knopf(b/2, 510, 250, 50, "Beenden", Color.LIGHT_GRAY);
        Beenden.setHoverText("Geh nicht :'(");
    }
    
    /**
     *
     * @param m
     * @return
     */
    @Override
    public int mausUpdate(Maus m){
        int r = -1;
        boolean ck = m.getMaustasteStatus(1);
        if( Spielen.mausUpdate(m) && ck )   r = 1;
        if( Bestenliste.mausUpdate(m) && ck )   r = 2;
        if( Steuerung.mausUpdate(m) && ck ) r = 3;
        if( Mitwirkende.mausUpdate(m) && ck )   r = 4;
        if(Beenden.mausUpdate(m) && ck)   r = 5;
        return r;
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void render(Graphics g, Grafik gg){
        Grafik.clear(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        Grafik.drawStringMitte(g, "Tetris", b/2, 100);
        Spielen.render(g);
        Bestenliste.render(g);
        Steuerung.render(g);
        Mitwirkende.render(g);
        Beenden.render(g);
    }
}


//GesHöhe: 585
//GesBreite: 400