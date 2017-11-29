package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S6_makes10 {
    public static boolean makes10(int a, int b) {
        if (a == 10 || b == 10 || a + b == 10) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        print("True : " + makes10(9, 10));
        print("False : " + makes10(9, 9));
        print("True : " + makes10(1, 9));
    }
}
