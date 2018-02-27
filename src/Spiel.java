
import Grafik.Grafik;
import Grafik.Hauptmenue;
import Input.Maus;
import Input.Tastatur;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


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
    private Hauptmenue hm;
    
    private final Maus maus = new Maus();
    private final Tastatur tastatur = new Tastatur();

    private Thread thread;
    
    
    public static void main(String args[]){
        Spiel s = new Spiel();
        //s.start();
        s.run();
    }
    
    public Spiel(){
        g = new Grafik();
        hm = new Hauptmenue(Grafik.getWIDTH());
        addMouseListener(maus);
        addMouseMotionListener(maus);
        addKeyListener(tastatur);
        
    }
    
    public void update(){
        mausUpdate();
        
    }
    
    public void mausUpdate(){
        
    }
    
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        Graphics g = bs.getDrawGraphics();
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
