package ex3_String1;

import static utils.Print.*;

public class Solutions12_22 {

    /*
    Given a string,
    return a "rotated right 2" version where the last 2 chars are moved to the start.
    The string length will be at least 2.

    right2("Hello") → "loHel"
    right2("java") → "vaja"
    right2("Hi") → "Hi"
     */
    static String right2(String str) {
        return str.length() > 2 ?
                str.substring(str.length()-2) + str.substring(0, str.length()-2) :
                str;
    }

    /*
    Given a string,
    return a string length 1 from its front, unless front is false,
    in which case return a string length 1 from its back.
    The string will be non-empty.

    theEnd("Hello", true) → "H"
    theEnd("Hello", false) → "o"
    theEnd("oh", true) → "o"
     */
    static String theEnd(String str, boolean front) {
        return front ? str.substring(0, 1) :
                str.substring(str.length()-1, str.length());
    }

    /*
    Given a string,
    return a version without both the first and last char of the string.
    The string may be any length, including 0.

    withouEnd2("Hello") → "ell"
    withouEnd2("abc") → "b"
    withouEnd2("ab") → ""
     */
    static String withouEnd2(String str) {
        return str.length() > 2 ? str.substring(1, str.length()-1) : "";
    }

    /*
    Given a string of even length,
    return a string made of the middle two chars, so the string "string" yields "ri".
    The string length will be at least 2.

    middleTwo("string") → "ri"
    middleTwo("code") → "od"
    middleTwo("Practice") → "ct"
     */
    static String middleTwo(String str) {
        int length = str.length();
        return length > 2 ?
                "" + str.charAt(length/2-1) + str.charAt(length/2) : str;
    }

    /*
    Given a string, return true if it ends in "ly".

    endsLy("oddly") → true
    endsLy("y") → false
    endsLy("oddy") → false
     */
    static boolean endsLy(String str) {
        return str.length() >= 2 && str.substring(str.length()-2).equals("ly");
    }

    /*
    Given a string and an int n,
    return a string made of the first and last n chars from the string.
    The string length will be at least n.

    nTwice("Hello", 2) → "Helo"
    nTwice("Chocolate", 3) → "Choate"
    nTwice("Chocolate", 1) → "Ce"
     */
    static String nTwice(String str, int n) {
        return str.length() >= n ?
                str.substring(0, n) + str.substring(str.length()-n) : str;
    }

    /*
    Given a string and an index,
    return a string length 2 starting at the given index.
    If the index is too big or too small to define a string length 2,
    use the first 2 chars. The string length will be at least 2.

    twoChar("java", 0) → "ja"
    twoChar("java", 2) → "va"
    twoChar("java", 3) → "ja"
     */
    static String twoChar(String str, int index) {
        String out = "";
        if (str.length() > 2) {
            if (index >= 0 && index < str.length()-1) {
                out += str.substring(index, index+2);
            } else {
                out += str.substring(0, 2);
            }
        } else {
            out = str;
        }
        return out;
    }

    /*
    Given a string of odd length,
    return the string length 3 from its middle, so "Candy" yields "and".
    The string length will be at least 3.

    middleThree("Candy") → "and"
    middleThree("and") → "and"
    middleThree("solving") → "lvi"
     */
    static String middleThree(String str) {
        if (str.length() > 3) {
            int mid = str.length()/2;
            return str.substring(mid-1, mid+2);
        } else {
            return str;
        }
    }

    /*
    Given a string,
    return true if "bad" appears starting at index 0 or 1 in the string,
    such as with "badxxx" or "xbadxx" but not "xxbadxx".
    The string may be any length, including 0.
    Note: use .equals() to compare 2 strings.

    hasBad("badxx") → true
    hasBad("xbadxx") → true
    hasBad("xxbadxx") → false
     */
    static boolean hasBad(String str) {
        return str.length() <= 3 ? str.equals("bad") :
                str.substring(0, 3).equals("bad") || str.substring(1, 4).equals("bad");
    }

