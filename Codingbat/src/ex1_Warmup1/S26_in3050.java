package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S26_in3050 {
    public static boolean in3050(int a, int b) {
        return ((a >= 30) && (a <= 40) && (b >= 30) && (b <= 40)) ||
                ((a >= 40) && (a <= 50)) && ((b >= 40) && (b <= 50));
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + in3050(30, 31));
        System.out.println("FALSE : " + in3050(30, 41));
        System.out.println("TRUE : " + in3050(40, 50));
    }
}
