/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author Karma
 */
public class Box implements Thing {

    private final int maxCapacity;
    private int volumeTaken;
    private ArrayList<Thing> contents;

    public Box(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.volumeTaken = 0;
        this.contents = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if (volumeTaken + thing.getVolume() <= maxCapacity) {
            contents.add(thing);
            volumeTaken += thing.getVolume();

            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        return volumeTaken;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
