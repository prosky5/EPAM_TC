package ex1_Warmup1;

/**
 * Created by User on 029 29.11.17.
 */

public class S2_monkeyTrouble {
    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile == bSmile) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("True : " + monkeyTrouble(true, true));
        System.out.println("False : " + monkeyTrouble(true, false));
        System.out.println("False : " + monkeyTrouble(false, true));
        System.out.println("True : " + monkeyTrouble(false, false));
    }
}
