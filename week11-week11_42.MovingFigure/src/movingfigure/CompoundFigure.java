package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author TrollerX
 */
public class CompoundFigure extends Figure {

    private ArrayList<Figure> figures;

    public CompoundFigure() {
        super(0, 0);
        this.figures = new ArrayList();
    }

    public void add(Figure f) {
        figures.add(f);
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure f : figures) {
            f.draw(graphics);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Figure f : figures) {
            f.move(dx, dy);
        }
    }

}
