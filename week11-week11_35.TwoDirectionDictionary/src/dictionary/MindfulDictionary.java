package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TrollerX
 */
public class MindfulDictionary {

    private Map<String, String> words;
    private String filepath;

    public MindfulDictionary() {
        this.words = new HashMap<String, String>();
    }

    public MindfulDictionary(String source) {
        this();
        this.filepath = source;
    }

    public boolean load() {
        Scanner fileReader;
        try {
            fileReader = new Scanner(new File(filepath));
        } catch (Exception e) {
            return false;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(":");
            words.put(parts[0], parts[1]);
        }
        return true;
    }

    public boolean save() {
        FileWriter writer;
        try {
            writer = new FileWriter(new File(filepath));
            StringBuilder str = new StringBuilder();
            for (String key : words.keySet()) {
                str.append(key).append(":").append(words.get(key)).append("\n");
            }
            writer.write(str.toString());
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }

    }

    public void add(String word, String translation) {
        if (words.containsKey(word)) {
            return;
        }
        words.put(word, translation);
    }

    public String translate(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        } else if (words.containsValue(word)) {
            for (String key : words.keySet()) {
                if (words.get(key).equals(word)) {
                    return key;
                }
            }
        }
        return null;
    }

    public void remove(String word) {
        String toRemove = "";
        if (words.containsKey(word)) {
            words.remove(word);
        } else if (words.containsValue(word)) {
            for (String key : words.keySet()) {
                if (words.get(key).equals(word)) {
                    toRemove = key;
                }
            }
        }
        words.remove(toRemove);
    }
}
