
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma
 */
public class Box implements ToBeStored {

    private final double maxWeight;
    private ArrayList<ToBeStored> contents;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored thing) {
        if (weight() + thing.weight() > maxWeight) {
            return;
        }
        contents.add(thing);
    }

    @Override
    public double weight() {
        double weight = 0.0;
        for (ToBeStored thing : contents) {
            weight += thing.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + contents.size() + " things, total weight " + weight() + " kg";
    }

}
