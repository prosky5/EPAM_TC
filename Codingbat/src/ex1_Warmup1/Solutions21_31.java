package ex1_Warmup1;

import static utils.Print.print;

public class Solutions21_31 {

    /*
    Given a string, if the string "del" appears starting at index 1,
    return a string where that "del" has been deleted.
    Otherwise, return the string unchanged.

    delDel("adelbc") → "abc"
    delDel("adelHello") → "aHello"
    delDel("adedbc") → "adedbc"
     */
    private static String delDel(String str) {
        if (str.length() >= 4 && str.substring(1, 4).equals("del")) {
            return str.charAt(0) + str.substring(4, str.length());
        } else {
            return str;
        }
    }

    /*
    Return true if the given string begins with "mix",
    except the 'm' can be anything, so "pix", "9ix" .. all count.

    mixStart("mix snacks") → true
    mixStart("pix snacks") → true
    mixStart("piz snacks") → false
     */
    private static boolean mixStart(String str) {
        return (str.length() >= 3 && str.substring(1, 3).equals("ix"));
    }

    /*
    Given a string, return a string made of the first 2 chars (if present),
    however include first char only if it is 'o'
    and include the second only if it is 'z',
    so "ozymandias" yields "oz".

    startOz("ozymandias") → "oz"
    startOz("bzoo") → "z"
    startOz("oxx") → "o"
     */
    private static String startOz(String str) {
        String out = "";
        if (str.length() >= 1 && str.charAt(0) == 'o') {
            out += "o";
        }
        if (str.length() >= 2 && str.charAt(1) == 'z') {
            out += "z";
        }
        return out;
    }

    /*
    Given three int values, a b c, return the largest.

    intMax(1, 2, 3) → 3
    intMax(1, 3, 2) → 3
    intMax(3, 2, 1) → 3
     */
    private static int intMax(int a, int b, int c) {
        if (a > b) {
            b = a;
        }
        if (b > c) {
            c = b;
        }
        if (c > b) {
            return c;
        } else {
            return b;
        }
    }

    /*
    Given 2 int values, return whichever value is nearest to the value 10,
    or return 0 in the event of a tie.
    Note that Math.abs(n) returns the absolute value of a number.

    close10(8, 13) → 8
    close10(13, 8) → 8
    close10(13, 7) → 0
     */
    private static int close10(int a, int b) {
        if (Math.abs(10 - a) > Math.abs(10 - b)) {
            return b;
        } else if (Math.abs(10 - a) < Math.abs(10 - b)) {
            return a;
        } else {
            return 0;
        }
    }

    /*
    Given 2 int values, return true if they are both in the range 30..40 inclusive,
    or they are both in the range 40..50 inclusive.

    in3050(30, 31) → true
    in3050(30, 41) → false
    in3050(40, 50) → true
     */
    private static boolean in3050(int a, int b) {
        return ((a >= 30) && (a <= 40) && (b >= 30) && (b <= 40)) ||
                ((a >= 40) && (a <= 50)) && ((b >= 40) && (b <= 50));
    }

    /*
    Given 2 positive int values,
    return the larger value that is in the range 10..20 inclusive,
    or return 0 if neither is in that range.

    max1020(11, 19) → 19
    max1020(19, 11) → 19
    max1020(11, 9) → 11
     */
    private static int max1020(int a, int b) {
//        if (a >= 10 && a <= 20 && b >= 10 && b <= 20) {
//            return a >= b ? a : b;
//        } else if (a >= 10 && a <= 20) {
//            return a;
//        } else if (b >= 10 && b <= 20) {
//            return b;
//        } else {
//            return 0;
//        }
//
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        if (a >= 10 && a <= 20) return a;
        if (b >= 10 && b <= 20) return b;
        return 0;
    }

    /*
    Return true if the given string contains between 1 and 3 'e' chars.

    stringE("Hello") → true
    stringE("Heelle") → true
    stringE("Heelele") → false
     */
    private static boolean stringE(String str) {
        int count = 0;
        for (int i = 0; i < str.length() && count < 4; i++) {
            if (str.charAt(i) == 'e') {
                count++;
            }
        }
        return count >= 1 && count <= 3;
    }

