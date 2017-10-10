package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author TrollerX
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        Random rand = new Random();
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (rand.nextDouble() < d) {
                    getBoard()[x][y] = true;
                } else {
                    getBoard()[x][y] = false;
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        try {
            return getBoard()[x][y];
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void turnToLiving(int x, int y) {
        try {
            getBoard()[x][y] = true;
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        try {
            getBoard()[x][y] = false;
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int ln = 0;
        boolean neighbour;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    neighbour = getBoard()[x + i][y + j];
                    if (x + i == x && y + j == y) {
                        continue;
                    }
//                    System.out.println("Point(x:" + (x + i) + ", y:" + (y + j) + "): " + neighbour);
                } catch (Exception e) {
                    continue;
                }
                if (neighbour == true) {
                    ln++;
                }
            }
        }
        return ln;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2) {
            getBoard()[x][y] = false;
        } else if (isAlive(x, y)) {
            if (livingNeighbours == 2 || livingNeighbours == 3) {
                getBoard()[x][y] = true;
            }
            if (livingNeighbours > 3) {
                getBoard()[x][y] = false;
            }
        } else if (!isAlive(x, y)) {
            if (livingNeighbours == 3) {
                getBoard()[x][y] = true;
            }
        }

    }
}
