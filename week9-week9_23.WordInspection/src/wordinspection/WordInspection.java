package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TrollerX
 */
public class WordInspection {

    private final ArrayList<String> contents;

    public WordInspection(File file) throws Exception {
        contents = readFile(file);
    }

    public ArrayList<String> readFile(File file) throws Exception {
        ArrayList<String> contents = new ArrayList<String>();

        Scanner reader = new Scanner(file, "UTF-8");
        while (reader.hasNext()) {
            contents.add(reader.next());
        }
        return contents;
    }

    public int wordCount() {
        return contents.size();
    }

    public List<String> wordsContainingZ() {
        ArrayList<String> Z = new ArrayList<String>();
        for (String word : contents) {
            if (word.contains("z")) {
                Z.add(word);
            }
        }
        return Z;
    }

    public List<String> wordsEndingInL() {
        ArrayList<String> L = new ArrayList<String>();
        for (String word : contents) {
            if (word.charAt(word.length() - 1) == 'l') {
                L.add(word);
            }
        }
        return L;
    }

    public List<String> palindromes() {
        ArrayList<String> palindromes = new ArrayList<String>();
        for (String word : contents) {
            StringBuilder strB = new StringBuilder(word);
            if (word.equals(strB.reverse().toString())) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public List<String> wordsWhichContainAllVowels() {
        ArrayList<String> vowels = new ArrayList<String>();
        for (String word : contents) {
            if (word.contains("a") && word.contains("e") && word.contains("i")
                    && word.contains("o") && word.contains("u") && word.contains("y")
                    && word.contains("ä") && word.contains("ö")) {
                vowels.add(word);
            }
        }
        return vowels;
    }
}
