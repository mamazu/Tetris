
import Grafik.Grafik;
import Grafik.Menu.Bestenliste;
import Grafik.Menu.Hauptmenue;
import Grafik.Menu.Menue;
import Grafik.Menu.Mitwirkende;
import Grafik.Menu.Spielen;
import Grafik.Menu.Steuerung;
import Input.Maus;
import Input.Tastatur;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simon
 */
public class Spiel extends Canvas implements Runnable{
    private Grafik g;
    private Menue hm;
    private final Maus maus = new Maus();
    private final Tastatur tastatur = new Tastatur();
    private boolean ck = false;
    
    private JFrame frame;

    private Thread thread;
    
    
    public static void main(String args[]){
        Spiel s = new Spiel();
        //s.start();
        s.run();
    }
    
    public Spiel(){
        g = new Grafik();
        
        Dimension size = new Dimension(Grafik.getWIDTH(), Grafik.getHEIGHT());
        setPreferredSize(size);
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle(g.getTitel());
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);    
        
        hm = new Hauptmenue(Grafik.getWIDTH());
        addMouseListener(maus);
        addMouseMotionListener(maus);
        addKeyListener(tastatur);
        
    }
    
    public void update(){
        mausUpdate();
        
    }
    
    
    public void mausUpdate(){
        int nm = hm.mausUpdate(maus);
        if(ck)  nm = -1;
        if(!maus.getMaustasteStatus(1)) this.ck = false;
        //System.out.println(nm);
        switch(nm){
            case 0: this.hm = new Hauptmenue(Grafik.getWIDTH());    this.ck =true;    break;
            case 1: this.hm = new Spielen(Grafik.getWIDTH(), Grafik.getHEIGHT());   this.ck =true;  break;
            case 2: this.hm = new Bestenliste(Grafik.getWIDTH());   this.ck =true;  break;
            case 3: this.hm = new Steuerung(Grafik.getWIDTH()); this.ck =true;  break;
            case 4: this.hm = new Mitwirkende(400);   this.ck =true;  break;
            case 5: System.exit(0);
        }
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        hm.render(g, this.g);
        
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        
        
        g.dispose();
        bs.show();
    }

    
    public void run(){
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000 ){
                timer += 1000;
                System.out.println(updates + "ups, " + frames + "fps");
                updates = 0;
                frames = 0;
            }
        }
    }

    private void start() {
        thread = new Thread(this, "Display");
        thread.start();
    }
}
