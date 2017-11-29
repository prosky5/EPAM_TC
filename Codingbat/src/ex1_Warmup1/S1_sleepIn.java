package ex1_Warmup1;

/**
 * Created by User on 029 29.11.17.
 */

public class S1_sleepIn {
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("True : " + sleepIn(true, true));
        System.out.println("False : " + sleepIn(true, false));
        System.out.println("True : " + sleepIn(false, true));
        System.out.println("True : " + sleepIn(false, false));
    }
}
