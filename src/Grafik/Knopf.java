/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import Grafik.Input.Maus;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author simon
 */
public class Knopf {
    private int x, y;       //Mittelpunkt des Knopfes
    private int x2, y2;     //Höhe, Breite
    private String Text;
    private Color HgFarbe, RFarbe, SFarbe;
    private String Hover;
    private boolean hover = false;
    private boolean aktiv;
    private Font font;
    private Color aktFarbe;
    
    public Knopf(int x, int y, int xx, int yy, String T, Color Hg, Color R, Color S){
        this.x = x;
        this.y = y;
        this.x2 = xx;
        this.y2 = yy;
        this.Text = T;
        this.HgFarbe = Hg;
        this.RFarbe = R;
        this.SFarbe = S;
        
        this.font = new Font("Arial", Font.PLAIN, 12);        //TimesRoman
        this.aktFarbe = Color.GREEN;
        this.aktiv = false;
    }
    
    public Knopf(int x, int y, int xx, int yy, String T, Color Hg){
        this(x, y, xx, yy, T, Hg, Color.BLACK, Color.BLACK);
    }
    
    public Knopf(int x, int y, int xx, int yy, String T){
        this(x, y, xx, yy, T, Color.WHITE, Color.BLACK, Color.BLACK);
    }
    
    public void setHintergrund(Color C){
        this.HgFarbe = C;
    }
    
    public void setHoverText(String ht){
        hover = true;
        Hover = ht;
        
    }
    
    public void disableHoverText(){
        hover = false;
    }
    
    public void setFont(Font f){
        this.font = f;
    }
    
    public void render(Graphics g){
        if(this.aktiv == true)  g.setColor(this.aktFarbe);
        else            g.setColor(this.HgFarbe);
        int xx = this.x - this.x2 / 2;
        int yy = this.y - this.y2 / 2;
        g.clearRect(xx, yy, x2, y2);  //Rechteck an x,y mit Länge x2, Höhe y2
        g.setColor(this.RFarbe);
        g.drawRect(xx, yy, x2, y2);
        g.setColor(this.SFarbe);
        g.setFont(this.font);
        FontMetrics m = g.getFontMetrics(this.font);
        int breit = m.stringWidth(this.Text);
        int hoch = m.getDescent();
        xx = this.x - breit/2;
        yy = this.y + hoch/1;
        String T;
        if(this.hover)  T = this.Hover;
        else            T = this.Text;
        g.drawString(T, xx, yy);
           
    }
    
    public boolean mausUpdate(Maus m){
        int xx = m.getPos().x;
        int yy = m.getPos().y;
        
        if(xx >= (this.x -this.x2/2) && xx <= (this.x + this.x2/2)){
            if(yy >= (this.y - this.y2/2) && yy <= (this.y + this.y2/2)){
                this.aktiv = true;
                System.out.println("true xx");
                return true;
            }
        }
        
        System.out.println("False xx");
        return false;
    }
    
    
    
}