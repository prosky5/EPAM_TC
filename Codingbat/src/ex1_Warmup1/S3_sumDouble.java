package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S3_sumDouble {
    public static int sumDouble(int a, int b) {
        if (a == b) {
            return a * 4;
        } else {
            return a + b;
        }
    }

    public static void main(String[] args) {
        print("3 = " + sumDouble(1, 2));
        print("5 = " + sumDouble(3, 2));
        print("8 = " + sumDouble(2, 2));
    }
}
