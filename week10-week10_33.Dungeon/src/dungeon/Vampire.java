package dungeon;

import java.util.List;
import java.util.Random;

/**
 *
 * @author TrollerX
 */
public class Vampire extends Moveable {

    public Vampire(int col, int row) {
        super(col, row);
    }

    public boolean isMoveLegal(int height, int length, List<Vampire> others, char c) {
        if (c == 'w') {
            if (this.getRow() > 0) {
                for (Vampire v : others) {
                    if (v.getRow() == this.getRow() - 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        if (c == 's') {
            if (this.getRow() < height - 1) {
                for (Vampire v : others) {
                    if (v.getRow() == this.getRow() + 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        if (c == 'a') {
            if (this.getCol() > 0) {
                for (Vampire v : others) {
                    if (v.getCol() == this.getCol() - 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        if (c == 'd') {
            if (this.getCol() < length - 1) {
                for (Vampire v : others) {
                    if (v.getCol() == this.getCol() + 1) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "v " + getCol() + " " + getRow();
    }
}
