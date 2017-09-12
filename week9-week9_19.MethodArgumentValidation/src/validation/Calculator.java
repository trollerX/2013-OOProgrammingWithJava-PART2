package validation;

public class Calculator {

    public int multiplication(int fromInteger) {
        if(fromInteger < 0){
            throw new IllegalArgumentException("Number is less than 0.");
        }
        int multiplication = 1;
        for (int i = 1; i <= fromInteger; i++) {
            multiplication *= i;
        }

        return multiplication;
    }

    public int binomialCoefficient(int setSize, int subsetSize) {
        if(setSize < 0 || subsetSize < 0){
            throw new IllegalArgumentException("Argument is less than zero.");
        } else if(subsetSize > setSize) {
            throw new IllegalArgumentException("Subset is greater than set.");
        }
        int numerator = multiplication(setSize);
        int denominator = multiplication(subsetSize) * multiplication(setSize - subsetSize);

        return numerator / denominator;
    }
}
