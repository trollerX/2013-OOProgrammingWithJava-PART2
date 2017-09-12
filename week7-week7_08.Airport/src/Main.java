
import java.util.*;


public class Main {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        Airport connections = new Airport();
        UserInterface ui = new UserInterface(reader, connections);
        ui.start();
    }
}
