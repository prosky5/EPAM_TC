package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S11_frontBack {
    public static String frontBack(String str) {
        if (str.length() >= 3) {
            String toLast = str.substring(0, 1);
            String mid = str.substring(1, str.length()-1);
            String toFront = str.substring(str.length()-1);
            return toFront + mid + toLast;
        } else if (str.length() == 2) {
            return str.substring(1) + str.substring(0, 1);
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        print(frontBack("eodc : " + "code"));
        print(frontBack("a : " + "a"));
        print(frontBack("ba : " + "ab"));
    }
}
