package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author TrollerX
 */
public class DrawingBoard extends JPanel implements Updatable {

    private WormGame game;
    private int side;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.side = pieceLength;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Piece p : game.getWorm().getPieces()) {
            g.fill3DRect(p.getX() * side, p.getY() * side, side, side, true);
        }

        g.setColor(Color.RED);
        g.fillOval(game.getApple().getX() * side, game.getApple().getY() * side, side, side);

    }

    @Override
    public void update() {
        repaint();
    }

}
