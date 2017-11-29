package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S4_diff21 {
    public static int diff21(int n) {
        if (n > 21) {
            return Math.abs(21 - n) * 2;
        } else {
            return 21 - n;
        }
    }

    public static void main(String[] args) {
        print("2 = " + diff21(19));
        print("11 = " + diff21(10));
        print("0 = " + diff21(21));
        print("5 = " + diff21(26));
    }
}
