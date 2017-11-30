package ex1_Warmup1;

/**
 * Created by User on 030 30.11.17.
 */

public class S28_stringE {
    public static boolean stringE(String str) {
        int count = 0;
        for (int i = 0; i < str.length() && count < 4; i++) {
            if (str.charAt(i) == 'e') {
                count++;
            }
        }
        return count >= 1 && count <= 3;
    }

    public static void main(String[] args) {
        System.out.println("TRUE : " + stringE("Hello"));
        System.out.println("TRUE : " + stringE("Heelle"));
        System.out.println("FALSE : " + stringE("Heelele"));
        System.out.println("TRUE : " + stringE("e"));
        System.out.println("FALSE : " + stringE(""));
    }
}
