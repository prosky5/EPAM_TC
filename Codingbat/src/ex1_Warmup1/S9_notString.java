package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S9_notString {
    public static String notString(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
            return str;
        } else {
            return "not " + str;
        }
    }

    public static void main(String[] args) {
        print(notString("candy"));
        print(notString("x"));
        print(notString("not bad"));
    }
}
