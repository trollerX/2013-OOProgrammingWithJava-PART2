
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma
 */
public class Hand implements Comparable<Hand>{

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(this.hand);
        }
    
    @Override
    public int compareTo(Hand hand){
        int h1 = 0;
        int h2 = 0;
        
        for(Card card : this.hand){
            h1 += card.getValue();
        }
        
        for(Card card : hand.hand){
            h2 += card.getValue();
        }
        
        return h1 - h2;
        
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue());
//        for(Card card : hand){
//            System.out.println(card);
        }
    }
    
   
    
