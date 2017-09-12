/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Karma
 */
public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;

    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for(Sensor sensor : sensors){
            if(!sensor.isOn()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        Random bool = new Random();
        for (Sensor sensor : sensors) {
            if (bool.nextBoolean() == false) {
                sensor.off();
            }
        }
        
    }

    public List<Integer> readings() {
        return readings;
    }

    @Override
    public int measure() {
        if (isOn() == false || sensors.isEmpty()) {
            throw new IllegalStateException("The sensor is off or has no available sensors.");
        }
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.measure();
        }
        int average = sum / sensors.size();
        readings.add(average);
        return average;
    }

}
