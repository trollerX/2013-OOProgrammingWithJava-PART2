/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Karma
 */
public class Thermometer implements Sensor {

    private boolean isOn;
    private int temp;

    public Thermometer() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void on() {
        isOn = true;
    }

    @Override
    public void off() {
        isOn = false;
    }

    @Override
    public int measure() {
        if (isOn == true) {
            Random num = new Random();
            temp = num.nextInt(61) - 30;
            return temp;
        }
        throw new IllegalStateException("The thermometer is off.");
    }

}
