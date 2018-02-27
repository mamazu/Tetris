/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import Grafik.Input.Maus;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Hauptmenue {
    private Knopf Spielen;
    private Knopf Bestenliste;
    private Knopf Steuerung;
    private Knopf Mitwirkende;
    private Knopf Beenden;
    private int b;
    
    public Hauptmenue(int GesBreite){
        this.b = GesBreite;
        Spielen = new Knopf(b/2, 190, 250, 50, "Spielen");  //x, y, Breite, Höhe, Text, Hintergrundfarbe, Rahmenfarbe, Textfarbe
        Bestenliste = new Knopf(b/2, 270, 250, 50, "Bestenliste");
        Steuerung = new Knopf(b/2, 350, 250, 50, "Steuerung");
        Mitwirkende = new Knopf(b/2, 430, 250, 50, "Bestenliste");
        Beenden = new Knopf(b/2, 510, 250, 50, "Beenden");
    }
    
    public int mausUpdate(Maus m){
        Spielen.mausUpdate(m);
        Bestenliste.mausUpdate(m);
        Steuerung.mausUpdate(m);
        Mitwirkende.mausUpdate(m);
        Beenden.mausUpdate(m);
        return 0;
    }
    
    public void render(Graphics g){
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