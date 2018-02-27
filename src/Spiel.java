
import Grafik.Grafik;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simon
 */
public class Spiel implements Runnable{
    private Grafik g;

    private Thread thread;
    
    
    public static void main(String args[]){
        Spiel s = new Spiel();
        //s.start();
        s.run();
    }
    
    public Spiel(){
        g = new Grafik();
        
    }
    
    public void update(){
        g.mausUpdate();
        
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
            g.render();
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
