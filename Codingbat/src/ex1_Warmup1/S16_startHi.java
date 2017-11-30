package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S16_startHi {
    public static boolean startHi(String str) {
        return str.length() >= 2 && str.substring(0, 2).equals("hi");
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + startHi("hi there"));
        System.out.println("TRUE : " + startHi("hi"));
        System.out.println("FALSE : " + startHi("hello hi"));
        System.out.println("FALSE : " + startHi("h"));
        System.out.println("FALSE : " + startHi(""));
    }
}
