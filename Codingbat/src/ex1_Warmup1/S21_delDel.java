package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S21_delDel {
    public static String delDel(String str) {
        if (str.length() >= 4 && str.substring(1, 4).equals("del")) {
            return str.charAt(0) + str.substring(4, str.length());
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println("abc : " + delDel("adelbc"));
        System.out.println("aHello : " + delDel("adelHello"));
        System.out.println("adedbc : " + delDel("adedbc"));
    }
}
