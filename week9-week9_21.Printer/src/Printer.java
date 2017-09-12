
import java.io.File;
import java.io.FileNotFoundException;
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
public class Printer {
    
    private final File file;

    public Printer(String filename) throws Exception {
        this.file = new File(filename);
    }

    public void printLinesWhichContain(String word) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        if (word.isEmpty()) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
        }
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
//            System.out.println("Line parsed: " + line);
//            System.out.println("Word is " + word);
            if (line.contains(word)) {
//                System.out.println("Line parsed in loop: " + line);
//                System.out.println("Word is: " + word);
//                System.out.print("Loop: ");
                System.out.println(line);
            }
        }

    }
}
