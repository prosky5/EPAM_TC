package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S24_intMax {
    public static int intMax(int a, int b, int c) {
        if (a > b) {
            b = a;
        }
        if (b > c) {
            c = b;
        }
        if (c > b) {
            return c;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        System.out.println("3 : " + intMax(1, 2, 3));
        System.out.println("3 : " + intMax(1, 3, 2));
        System.out.println("3 : " + intMax(3, 2, 1));
    }
}
