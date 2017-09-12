package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        WordInspection insp = new WordInspection(file);
        System.out.println("Word count: " + insp.wordCount());
        System.out.println("Words containing 'Z': " + insp.wordsContainingZ());
        System.out.println("Words ending with 'L': " + insp.wordsEndingInL());
        System.out.println("Words with all finish vowels: " + insp.wordsWhichContainAllVowels());
        System.out.println("Palindromes: " + insp.palindromes());

    }
}
