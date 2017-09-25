package dungeon;

/**
 *
 * @author TrollerX
 */
public class Player extends Moveable {

    public Player() {
        super(0, 0);
    }
    
    public boolean isMoveLegal(int height, int length, char c) {
        if (c == 'w') {
            return this.getRow() > 0;
        }
        if (c == 's') {
            return this.getRow() < height - 1;
        }
        if (c == 'a') {
            return this.getCol() > 0;
        }
        if (c == 'd') {
            return this.getCol() < length - 1;
        }
        return false;
    }

    @Override
    public String toString() {
        return "@ " + getCol() + " " + getRow();
    }

       
}
