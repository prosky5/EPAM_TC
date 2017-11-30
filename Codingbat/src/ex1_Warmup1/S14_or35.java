package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S14_or35 {
    public static boolean or35(int n) {
        if ((n % 3 == 0) || (n % 5 == 0)) {
            return true;
        } else {
            return false;
        }
        // Можно было так:
//        return (n % 3 == 0) || (n % 5 == 0);
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + or35(3));
        System.out.println("TRUE : " + or35(10));
        System.out.println("FALSE : " + or35(8));
    }
}
