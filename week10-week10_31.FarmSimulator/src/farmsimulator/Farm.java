package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TrollerX
 */
public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public String animals() {
        if (cows.isEmpty()) {
            return "No cows.";
        }
        StringBuilder strB = new StringBuilder("");
        for (Cow cow : cows) {
            strB.append("        ");
            strB.append(cow).append("\n");
        }
        return strB.toString();
    }

    @Override
    public String toString() {
        return "Farm owner: " + owner + "\n"
                + "Barn bulk tank: " + barn.toString() + "\n"
                + "Animals:" + "\n"
                + animals();

    }

    @Override
    public void liveHour() {
        if (!cows.isEmpty()) {
            for (Cow cow : cows) {
                cow.liveHour();
            }
        }
    }

    public String getOwner() {
        return owner;
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
}