    /*
    Given a string,
    return a string length 2 made of its first 2 chars.
    If the string length is less than 2, use '@' for the missing chars.

    atFirst("hello") → "he"
    atFirst("hi") → "hi"
    atFirst("h") → "h@"
     */
    static String atFirst(String str) {
        String out = "";
        if (str.length() < 2) {
            out = str;
            while (out.length() < 2) {
                out += "@";
            }
        } else {
            out = str.substring(0, 2);
        }
        return out;
    }

    /*
    Given 2 strings, a and b,
    return a new string made of the first char of a and the last char of b,
    so "yo" and "java" yields "ya".
    If either string is length 0, use '@' for its missing char.

    lastChars("last", "chars") → "ls"
    lastChars("yo", "java") → "ya"
    lastChars("hi", "") → "h@"
     */
    static String lastChars(String a, String b) {
        String firstCh = "";
        String secondCh = "";
        if (a.length() != 0) {
            firstCh = "" + a.charAt(0);
        } else {
            firstCh = "@";
        }
        if (b.length() != 0) {
            secondCh = "" + b.charAt(b.length()-1);
        } else {
            secondCh = "@";
        }
        return firstCh + secondCh;
    }


    public static void main(String[] args) {

        // Right2:
        print();
        print(" Right2:");
        print("loHell : " + right2("Hello"));
        print("vaja : " + right2("java"));
        print("Hi : " + right2("Hi"));

        // TheEnd:
        print();
        print(" TheEnd:");
        print("H : " + theEnd("Hello", true));
        print("o : " + theEnd("Hello", false));
        print("o : " + theEnd("oh", true));

        // WithouEnd2:
        print();
        print(" WithouEnd2:");
        print("ell : " + withouEnd2("Hello"));
        print("b : " + withouEnd2("abc"));
        print(" : " + withouEnd2("ab"));
        print(" : " + withouEnd2("a"));
        print(" : " + withouEnd2(""));

        // MiddleTwo:
        print();
        print(" MiddleTwo:");
        print("ri : " + middleTwo("string"));
        print("od : " + middleTwo("code"));
        print("ct : " + middleTwo("Practice"));

        // EndsLy:
        print();
        print(" EndsLy:");
        print("True : " + endsLy("oddly"));
        print("False : " + endsLy("y"));
        print("False : " + endsLy("oddy"));

        // NTwice:
        print();
        print(" NTwice:");
        print("Helo : " + nTwice("Hello", 2));
        print("Choate : " + nTwice("Chocolate", 3));
        print("Ce : " + nTwice("Chocolate", 1));
        print("CodeCode : " + nTwice("Code", 4));

        // TwoChar:
        print();
        print(" TwoChar:");
        print("ja : " + twoChar("java", 0));
        print("va : " + twoChar("java", 2));
        print("ja : " + twoChar("java", 3));

        // MiddleThree:
        print();
        print(" MiddleThree:");
        print("and : " + middleThree("Candy"));
        print("and : " + middleThree("and"));
        print("lvi : " + middleThree("solving"));

        // HasBad:
        print();
        print(" HasBad:");
        print("True : " + hasBad("badxx"));
        print("True : " + hasBad("xbadxx"));
        print("False : " + hasBad("xxbadxx"));
        print("False : " + hasBad("xba"));

        // AtFirst:
        print();
        print(" AtFirst:");
        print("he : " + atFirst("hello"));
        print("hi : " + atFirst("hi"));
        print("h@ : " + atFirst("h"));
        print("@@ : " + atFirst(""));

        // LastChars:
        print();
        print(" LastChars:");
        print("ls : " + lastChars("last", "chars"));
        print("ya : " + lastChars("yo", "java"));
        print("h@ : " + lastChars("hi", ""));
        print("@@ : " + lastChars("", ""));

    }

}
