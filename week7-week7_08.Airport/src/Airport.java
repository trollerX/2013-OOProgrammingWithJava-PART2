
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma
 */
public class Airport {

    private HashMap<Airplane, ArrayList<Flight>> connections;

    public Airport() {
        this.connections = new HashMap<Airplane, ArrayList<Flight>>();
    }

    public void addPlane(Airplane plane) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        connections.put(plane, flights);
    }

    public void addFlight(String id, Flight flight) {
        for(Airplane plane : connections.keySet()){
            if(plane.getID().equals(id)){
                connections.get(plane).add(flight);
            }
        }
    }

    public void printPlanes() {
        for (Airplane plane : connections.keySet()) {
            System.out.println(plane);
        }
    }

    public void printFlights() {
        for (Airplane plane : connections.keySet()) {
            ArrayList<Flight> flights = connections.get(plane);
            for (Flight flight : flights) {
                System.out.print(plane);
                System.out.println(flight);
            }
        }
    }

    public void printPlaneInfo(String id) {
        for(Airplane plane : connections.keySet()){
            if(plane.getID().equals(id)){
                System.out.println(plane);
            }
        }
    }
}
