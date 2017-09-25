package farmsimulator;

/**
 *
 * @author TrollerX
 */
public class BulkTank {

    private double capacity;
    private double volume = 0;

    public BulkTank() {
        this(2000);
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public double howMuchFreeSpace() {
        return capacity - volume;
    }

    public void addToTank(double amount) {
        if (amount > howMuchFreeSpace()) {
            volume = capacity;
            return;
        }
        volume += amount;
    }

    public double getFromTank(double amount) {
        if (amount > volume) {
            volume = 0;
            return amount;
        }
        volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(getVolume()) + "/" + Math.ceil(getCapacity());
    }

}
