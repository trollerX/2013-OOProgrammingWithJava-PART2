package farmsimulator;

import java.util.Random;

/**
 *
 * @author TrollerX
 */
public class Cow implements Alive, Milkable {

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private String name;
    private int capacity;
    private double amount;

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + new Random().nextInt(26);
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public void liveHour() {
        double toAdd = 0.7 + new Random().nextInt(14) / 10;
        if (toAdd + amount < capacity) {
            amount += toAdd;
            return;
        }
        amount = capacity;
    }

    @Override
    public double milk() {
        double milked = amount;
        amount = 0;
        return milked;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + capacity;
    }

}
