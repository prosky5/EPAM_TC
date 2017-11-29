package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S10_missingChar {
    public static String missingChar(String str, int n) {
        String a = str.substring(0, n);
        String b = str.substring(n+1, str.length());
        return a + b;
    }

    public static void main(String[] args) {
        print(missingChar("kitten", 1));
        print(missingChar("kitten", 0));
        print(missingChar("kitten", 4));
    }
}
