package boxes;

import java.util.Arrays;

/**
 *
 * @author TrollerX
 */
public class OneThingBox extends Box {

    private Thing oneThing;

    public OneThingBox() {
        this.oneThing = null;
    }

    @Override
    public void add(Thing thing) {
        if (this.oneThing == null) {
            oneThing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(oneThing == null){
            return false;
        }
        return (oneThing.equals(thing));
    }

}
