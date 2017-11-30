package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S12_front3 {
    public static String front(String str) {
        if (str.length() >= 3) {
            String out = str.substring(0, 3);
            return out + out + out;
        } else {
            return str + str + str;
        }
    }

    public static void main(String[] args) {
        // Перестал импортить 'utils.Print' т.к. '"Строка".sout' - удобнее
        System.out.println("JavJavJav : " + front("Java"));
        System.out.println("ChoChoCho : " + front("Chocolate"));
        System.out.println("abcabcabc : " + front("abc"));
        System.out.println("ababab : " + front("ab"));
        System.out.println(" : " + front(""));

    }
}
