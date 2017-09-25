package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TrollerX
 */
public class MaxWeightBox extends Box {

    private int maxWeight;
    private List<Thing> contents;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<Thing>();
    }

    public int getWeight(){
        int sum = 0;
        for(Thing thing : contents){
            sum += thing.getWeight();
        }
        return sum;
    }
    @Override
    public void add(Thing thing) {
        if (thing.getWeight() + this.getWeight() <= this.maxWeight) {
            contents.add(thing);
            
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return (contents.contains(thing));
    }

}
