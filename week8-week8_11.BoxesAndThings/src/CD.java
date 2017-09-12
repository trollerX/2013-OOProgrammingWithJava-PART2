/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karma
 */
public class CD implements ToBeStored { 
    
    private final String artist;
    private final String title;
    private final int year;
    private final double weight;

    public CD(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.weight = 0.1;
    }

    @Override
    public String toString() {
        return artist + ": " + title + " (" + year + ")";
    }

    @Override
    public double weight() {
        return weight;}
    
    
    
    
}
