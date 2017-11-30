package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S31_everyNth {
    public static String everyNth(String str, int n) {
        String out = "";
        for(int i = 0; i < str.length(); i += n) {
            out += str.charAt(i);
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("Mrce : " + everyNth("Miracle", 2));
        System.out.println("aceg : " + everyNth("abcdefg", 2));
        System.out.println("adg : " + everyNth("abcdefg", 3));
    }
}
