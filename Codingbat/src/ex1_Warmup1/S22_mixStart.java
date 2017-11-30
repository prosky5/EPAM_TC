package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S22_mixStart {
    public static boolean mixStart(String str) {
        return (str.length() >= 3 && str.substring(1, 3).equals("ix"));
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + mixStart("mix snacks"));
        System.out.println("TRUE : " + mixStart("pix snacks"));
        System.out.println("FALSE : " + mixStart("piz snacks"));
    }
}
