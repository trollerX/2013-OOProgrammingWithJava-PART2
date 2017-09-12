/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karma
 */
public class Flight {

    private Airplane plane;
    private String departureId;
    private String destinationId;

    public Flight(String departureCode, String destinationCode) {
        this.departureId = departureCode;
        this.destinationId = destinationCode;
    }

    @Override
    public String toString() {
        return " (" + departureId + "-" + destinationId + ")";
    }

}
