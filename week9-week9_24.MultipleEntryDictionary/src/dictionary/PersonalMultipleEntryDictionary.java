package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author TrollerX
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dictionary;

    public PersonalMultipleEntryDictionary() {
        this.dictionary = new HashMap<String, Set<String>>();
    }

    @Override
    public void add(String word, String entry) {
        if (!dictionary.containsKey(word)) {
            dictionary.put(word, new HashSet<String>());
        }
        dictionary.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        return dictionary.get(word);
    }

    @Override
    public void remove(String word) {
        dictionary.remove(word);
    }

}
