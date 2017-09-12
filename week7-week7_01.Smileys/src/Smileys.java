
public class Smileys {

    private static void printWithSmileys(String characterString) {
        if (characterString.length() % 2 == 1) {
            characterString += " ";
        }
        int length = characterString.length();
        int width = length + 2 + 4;
        String smileys = "";
        while (smileys.length() < width) {
            smileys += ":)";
        }
        System.out.println(smileys);
        System.out.println(":) " + characterString + " :)");
        System.out.println(smileys);
    }

    public static void main(String[] args) {
//         Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }

}
