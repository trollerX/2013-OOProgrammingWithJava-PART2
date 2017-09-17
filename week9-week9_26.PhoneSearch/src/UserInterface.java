
import java.util.Scanner;

/**
 *
 * @author TrollerX
 */
public class UserInterface {

    private Scanner reader;
    private Directory directory;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.directory = new Directory();
    }

    public void start() {
        System.out.println("phone search \n"
                + "available operations \n"
                + " 1 add a number \n"
                + " 2 search for a number \n"
                + " 3 search for a person by phone number \n"
                + " 4 add an address \n"
                + " 5 search for personal information \n"
                + " 6 delete personal information \n"
                + " 7 filtered listing \n"
                + " x quit");

        System.out.println("");

        while (true) {
            System.out.print("command: ");
            String input = reader.nextLine();

            if (input.equals("x")) {
                break;
            }
            handleInput(Integer.parseInt(input));
            System.out.println("");
        }
    }

    private void handleInput(int input) {
        String name;
        String number;
        String address;
        switch (input) {
            case 1:
                System.out.print("whose number: ");
                name = reader.nextLine();
                System.out.print("number: ");
                number = reader.nextLine();
                directory.addANumber(name, number);
                break;
            case 2:
                System.out.print("whose number: ");
                directory.searchForNumber(reader.nextLine());
                break;
            case 3:
                System.out.print("number: ");
                directory.searchForAPersonByPhoneNumber(reader.nextLine());
                break;
            case 4:
                System.out.print("whose address: ");
                name = reader.nextLine();
                System.out.print("street: ");
                address = reader.nextLine();
                System.out.print("city: ");
                address += " " + reader.nextLine();
                directory.addAddress(name, address);
                break;
            case 5:
                System.out.print("whose information: ");
                System.out.println(directory.searchForPersonalInformation(reader.nextLine()));
                break;
            case 6:
                System.out.print("whose information: ");
                directory.deletePersonalInformation(reader.nextLine());
                break;
            case 7:
                System.out.print("keyword (if empty, all listed): ");
                directory.filteredListing(reader.nextLine());
                break;
        }
    }
}
