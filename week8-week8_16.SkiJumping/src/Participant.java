
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
public class Participant implements Comparable<Participant> {

    private String name;
    private int points;
    private ArrayList<Integer> jumpLengths;

    public Participant(String name) {
        this.name = name;
        this.points = 0;
        this.jumpLengths = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + " (" + points + " points)";
    }

    @Override
    public int compareTo(Participant participant) {
        return this.points - participant.getPoints();
    }

    public void addPoints(int points) {
        this.points += points;
    }
    
    public void addJump(int jump){
        jumpLengths.add(jump);
    }
    
    public void returnJumps(){
        for(int jump : jumpLengths){
            System.out.print(jump + " m, ");
        }
    }
}
