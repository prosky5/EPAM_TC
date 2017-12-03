package ex3_String1;

import static utils.Print.*;

public class Solutions23_33 {

    /*
    Given two strings,
    append them together (known as "concatenation") and return the result.
    However, if the concatenation creates a double-char,
    then omit one of the chars, so "abc" and "cat" yields "abcat".

    conCat("abc", "cat") → "abcat"
    conCat("dog", "cat") → "dogcat"
    conCat("abc", "") → "abc"
     */
    static String conCat(String a, String b) {
        if (a.length() >= 1 && b.length() >= 1 && a.substring(a.length()-1).equals(b.substring(0, 1))) {
            return a.substring(0, a.length()-1) + b;
        } else {
            return a + b;
        }
    }

    /*
    Given a string of any length,
    return a new string where the last 2 chars, if present, are swapped,
    so "coding" yields "codign".

    lastTwo("coding") → "codign"
    lastTwo("cat") → "cta"
    lastTwo("ab") → "ba"
     */
    static String lastTwo(String str) {
        if (str.length() > 1) {
            String end = str.substring(str.length() - 2);
            return str.substring(0, str.length() - 2) + end.charAt(1) + end.charAt(0);
        } else {
            return str;
        }
    }

    /*
    Given a string,
    if the string begins with "red" or "blue" return that color string,
    otherwise return the empty string.

    seeColor("redxx") → "red"
    seeColor("xxred") → ""
    seeColor("blueTimes") → "blue"
     */
    static String seeColor(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("red")) {
            return "red";
        }
        if (str.length() >= 4 && str.substring(0, 4).equals("blue")) {
            return "blue";
        }
        return "";
    }

    /*
    Given a string,
    return true if the first 2 chars in the string also appear at the end of the string,
    such as with "edited".

    frontAgain("edited") → true
    frontAgain("edit") → false
    frontAgain("ed") → true
     */
    static boolean frontAgain(String str) {
        return str.length() > 1 && str.substring(0, 2).equals(str.substring(str.length()-2, str.length()));
    }

    /*
    Given two strings,
    append them together (known as "concatenation") and return the result.
    However, if the strings are different lengths,
    omit chars from the longer string so it is the same length as the shorter string.
    So "Hello" and "Hi" yield "loHi". The strings may be any length.

    minCat("Hello", "Hi") → "loHi"
    minCat("Hello", "java") → "ellojava"
    minCat("java", "Hello") → "javaello"
     */
    static String minCat(String a, String b) {
        if (b.length() <= a.length()) {
            a = a.substring(a.length() - b.length(), a.length());
        } else {
            b = b.substring(b.length() - a.length(), b.length());
        }
        return a + b;
    }

    /*
    Given a string,
    return a new string made of 3 copies of the first 2 chars of the original string.
    The string may be any length.
    If there are fewer than 2 chars, use whatever is there.

    extraFront("Hello") → "HeHeHe"
    extraFront("ab") → "ababab"
    extraFront("H") → "HHH"
     */
    static String extraFront(String str) {
        return  (str.length() > 1) ?
                str.substring(0, 2) + str.substring(0, 2) + str.substring(0, 2) :
                str + str + str;
    }

    /*
    Given a string,
    if a length 2 substring appears at both its beginning and end,
    return a string without the substring at the beginning,
    so "HelloHe" yields "lloHe".
    The substring may overlap with itself, so "Hi" yields "". Otherwise,
    return the original string unchanged.

    without2("HelloHe") → "lloHe"
    without2("HelloHi") → "HelloHi"
    without2("Hi") → ""
     */
    static String without2(String str) {
        if (str.length() > 1 && (str.substring(0, 2).equals(str.substring(str.length()-2, str.length())))) {
            return str.substring(2);
        } else {
            return str;
        }
    }

    /*
    Given a string,
    return a version without the first 2 chars.
    Except keep the first char if it is 'a' and keep the second char if it is 'b'.
    The string may be any length. Harder than it looks.

    deFront("Hello") → "llo"
    deFront("java") → "va"
    deFront("away") → "aay"
     */
    static String deFront(String str) {
        String out = "";
        if (str.length() > 0 && str.charAt(0) == 'a') {
            out += "a";
        }
        if (str.length() > 1 && str.charAt(1) == 'b') {
            out += "b";
        }
        if (str.length() > 2) {
            return out + str.substring(2);
        }
        return out;
    }

    /*
    Given a string and a second "word" string,
    we'll say that the word matches the string if it appears at the front of the string,
    except its first char does not need to match exactly.
    On a match, return the front of the string, or otherwise return the empty string.
    So, so with the string "hippo" the word "hi" returns "hi" and "xip" returns "hip".
    The word will be at least length 1.

    startWord("hippo", "hi") → "hi"
    startWord("hippo", "xip") → "hip"
    startWord("hippo", "i") → "h"
     */
    static String startWord(String str, String word) {
        if (word.length() >= 1 && word.length() <= str.length() &&
                word.substring(1).equals(str.substring(1, word.length()))) {
            return str.substring(0, word.length());
        } else {
            return "";
        }
    }

    /*
    Given a string,
    if the first or last chars are 'x', return the string without those 'x' chars,
    and otherwise return the string unchanged.

    withoutX("xHix") → "Hi"
    withoutX("xHi") → "Hi"
    withoutX("Hxix") → "Hxi"
     */
    static String withoutX(String str) {
//        while (str.charAt(0) == 'x' ||                    // Можно удалять пока есть 'x'
//                  str.charAt(str.length()-1) == 'x') {    // в начале или в конце
            if (str.length() > 0 && str.charAt(0) == 'x') {
                str = str.substring(1);
            }
            if (str.length() > 0 && str.charAt(str.length()-1) == 'x') {
                str = str.substring(0, str.length()-1);
            }
//        }
        return str;
    }

    /*
    Given a string,
    if one or both of the first 2 chars is 'x',
    return the string without those 'x' chars, and otherwise return the string unchanged.
    This is a little harder than it looks.

    withoutX2("xHi") → "Hi"
    withoutX2("Hxi") → "Hi"
    withoutX2("Hi") → "Hi"
     */
    static String withoutX2(String str) {
        if (str.length() > 1 && str.charAt(1) == 'x') {
            if (str.length() > 2) {
                str = str.charAt(0) + str.substring(2);
            } else {
                str = "" + str.charAt(0);
            }
        }
        if (str.length() > 0 && str.charAt(0) == 'x') {
            str = str.substring(1);
        }
        return str;
    }


    public static void main(String[] args) {
        // ConCat:
        print();
        print(" ConCat:");
        print("abcat : " + conCat("abc", "cat"));
        print("abcat : " + conCat("dog", "cat"));
        print("abc : " + conCat("abc", ""));

        // LastTwo:
        print();
        print(" LastTwo:");
        print("codign : " + lastTwo("coding"));
        print("cta : " + lastTwo("cat"));
        print("ba : " + lastTwo("ab"));
        print("a : " + lastTwo("a"));
        print(" : " + lastTwo(""));

        // SeeColor:
        print();
        print(" SeeColor:");
        print("red : " + seeColor("redxx"));
        print(" : " + seeColor("xxred"));
        print("blue : " + seeColor("blueTimes"));

        // FrontAgain:
        print();
        print(" FrontAgain:");
        print("True : " + frontAgain("edited"));
        print("False : " + frontAgain("edit"));
        print("True : " + frontAgain("ed"));

        // MinCat:
        print();
        print(" MinCat:");
        print("loHi : " + minCat("Hello", "Hi"));
        print("ellojava : " + minCat("Hello", "java"));
        print("javaello : " + minCat("java", "Hello"));

        // ExtraFront:
        print();
        print(" ExtraFront:");
        print("HeHeHe : " + extraFront("Hello"));
        print("ababab : " + extraFront("ab"));
        print("HHH : " + extraFront("H"));

        // Without2:
        print();
        print(" Without2:");
        print("lloHe : " + without2("HelloHe"));
        print("HelloHi : " + without2("HelloHi"));
        print(" : " + without2("Hi"));

        // DeFront:
        print();
        print(" DeFront:");
        print("llo : " + deFront("Hello"));
        print("va : " + deFront("java"));
        print("aay : " + deFront("away"));

        // StartWord:
        print();
        print(" StartWord:");
        print("hi : " + startWord("hippo", "hi"));
        print("hip : " + startWord("hippo", "xip"));
        print("h : " + startWord("hippo", "i"));
        print(" : " + startWord("hippo", "ix"));
        print(" : " + startWord("h", "ix"));
        print(" : " + startWord("", "i"));
        print(" : " + startWord("hip", "zig"));
        print("hi : " + startWord("hip", "zi"));

        // WithoutX:
        print();
        print(" WithoutX:");
        print("Hi : " + withoutX("xHix"));
        print("Hi : " + withoutX("xHi"));
        print("Hxi : " + withoutX("Hxix"));
        print(" : " + withoutX("x"));
        print(" : " + withoutX(""));

        // WithoutX2:
        print();
        print(" WithoutX2:");
        print("Hi : " + withoutX2("xHi"));
        print("Hi : " + withoutX2("Hxi"));
        print("Hi : " + withoutX2("Hi"));
        print("Hi : " + withoutX2("xxHi"));
        print("axb : " + withoutX2("xaxb"));
        print("Hxllo : " + withoutX2("xHxllo"));
    }
}
