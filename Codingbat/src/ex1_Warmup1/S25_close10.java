package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S25_close10 {
    public static int close10(int a, int b) {
        if (Math.abs(10 - a) > Math.abs(10 - b)) {
            return b;
        } else if (Math.abs(10 - a) < Math.abs(10 - b)) {
            return a;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("8 : " + close10(8, 13));
        System.out.println("8 : " + close10(13, 8));
        System.out.println("0 : " + close10(13, 7));
    }
}
