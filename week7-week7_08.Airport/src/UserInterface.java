
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
public class UserInterface {

    private Scanner reader;
    private Airport connections;

    public UserInterface(Scanner reader, Airport connections) {
        this.reader = reader;
        this.connections = connections;
    }

    public void start() {
        airportPanel();
        flightService();
    }

    private void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        panelInput();
    }

    private void flightService() {
        System.out.println("Flight service");
        System.out.println("--------------------");
        System.out.println("");
        serviceInput();
    }

    private void panelInput() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");

            String input = reader.nextLine();

            if (input.equals("x")) {
                break;
            } else if (input.equals("1")) {
                addPlane();
            } else if (input.equals("2")) {
                addFlight();
            }
        }
    }

    private void serviceInput() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");

            String input = reader.nextLine();

            if (input.equals("x")) {
                return;
            } else if (input.equals("1")) {
                connections.printPlanes();
            } else if (input.equals("2")) {
                connections.printFlights();
            } else if (input.equals("3")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                connections.printPlaneInfo(id);
            }
        }
    }

    private void addPlane() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        Airplane plane = new Airplane(id, capacity);
        connections.addPlane(plane);
    }

    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departure = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = reader.nextLine();
        Flight flight = new Flight(departure, destination);

        connections.addFlight(id, flight);
    }

}
