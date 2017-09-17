
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author TrollerX
 */
public class Directory {

    private Map<String, Set<String>> phoneBook;
    private Map<String, Set<String>> addressBook;

    public Directory() {
        this.phoneBook = new HashMap<String, Set<String>>();
        this.addressBook = new HashMap<String, Set<String>>();
    }

    private boolean hasAddress(String person) {
        return !(!addressBook.containsKey(person) || addressBook.get(person).isEmpty());
    }

    private boolean hasPhoneNumber(String person) {
        return !(!phoneBook.containsKey(person) || phoneBook.get(person).isEmpty());
    }

    public boolean exists(String person) {
        return !(!addressBook.containsKey(person) && !phoneBook.containsKey(person));
    }

    public void addANumber(String person, String phoneNumber) {
        if (!phoneBook.containsKey(person)) {
            phoneBook.put(person, new HashSet<String>());
        }
        phoneBook.get(person).add(phoneNumber);
    }

    public void searchForNumber(String person) {
        if (!phoneBook.containsKey(person) || phoneBook.get(person).isEmpty()) {
            System.out.println("  not found");
        } else {
            for (String num : phoneBook.get(person)) {
                System.out.println(" " + num);
            }
        }
    }

    public void searchForAPersonByPhoneNumber(String num) {
        for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).contains(num)) {
                System.out.println(" " + key);
                return;
            }
        }
        System.out.println(" not found");
    }

    public void addAddress(String person, String address) {
        if (!addressBook.containsKey(person)) {
            addressBook.put(person, new HashSet<String>());
        }
        addressBook.get(person).add(address);
    }

    public String searchForPersonalInformation(String person) {
        if (!exists(person)) {
            return ("  not found");
        }
        StringBuilder result = new StringBuilder();
        if (hasAddress(person)) {
            result.append("  address: ");
            result.append(addressBook.get(person)).append("\n");
        } else {
            result.append("  address unknown").append("\n");
        }
        if (hasPhoneNumber(person)) {
            result.append("  phone numbers:").append("\n");
            for (String num : phoneBook.get(person)) {
                result.append("   ").append(num).append("\n");
            }
        } else {
            result.append("  phone number not found");
        }
        return result.toString();
    }

    public void deletePersonalInformation(String person) {
        phoneBook.remove(person);
        addressBook.remove(person);
    }

    public void filteredListing(String keyword) {

        System.out.println("");
        StringBuilder str;
        Set<String> filtered = new HashSet<String>();

        if (keyword.isEmpty()) {
            for (String key : phoneBook.keySet()) {
                filtered.add(searchForPersonalInformation(key));
            }
            for (String key : addressBook.keySet()) {
                filtered.add(searchForPersonalInformation(key));
            }
        }

        for (String keyInPhone : phoneBook.keySet()) {
            if (keyInPhone.contains(keyword)) {
                str = new StringBuilder();
                str.append(" ").append(keyInPhone).append("\n");
                str.append(searchForPersonalInformation(keyInPhone));
                filtered.add(str.toString());
            }
        }
        for (String keyInPhone : phoneBook.keySet()) {
            for (String value : phoneBook.get(keyInPhone)) {
                if (value.contains(keyword)) {
                    str = new StringBuilder();
                    str.append(" ").append(keyInPhone).append("\n");
                    str.append(searchForPersonalInformation(keyInPhone));;
                    filtered.add(str.toString());
                }
            }
        }
        for (String keyInAddress : addressBook.keySet()) {
            if (keyInAddress.contains(keyword)) {
                str = new StringBuilder();
                str.append(" ").append(keyInAddress).append("\n");
                str.append(searchForPersonalInformation(keyInAddress));
                filtered.add(str.toString());
            }
        }
        for (String keyInAddress : addressBook.keySet()) {
            for (String value : addressBook.get(keyInAddress)) {
                if (value.contains(keyword)) {
                    str = new StringBuilder();
                    str.append(" ").append(keyInAddress).append("\n");
                    str.append(searchForPersonalInformation(keyInAddress));;
                    filtered.add(str.toString());
                }
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("  not found");
            return;
        }

        List sorted = new ArrayList(filtered);
        Collections.sort(sorted);
        for (Object s : sorted) {
            System.out.println("");
            System.out.println(s);
        }
    }

}
