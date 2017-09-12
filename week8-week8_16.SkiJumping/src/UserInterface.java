
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma
 */
public class UserInterface {

    private Scanner reader;
    private ArrayList<Participant> jumpingOrder;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        this.jumpingOrder = new ArrayList<Participant>();
    }

    private void participants() {
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            jumpingOrder.add(new Participant(name));
        }
    }

    private void tournament() {
        int i = 1;
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
        System.out.print("Write \"jump\" to jump; "
                + "otherwise you quit: ");
        while (reader.nextLine().equals("jump")) {
            System.out.println("");
            System.out.println("Round " + i);
            System.out.println("");
            System.out.println("Jumping order:");
            Collections.sort(jumpingOrder, new AscendingOrder());
            jumpingOrder();
            System.out.println("");
            System.out.println("Results of round " + i);
            roundResults();
            i++;
            System.out.println("");
            System.out.print("Write \"jump\" to jump; "
                    + "otherwise you quit: ");
        }
    }

    private void roundResults() {
        for (int i = 0; i < jumpingOrder.size(); i++) {
            System.out.println("  " + jumpingOrder.get(i).getName());
            int length = length();
            jumpingOrder.get(i).addJump(length);
            System.out.println("    length: " + length);
            ArrayList<Integer> votes = judgeVotes();
            System.out.println("    judge votes: " + votes);
            jumpingOrder.get(i).addPoints(length + votes.get(1) + votes.get(2) + votes.get(3));
        }
    }

    private int length() {
        Random rand = new Random();
        int length = rand.nextInt(61) + 60;
        return length;
    }

    private ArrayList<Integer> judgeVotes() {
        ArrayList<Integer> votes = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            votes.add(rand.nextInt(11) + 10);
        }
        Collections.sort(votes);
        return votes;
    }

    private void jumpingOrder() {
        int j = 1;
        for (Participant participant : jumpingOrder) {
            System.out.println("  " + j + ". " + participant);
            j++;
        }
    }

    private void finalResults() {
        Collections.sort(jumpingOrder, new DescendingOrder());
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        for (int i = 0; i < jumpingOrder.size(); i++) {
            System.out.print(i+1);
            System.out.println("           " + jumpingOrder.get(i));
            System.out.print("            jump lengths: ");
            jumpingOrder.get(i).returnJumps();
            System.out.println("");
        }

    }

    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants "
                + "one at a time; an empty string brings you "
                + "to the jumping phase.");
        participants();
        tournament();
        finalResults();
    }
}
