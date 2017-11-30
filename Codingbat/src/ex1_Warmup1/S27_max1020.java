package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S27_max1020 {
    public static int max1020(int a, int b) {
//        if (a >= 10 && a <= 20 && b >= 10 && b <= 20) {
//            return a >= b ? a : b;
//        } else if (a >= 10 && a <= 20) {
//            return a;
//        } else if (b >= 10 && b <= 20) {
//            return b;
//        } else {
//            return 0;
//        }
//
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (a >= 10 && a <= 20) return a;
        if (b >= 10 && b <= 20) return b;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("19 : " + max1020(11, 19));
        System.out.println("19 : " + max1020(19, 11));
        System.out.println("11 : " + max1020(11, 9));
        System.out.println("0 : " + max1020(21, 9));

    }
}