    /*
    Given two non-negative int values,
    return true if they have the same last digit,
    such as with 27 and 57. Note that the % "mod" operator computes remainders,
    so 17 % 10 is 7.

    lastDigit(7, 17) → true
    lastDigit(6, 17) → false
    lastDigit(3, 113) → true
     */
    private static boolean lastDigit(int a, int b) {
        return (a % 10) == (b % 10);
    }

    /*
    Given a string,
    return a new string where the last 3 chars are now in upper case.
    If the string has less than 3 chars, uppercase whatever is there.
    Note that str.toUpperCase() returns the uppercase version of a string.

    endUp("Hello") → "HeLLO"
    endUp("hi there") → "hi thERE"
    endUp("hi") → "HI"
     */
    private static String endUp(String str) {
        if (str.length() > 4) {
            int start = str.length() - 3;
            return str.substring(0, start) + str.substring(start, str.length()).toUpperCase();
        } else {
            return str.toUpperCase();
        }
    }

    /*
    Given a non-empty string and an int N,
    return the string made starting with char 0,
    and then every Nth char of the string.
    So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.

    everyNth("Miracle", 2) → "Mrce"
    everyNth("abcdefg", 2) → "aceg"
    everyNth("abcdefg", 3) → "adg"
     */
    private static String everyNth(String str, int n) {
        String out = "";
        for(int i = 0; i < str.length(); i += n) {
            out += str.charAt(i);
        }
        return out;
    }



    public static void main(String[] args) {
        print();
        print("Expectation : Reality");

        // DelDel:
        print();
        print("DelDel:");
        System.out.println("abc : " + delDel("adelbc"));
        System.out.println("aHello : " + delDel("adelHello"));
        System.out.println("adedbc : " + delDel("adedbc"));

        // MixStart:
        print();
        print("MixStart:");
        System.out.println("TRUE : " + mixStart("mix snacks"));
        System.out.println("TRUE : " + mixStart("pix snacks"));
        System.out.println("FALSE : " + mixStart("piz snacks"));

        // StartOx:
        print();
        print("StartOx:");
        System.out.println("OZ : " + startOz("ozymandias"));
        System.out.println("Z : " + startOz("bzoo"));
        System.out.println("O : " + startOz("oxx"));

        // IntMax:
        print();
        print("IntMax:");
        System.out.println("3 : " + intMax(1, 2, 3));
        System.out.println("3 : " + intMax(1, 3, 2));
        System.out.println("3 : " + intMax(3, 2, 1));

        // Close10:
        print();
        print("Close10:");
        System.out.println("8 : " + close10(8, 13));
        System.out.println("8 : " + close10(13, 8));
        System.out.println("0 : " + close10(13, 7));

        // In3050:
        print();
        print("In3050:");
        System.out.println("TRUE : " + in3050(30, 31));
        System.out.println("FALSE : " + in3050(30, 41));
        System.out.println("TRUE : " + in3050(40, 50));

        // Max1020:
        print();
        print("Max1020:");
        System.out.println("19 : " + max1020(11, 19));
        System.out.println("19 : " + max1020(19, 11));
        System.out.println("11 : " + max1020(11, 9));
        System.out.println("0 : " + max1020(21, 9));

        // StringE:
        print();
        print("StringE:");
        System.out.println("TRUE : " + stringE("Hello"));
        System.out.println("TRUE : " + stringE("Heelle"));
        System.out.println("FALSE : " + stringE("Heelele"));
        System.out.println("TRUE : " + stringE("e"));
        System.out.println("FALSE : " + stringE(""));

        // LastDigit:
        print();
        print("LastDigit:");
        System.out.println("TRUE : " + lastDigit(7, 17));
        System.out.println("FALSE : " + lastDigit(6, 17));
        System.out.println("TRUE : " + lastDigit(3, 113));

        // EndUp:
        print();
        print("EndUp:");
        System.out.println("HeLLO : " + endUp("Hello"));
        System.out.println("hi thERE : " + endUp("hi there"));
        System.out.println("hi : " + endUp("HI"));

        // EveryNth:
        print();
        print("EveryNth:");
        System.out.println("Mrce : " + everyNth("Miracle", 2));
        System.out.println("aceg : " + everyNth("abcdefg", 2));
        System.out.println("adg : " + everyNth("abcdefg", 3));
    }

}
