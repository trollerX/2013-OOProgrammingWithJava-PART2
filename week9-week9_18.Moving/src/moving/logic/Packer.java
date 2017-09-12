/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author Karma
 */
public class Packer {

    private int boxesVolume;
    private ArrayList<Box> boxes;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        this.boxes = new ArrayList<Box>();
    }

    public List<Box> packThings(List<Thing> things) {
        Box box = new Box(boxesVolume);

        int maxCapacity = box.getMaxCapacity();
        int i = 0;

        while (i < things.size()) {
            if (box.getVolume() + things.get(i).getVolume() <= maxCapacity) {
                box.addThing(things.get(i));
                i++;
            } else {
                boxes.add(box);
                box = new Box(boxesVolume);
            }
        }
        boxes.add(box);
        return boxes;
    }
}
