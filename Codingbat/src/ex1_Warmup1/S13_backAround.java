package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S13_backAround {
    public static String backAround(String str) {
        if (str.length() >= 1) {
            char tmp = str.charAt(str.length()-1);
            return tmp + str + tmp;
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println("tcatt : " + backAround("cat"));
        System.out.println("oHelloo : " + backAround("Hello"));
        System.out.println("aaa : " + backAround("a"));
    }
}
