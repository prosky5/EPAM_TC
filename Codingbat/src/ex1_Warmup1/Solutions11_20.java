package ex1_Warmup1;

import static utils.Print.print;

public class Solutions11_20 {

    /*
    Given a string, return a new string where the first
    and last chars have been exchanged.

    frontBack("code") → "eodc"
    frontBack("a") → "a"
    frontBack("ab") → "ba"
     */
    private static String frontBack(String str) {
        if (str.length() >= 3) {
            String toLast = str.substring(0, 1);
            String mid = str.substring(1, str.length()-1);
            String toFront = str.substring(str.length()-1);
            return toFront + mid + toLast;
        } else if (str.length() == 2) {
            return str.substring(1) + str.substring(0, 1);
        } else {
            return str;
        }
    }

    /*
    Given a string, we'll say that the front is the first 3 chars of the string.
    If the string length is less than 3, the front is whatever is there.
    Return a new string which is 3 copies of the front.

    front3("Java") → "JavJavJav"
    front3("Chocolate") → "ChoChoCho"
    front3("abc") → "abcabcabc"
     */
    private static String front3(String str) {
        if (str.length() >= 3) {
            String out = str.substring(0, 3);
            return out + out + out;
        } else {
            return str + str + str;
        }
    }

    /*
    Given a string, take the last char
    and return a new string with the last char added at the front and back,
    so "cat" yields "tcatt". The original string will be length 1 or more.

    backAround("cat") → "tcatt"
    backAround("Hello") → "oHelloo"
    backAround("a") → "aaa"
     */
    private static String backAround(String str) {
        if (str.length() >= 1) {
            char tmp = str.charAt(str.length()-1);
            return tmp + str + tmp;
        } else {
            return str;
        }
    }

    /*
    Return true if the given non-negative number is a multiple of 3
    or a multiple of 5. Use the % "mod" operator.

    or35(3) → true
    or35(10) → true
    or35(8) → false
     */
    private static boolean or35(int n) {
        return ((n % 3 == 0) || (n % 5 == 0));
    }

    /*
    Given a string, take the first 2 chars and
    return the string with the 2 chars added at both the front and back,
    so "kitten" yields"kikittenki".
    If the string length is less than 2, use whatever chars are there.

    front22("kitten") → "kikittenki"
    front22("Ha") → "HaHaHa"
    front22("abc") → "ababcab"
     */
    private static String front22(String str) {
        if (str.length() >=2) {
            String tmp = str.substring(0, 2);
            return tmp + str + tmp;
        } else {
            return str + str + str;
        }
    }

    /*
    Given a string, return true if the string starts with "hi" and false otherwise.

    startHi("hi there") → true
    startHi("hi") → true
    startHi("hello hi") → false
     */
    private static boolean startHi(String str) {
        return str.length() >= 2 && str.substring(0, 2).equals("hi");
    }

    /*
    Given two temperatures,
    return true if one is less than 0 and the other is greater than 100.

    icyHot(120, -1) → true
    icyHot(-1, 120) → true
    icyHot(2, 120) → false
     */
    private static boolean icyHot(int temp1, int temp2) {
        return ((temp1 > 100) && (temp2 < 0)) || ((temp1 < 0) && (temp2 > 100));
    }

    /*
    Given 2 int values,
    return true if either of them is in the range 10..20 inclusive.

    in1020(12, 99) → true
    in1020(21, 12) → true
    in1020(8, 99) → false
     */
    private static boolean in1020(int a, int b) {
        return (a >= 10 && a <= 20) || (b >= 10 && b <= 20);
    }

    /*
    We'll say that a number is "teen" if it is in the range 13..19 inclusive.
    Given 3 int values, return true if 1 or more of them are teen.

    hasTeen(13, 20, 10) → true
    hasTeen(20, 19, 10) → true
    hasTeen(20, 10, 13) → true
     */
    private static boolean hasTeen(int a, int b, int c) {
        return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19);
    }

    /*
    We'll say that a number is "teen" if it is in the range 13..19 inclusive.
    Given 2 int values, return true if one or the other is teen, but not both.

    loneTeen(13, 99) → true
    loneTeen(21, 19) → true
    loneTeen(13, 13) → false
     */
    private static boolean loneTeen(int a, int b) {
        return (a >= 13 && a <= 19) ^ (b >= 13 && b <= 19);
    }



    public static void main(String[] args) {
        // FrontBack:
        print();
        print(" FrontBack:");
        print(frontBack("eodc : " + "code"));
        print(frontBack("a : " + "a"));
        print(frontBack("ba : " + "ab"));

        // Front3:
        print();
        print(" Front3:");
        print("JavJavJav : " + front3("Java"));
        print("ChoChoCho : " + front3("Chocolate"));
        print("abcabcabc : " + front3("abc"));
        print("ababab : " + front3("ab"));
        print(" : " + front3(""));

        // BackAround:
        print();
        print(" BackAround:");
        System.out.println("tcatt : " + backAround("cat"));
        System.out.println("oHelloo : " + backAround("Hello"));
        System.out.println("aaa : " + backAround("a"));

        // Or35:
        print();
        print(" Or35:");
        System.out.println("TRUE : " + or35(3));
        System.out.println("TRUE : " + or35(10));
        System.out.println("FALSE : " + or35(8));

        // Front22:
        print();
        print(" Front22:");
        System.out.println("kikittenki : " + front22("kitten"));
        System.out.println("HaHaHa : " + front22("Ha"));
        System.out.println("ababcab : " + front22("abc"));

        // StartHi:
        print();
        print(" StartHi:");
        print("TRUE : " + startHi("hi there"));
        print("TRUE : " + startHi("hi"));
        print("FALSE : " + startHi("hello hi"));
        print("FALSE : " + startHi("h"));
        print("FALSE : " + startHi(""));

        // IcyHot:
        print();
        print(" IcyHot:");
        print("TRUE : " + icyHot(120, -1));
        print("TRUE : " + icyHot(-1, 120));
        print("FALSE : " + icyHot(120, 2));

        // In1020:
        print();
        print(" In1020:");
        print("TRUE : " + in1020(12, 99));
        print("TRUE : " + in1020(21, 12));
        print("FALSE : " + in1020(8, 99));

        // HasTeen:
        print();
        print(" HasTeen:");
        print("TRUE : " + hasTeen(13, 20, 10));
        print("TRUE : " + hasTeen(13, 20, 10));
        print("TRUE : " + hasTeen(13, 20, 10));
        print("FALSE : " + hasTeen(1, 20, 10));
        print("TRUE : " + hasTeen(13, 15, 19));

        // LoneTeen:
        print();
        print(" LoneTeen:");
        print("TRUE : " + loneTeen(13, 99));
        print("TRUE : " + loneTeen(21, 19));
        print("FALSE : " + loneTeen(13, 13));

    }
}
