package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S17_icyHot {
    public static boolean icyHot(int temp1, int temp2) {
        return ((temp1 > 100) && (temp2 < 0)) || ((temp1 < 0) && (temp2 > 100));
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + icyHot(120, -1));
        System.out.println("TRUE : " + icyHot(-1, 120));
        System.out.println("FALSE : " + icyHot(120, 2));
    }
}
