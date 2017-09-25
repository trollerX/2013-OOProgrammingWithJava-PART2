
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        FileManager t = new FileManager();
//
//        for (String line : t.read("src/testinput1.txt")) {
//            System.out.println(line);
//        }
        int[][] arr = new int[3][3];
        int k = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                arr[row][col] = k;
                k++;
                printArray(arr);
            }
        }

    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("***");
    }
}
