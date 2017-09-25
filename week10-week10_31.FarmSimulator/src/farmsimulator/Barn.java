package farmsimulator;

import java.util.Collection;

/**
 *
 * @author TrollerX
 */
public class Barn {
    
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot (MilkingRobot robot){
        this.robot = robot;
        robot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow){
        try{
            robot.milk(cow);
                  }
        catch (Exception e) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows){
        try{
            for(Cow cow : cows){
                robot.milk(cow);
            }
                  }
        catch (Exception e) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }

    @Override
    public String toString() {
        return tank.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
