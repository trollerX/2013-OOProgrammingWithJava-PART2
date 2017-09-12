
import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) throws Exception {
//        System.out.println(digPow(92, 1));
        System.out.println(digPow(46288, 3));
    }

    public static long digPow(int n, int p) {
        char[] digits = Integer.toString(n).toCharArray();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += pow(Character.getNumericValue(digits[i]), (p + i));
        }
        if (sum % n == 0) {
            return sum / n;
        }
        return -1;
    }
}
