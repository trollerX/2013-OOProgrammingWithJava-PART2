package movingfigure;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author TrollerX
 */
public class KeyboardListener implements KeyListener {

    private Component component;
    private Figure figure;

    public KeyboardListener(Component component, Figure figure) {
        this.component = component;
        this.figure = figure;
    }
    
    

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            figure.move(-1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            figure.move(0,-1);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            figure.move(1,0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            figure.move(0,1);
        }
        
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
