package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {

        super(1000, null);
        worm = new Worm(width / 2, height / 2, Direction.DOWN);

        this.width = width;
        this.height = height;
        this.continues = true;
        newApple();

        addActionListener(this);
        setInitialDelay(2000);

    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            newApple();
        }
        if (worm.runsIntoItself() || wormHitsBorder()) {
            continues = false;
        }
        

        updatable.update();
        setDelay(1000 / worm.getLength());
        return;
    }

    public void newApple() {
        apple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
        if (worm.runsInto(apple)) {
            newApple();
        }
    }
    
    private boolean wormHitsBorder(){
        for(Piece p : worm.getPieces()){
            if(p.getY() == height || p.getX() == width || p.getX() == -1 || p.getY() == -1){
                return true;
            }
        }
        return false;
    }

}
