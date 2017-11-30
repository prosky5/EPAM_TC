package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S20_loneTeen {
    public static boolean loneTeen(int a, int b) {
        return (a >= 13 && a <= 19) ^ (b >= 13 && b <= 19);
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + loneTeen(13, 99));
        System.out.println("TRUE : " + loneTeen(21, 19));
        System.out.println("FALSE : " + loneTeen(13, 13));
    }
}
