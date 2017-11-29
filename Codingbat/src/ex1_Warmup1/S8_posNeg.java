package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S8_posNeg {
    public static boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        } else {
            return (a < 0 ^ b < 0);
        }
    }

    public static void main(String[] args) {
        print("True : " + posNeg(1, -1, false));
        print("True : " + posNeg(-1, 1, false));
        print("True : " + posNeg(-4, -5, true));
        print("False : " + posNeg(1, 1, true));
        print("False : " + posNeg(4, 5, true));
        print("False : " + posNeg(4, -5, true));
        print("False : " + posNeg(-4, -5, false));
    }
}
