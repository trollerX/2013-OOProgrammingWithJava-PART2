
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
public class TextUserInterface {

    private Scanner reader;
    private Dictionary dict;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dict = dictionary;
    }

    public void start() {
        System.out.println("Statements:");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - asks a word and prints its translation");
        System.out.println("quit - quits the text user interface");
        while (true) {
            System.out.print("Statement: ");
            String input = reader.nextLine();
            if (input.equals("add")) {
                add();
            } else if (input.equals("translate")) {
                translate();
            } else if (input.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
        }
    }
    
    public void add() {
        System.out.print("In Finnish: ");
        String word1 = reader.nextLine();
        System.out.print("Translation: ");
        String word2 = reader.nextLine();
        dict.add(word1, word2);
    }

    public void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();

        System.out.println(dict.translate(word));
    }

}
