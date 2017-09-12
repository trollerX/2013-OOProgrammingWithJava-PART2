/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karma
 */
public class CivilService implements NationalService {
    
    private int daysLeft;

    public CivilService() {
        this.daysLeft = 362;
    }
    
    public int getDaysLeft(){
        return daysLeft;
    }
    
    public void work(){
        if (daysLeft == 0) {
            return;
        }
        daysLeft--;
    }
    
    
    
    
}
