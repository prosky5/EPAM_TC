package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S19_hasTeen {
    public static boolean hasTeen(int a, int b, int c) {
        return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19);
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + hasTeen(13, 20, 10));
        System.out.println("TRUE : " + hasTeen(13, 20, 10));
        System.out.println("TRUE : " + hasTeen(13, 20, 10));
        System.out.println("FALSE : " + hasTeen(1, 20, 10));
        System.out.println("TRUE : " + hasTeen(13, 15, 19));
    }
}
