package reader.criteria;

/**
 *
 * @author TrollerX
 */
public class LengthAtLeast implements Criterion {

    private int length;

    public LengthAtLeast(int length) {
        this.length = length;
    }
    
    @Override
    public boolean complies(String line) {
       return line.length() >= length;
    }
    
}
