/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author simon
 */
public class Maus implements MouseMotionListener, MouseListener {
//Links -> 1; Mitte -> 2; Rechts -> 3
    private boolean status[] = new boolean[4];
    private Point pos = new Point(0,0);
    
    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        this.pos = me.getPoint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.pos = me.getPoint();
        this.status[me.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        status[me.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    public boolean getMaustasteStatus(int taste){
        return status[taste];
    }
    
    public Point getPos(){
        return this.pos;
    }
    
}
