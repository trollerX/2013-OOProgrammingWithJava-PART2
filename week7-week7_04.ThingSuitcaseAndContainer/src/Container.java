
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
public class Container {

    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Container(int weightLimit) {
        this.maxWeight = weightLimit;
        this.suitcases = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (maxWeight - totalWeight() < suitcase.totalWeight()) {
            return;
        }
        suitcases.add(suitcase);
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
    
    public int totalWeight(){
        int weight = 0;
        for(Suitcase suitcase : suitcases){
            weight += suitcase.totalWeight();
        }
        return weight;
    }
    
    public void printThings(){
        for(Suitcase suitcase: suitcases){
            suitcase.printThings();
        }
    }

}
