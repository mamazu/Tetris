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
public class Steuerung extends Menue{
    
    private Knopf hm;
    private int b;
    
    public Steuerung(int b){
        this.b = b;
        hm = new Knopf(b/2, 510, 250, 50, "Hauptmenü", Color.LIGHT_GRAY);
    }
    
    public int mausUpdate(Maus m){
        boolean ck = m.getMaustasteStatus(1);
        if(hm.mausUpdate(m) && ck)  return 0;
        return -1;
    }
    
    public void render(Graphics g, Grafik gg){
        Grafik.clear(g);    //Init
        
        //Tetris-Ueberschrift
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        Grafik.drawStringMitte(g, "Tetris", b/2, 100);
        
        hm.render(g);
        
        //TODO
        
        g.setFont(new Font("Arial", Font.BOLD, 30));
        Grafik.drawStringMitte(g, "TODO", b/2, 300);
    }
}
