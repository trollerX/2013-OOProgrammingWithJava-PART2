package reader.criteria;

/**
 *
 * @author TrollerX
 */
public class Not implements Criterion {

    private Criterion c;

    public Not(Criterion c) {
        this.c = c;
    }
    
    
    @Override
    public boolean complies(String line) {
//        if(line.isEmpty()){
//            return false;
//        }
        return !c.complies(line);
    }
    
}
