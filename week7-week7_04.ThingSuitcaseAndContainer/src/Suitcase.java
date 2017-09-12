
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
public class Suitcase {

    private int maxWeight;
    private ArrayList<Thing> things;

    public Suitcase(int weightLimit) {
        this.maxWeight = weightLimit;
        this.things = new ArrayList<Thing>();
    }

    public void addThing(Thing thing) {
        if (maxWeight - totalWeight() < thing.getWeight()) {
            return;
        }
        things.add(thing);
    }

    @Override
    public String toString() {
        return numberOfThings() + "(" + totalWeight() + " kg)";
    }

    public int totalWeight() {
        int weight = 0;
        for (Thing thing : things) {
            weight += thing.getWeight();
        }
        return weight;
    }

    public String numberOfThings() {
        if (things.size() == 0) {
            return "empty ";
        } else if (things.size() == 1) {
            return "1 thing ";
        } else {
            return things.size() + " things ";
        }
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public Thing heaviestThing() {
        if(things.isEmpty()){
            return null;
        }
        Thing heaviest = null;
        for (Thing thing : things) {
            if (thing.getWeight() > heaviest.getWeight()) {
                heaviest = thing;
            }
        }
        return heaviest;
    }
}
