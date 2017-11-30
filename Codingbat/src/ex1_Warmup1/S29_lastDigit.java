package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S29_lastDigit {
    public static boolean lastDigit(int a, int b) {
        return (a % 10) == (b % 10);
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + lastDigit(7, 17));
        System.out.println("FALSE : " + lastDigit(6, 17));
        System.out.println("TRUE : " + lastDigit(3, 113));
    }
}
