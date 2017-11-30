package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S30_endUp {
    public static String endUp(String str) {
        if (str.length() > 4) {
            int start = str.length() - 3;
            return str.substring(0, start) + str.substring(start, str.length()).toUpperCase();
        } else {
            return str.toUpperCase();
        }
    }

    public static void main(String[] args) {
        System.out.println("HeLLO : " + endUp("Hello"));
        System.out.println("hi thERE : " + endUp("hi there"));
        System.out.println("hi : " + endUp("HI"));
    }
}
