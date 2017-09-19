package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TrollerX
 */
public class Group implements Movable {
    
    private List<Movable> group;

    public Group() {
        this.group = new ArrayList<Movable>();
    }
    
    public void addToGroup (Movable movable){
       group.add(movable); 
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable movable : group){
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Movable movable : group){
            str.append(movable).append("\n");
        }
        return str.toString();
    }
    
    
    
}
