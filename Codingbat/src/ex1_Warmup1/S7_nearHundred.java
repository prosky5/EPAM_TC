package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S7_nearHundred {
    public static boolean nearHundred(int n) {
        if ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        print("True : " + nearHundred(93));
        print("True : " + nearHundred(90));
        print("False : " + nearHundred(83));
        print("False : " + nearHundred(89));
    }
}
