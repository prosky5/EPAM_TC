package ex1_Warmup1;

import static utils.Print.*;

/**
 * Created by User on 029 29.11.17.
 */

public class S5_parrotTrouble {
    public static boolean parrotTrouble(boolean talking, int hour) {
        if ( talking && ((hour > 20) || (hour < 7)) ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        print("True : " + parrotTrouble(true, 6));
        print("False : " + parrotTrouble(true, 7));
        print("False : " + parrotTrouble(true, 13));
        print("True : " + parrotTrouble(true, 21));
        print("False : " + parrotTrouble(false, 6));
        print("False : " + parrotTrouble(false, 22));
    }
}
