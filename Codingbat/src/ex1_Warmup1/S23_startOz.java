package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S23_startOz {
    public static String startOz(String str) {
        String out = "";
        if (str.length() >= 1 && str.charAt(0) == 'o') {
            out += "o";
        }
        if (str.length() >= 2 && str.charAt(1) == 'z') {
            out += "z";
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("OZ : " + startOz("ozymandias"));
        System.out.println("Z : " + startOz("bzoo"));
        System.out.println("O : " + startOz("oxx"));
    }
}
