
/**
 *
 * @author TrollerX
 */
public class Calculator {
    
    private int result;

    public Calculator() {
        this.result = 0;
    }
    
    public void add(int value){
        this.result += value;
    }
    
    public void subtract(int value){
        this.result -= value;
    }
    
    public void setToZero(){
        result = 0;
    }
    
    public int giveValue(){
        return result;
    }
}
