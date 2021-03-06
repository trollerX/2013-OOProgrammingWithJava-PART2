package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TrollerX
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history;

    public ProductContainerRecorder(String name, double capacity, double initialVolume) {
        super(name, capacity);
        this.history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + history.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public String history() {
        return history.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        history.add(getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double value = super.takeFromTheContainer(amount);
        history.add(getVolume());
        return value;
    }

    public void printAnalysis() {
        System.out.println("Product: " + getName());
        System.out.println("History: " + history);
        System.out.println("Greatest product amount: " + history.maxValue());
        System.out.println("Smallest product amount: " + history.minValue());
        System.out.println("Average: " + history.average());
        System.out.println("Greatest change: " + history.greatestFluctuation());
        System.out.println("Variance: " + history.variance());
    }
}
