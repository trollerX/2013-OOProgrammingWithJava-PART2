package dungeon;

import java.util.Scanner;

/**
 *
 * @author TrollerX
 */
public abstract class Moveable {

    private int col;
    private int row;

    public Moveable(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void move(char c) {
        switch (c) {
            case 'w':
                setRow(getRow() - 1);
                break;
            case 's':
                setRow(getRow() + 1);
                break;
            case 'a':
                setCol(getCol() - 1);
                break;
            case 'd':
                setCol(getCol() + 1);
                break;
        }
    }
    
    public boolean locationEquals(Moveable m){
        return (this.getCol() == m.getCol() && this.getRow() == m.getRow());
    }
}
