
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karma
 */
public class AscendingOrder implements Comparator<Participant> {
    public int compare(Participant p1, Participant p2){
        return p1.getPoints() - p2.getPoints();
    }
}
