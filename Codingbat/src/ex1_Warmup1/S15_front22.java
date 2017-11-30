package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S15_front22 {
    public static String front22(String str) {
        if (str.length() >=2) {
            String tmp = str.substring(0, 2);
            return tmp + str + tmp;
        } else {
            return str + str + str;
        }
    }

    public static void main(String[] args) {
        System.out.println("kikittenki : " + front22("kitten"));
        System.out.println("HaHaHa : " + front22("Ha"));
        System.out.println("ababcab : " + front22("abc"));
    }
}
