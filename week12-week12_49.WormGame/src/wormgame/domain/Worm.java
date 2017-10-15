package wormgame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import wormgame.Direction;

/**
 *
 * @author TrollerX
 */
public class Worm {

    private Direction direction;
    private List<Piece> pieces;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        this.direction = originalDirection;
        grow = true;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return getPieces().size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        if (grow == false) {
            addSegment();
            removeLastSegment();
        } else if (grow == true) {
            addSegment();
            if (pieces.size() > 2) {
                grow = false;
            }
        }
    }

    public void grow() {
        grow = true;
    }

    private void removeLastSegment() {
        pieces.remove(0);
    }

    private void addSegment() {
        Piece head = getWormHead();
        Direction dir = getDirection();

        switch (dir) {
            case DOWN: {
                pieces.add(new Piece(head.getX(), head.getY() + 1));
                break;
            }
            case LEFT: {
                pieces.add(new Piece(head.getX() - 1, head.getY()));
                break;
            }
            case RIGHT: {
                pieces.add(new Piece(head.getX() + 1, head.getY()));
                break;
            }
            case UP: {
                pieces.add(new Piece(head.getX(), head.getY() - 1));
                break;
            }
            default:
                break;
        }
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : this.getPieces()) {
            if (p.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
//        Piece head = returnHead();
//        for (int i = 0; i < worm.size() - 1; i++) {
//            if (head.runsInto(worm.get(i))) {
//                return true;
//            }
//        }
//        return false;

        Set<Piece> wormSet = new HashSet<Piece>(pieces);
        return wormSet.size() < pieces.size();
    }

//    public boolean hitsBorder(int width, int height) {
//        Piece head = getWormHead();
//        if (head.getX() == 0 && direction == Direction.LEFT) {
//            return true;
//        } else if (head.getY() == 0 && direction == Direction.UP) {
//            return true;
//        } else if (head.getX() == width && direction == Direction.RIGHT) {
//            return true;
//        } else if (head.getY() == height && direction == Direction.DOWN) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public Piece getWormHead() {
        return pieces.get(pieces.size() - 1);
    }
//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        for (Piece p : worm) {
//            str.append(p.toString());
//        }
//        return str.toString();
//    }
//    }
}
