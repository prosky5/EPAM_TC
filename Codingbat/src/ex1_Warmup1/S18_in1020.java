package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S18_in1020 {
    public static boolean in1020(int a, int b) {
        return (a >= 10 && a <= 20) || (b >= 10 && b <= 20);
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + in1020(12, 99));
        System.out.println("TRUE : " + in1020(21, 12));
        System.out.println("FALSE : " + in1020(8, 99));
    }
}
