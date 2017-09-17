package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author TrollerX
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> strings;
    private int duplicates;

    public PersonalDuplicateRemover() {
        this.strings = new HashSet<String>();
    }

    @Override
    public void add(String characterString) {
        if (strings.contains(characterString)) {
            duplicates++;
        } else {
            strings.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicates;}

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return strings;
    }

    @Override
    public void empty() {
        strings.clear();
        duplicates = 0;
    }

}
