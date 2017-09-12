package file;

import java.io.File;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(zeros(99));
    }

    public static int zeros(int n) {
        // your code here
        BigInteger factorial = factorial(n);
        System.out.println("Factorial of: " + n + " is: " + factorial);
        String fStr = factorial.toString();
        System.out.println("String representation: " + fStr);
        System.out.println("Number of digits: " + fStr.length());
        int i = fStr.length() - 1;
        int zeros = 0;
        while (fStr.charAt(i) == '0') {
            zeros++;
            i--;
        }
        return zeros;
    }

    public static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
