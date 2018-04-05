/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik.Menu;

import tools.Board;
import Grafik.Grafik;
import Input.Maus;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Spielen extends Menue{
    
    private Board Brett;
    private int b;
    
    public Spielen(int b){
        this.b = b;
    }
    
    public int mausUpdate(Maus m){
        return -1;
    }
    
    public void render(Graphics g, Grafik gg){
        
    }
}
