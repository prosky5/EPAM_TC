package ex3_String1;

import static utils.Print.*;

public class Solutions1_11 {

    /*
    Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".

    helloName("Bob") → "Hello Bob!"
    helloName("Alice") → "Hello Alice!"
    helloName("X") → "Hello X!"
     */
    static String helloName(String name) {
        return "Hello " + name + "!";
    }

    /*
    Given two strings, a and b,
    return the result of putting them together in the order abba,
    e.g. "Hi" and "Bye" returns "HiByeByeHi".

    makeAbba("Hi", "Bye") → "HiByeByeHi"
    makeAbba("Yo", "Alice") → "YoAliceAliceYo"
    makeAbba("What", "Up") → "WhatUpUpWhat"
     */
    static String makeAbba(String a, String b) {
        return a + b + b + a;
    }

    /*
    The web is built with HTML strings like "<i>Yay</i>"
    which draws Yay as italic text.
    In this example, the "i" tag makes <i> and </i> which surround the word "Yay".
    Given tag and word strings, create the HTML string with tags around the word,
    e.g. "<i>Yay</i>".

    makeTags("i", "Yay") → "<i>Yay</i>"
    makeTags("i", "Hello") → "<i>Hello</i>"
    makeTags("cite", "Yay") → "<cite>Yay</cite>"
     */
    static String makeTags(String tag, String word) {
        return "<" + tag + ">" + word + "</" + tag + ">";
    }

    /*
    Given an "out" string length 4, such as "<<>>", and a word,
    return a new string where the word is in the middle of the out string,
    e.g. "<<word>>".
    Note: use str.substring(i, j) to extract the String
    starting at index i and going up to but not including index j.

    makeOutWord("<<>>", "Yay") → "<<Yay>>"
    makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
    makeOutWord("[[]]", "word") → "[[word]]"
     */
    static String makeOutWord(String out, String word) {
        int mid = out.length()/2;
        return out.substring(0, mid) + word + out.substring(mid);
    }

    /*
    Given a string,
    return a new string made of 3 copies of the last 2 chars of the original string.
    The string length will be at least 2.

    extraEnd("Hello") → "lololo"
    extraEnd("ab") → "ababab"
    extraEnd("Hi") → "HiHiHi"
     */
    static String extraEnd(String str) {
        String res = "";
        int end = str.length();
        for (int i = 0; i < 3; i++) {
            res += str.substring(end-2);
        }
        return res;
    }

    /*
    Given a string,
    return the string made of its first two chars,
    so the String "Hello" yields "He".
    If the string is shorter than length 2, return whatever there is,
    so "X" yields "X", and the empty string "" yields the empty string "".
    Note that str.length() returns the length of a string.

    firstTwo("Hello") → "He"
    firstTwo("abcdefg") → "ab"
    firstTwo("ab") → "ab"
     */
    static String firstTwo(String str) {
        return str.length() <= 2 ? str : str.substring(0, 2);
    }

    /*
    Given a string of even length,
    return the first half. So the string "WooHoo" yields "Woo".

    firstHalf("WooHoo") → "Woo"
    firstHalf("HelloThere") → "Hello"
    firstHalf("abcdef") → "abc"
     */
    static String firstHalf(String str) {
        return str.substring(0, str.length()/2);
    }

    /*
    Given a string,
    return a version without the first and last char, so "Hello" yields "ell".
    The string length will be at least 2.

    withoutEnd("Hello") → "ell"
    withoutEnd("java") → "av"
    withoutEnd("coding") → "odin"
     */
    static String withoutEnd(String str) {
        return str.substring(1, str.length()-1);
    }

    /*
    Given 2 strings, a and b,
    return a string of the form short+long+short,
    with the shorter string on the outside and the longer string on the inside.
    The strings will not be the same length, but they may be empty (length 0).

    comboString("Hello", "hi") → "hiHellohi"
    comboString("hi", "Hello") → "hiHellohi"
    comboString("aaa", "b") → "baaab"
     */
    static String comboString(String a, String b) {
        if (b.length() > a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        return b + a + b;
    }

    /*
    Given 2 strings, return their concatenation,
    except omit the first char of each.
    The strings will be at least length 1.

    nonStart("Hello", "There") → "ellohere"
    nonStart("java", "code") → "avaode"
    nonStart("shotl", "java") → "hotlava"
     */
    static String nonStart(String a, String b) {
        return a.substring(1) + b.substring(1);
    }

    /*
    Given a string,
    return a "rotated left 2" version where the first 2 chars are moved to the end.
    The string length will be at least 2.

    left2("Hello") → "lloHe"
    left2("java") → "vaja"
    left2("Hi") → "Hi"
     */
    static String left2(String str) {
        return str.length() > 2 ? str.substring(2) + str.substring(0, 2) : str;
    }


    public static void main(String[] args) {

        // HelloName:
        print();
        print(" HelloName:");
        print("Hello Bob! : " + helloName("Bob"));
        print("Hello Alice! : " + helloName("Alice"));
        print("Hello X! : " + helloName("X"));

        // MakeAbba:
        print();
        print(" MakeAbba:");
        print("HiByeByeHi : " + makeAbba("Hi", "Bye"));
        print("YoAliceAliceYo : " + makeAbba("Yo", "Alice"));
        print("WhatUpUpWhat : " + makeAbba("What", "Up"));

        // MakeTags:
        print();
        print(" MakeTags:");
        print("<i>Yay</i> : " + makeTags("i", "Yay"));
        print("<i>Hello</i> : " + makeTags("i", "Hello"));
        print("<cite>Yay</cite> : " + makeTags("cite", "Yay"));

        // MakeOutWord:
        print();
        print(" MakeOutWord:");
        print("<<Yay>> : " + makeOutWord("<<>>", "Yay"));
        print("<<WooHoo>> : " + makeOutWord("<<>>", "WooHoo"));
        print("[[word]] : " + makeOutWord("[[]]", "word"));

        // ExtraEnd:
        print();
        print(" ExtraEnd:");
        print("lololo : " + extraEnd("Hello"));
        print("ababab : " + extraEnd("ab"));
        print("HiHiHi : " + extraEnd("Hi"));

        // FirstTwo:
        print();
        print(" FirstTwo:");
        print("He : " + firstTwo("Hello"));
        print("ab : " + firstTwo("abcdefg"));
        print("ab : " + firstTwo("ab"));

        // FirstHalf:
        print();
        print(" FirstHalf:");
        print("Woo : " + firstHalf("WooHoo"));
        print("Hello : " + firstHalf("HelloThere"));
        print("abc : " + firstHalf("abcdef"));

        // WithoutEnd:
        print();
        print(" WithoutEnd:");
        print("ell : " + withoutEnd("Hello"));
        print("av : " + withoutEnd("java"));
        print("odin : " + withoutEnd("coding"));

        // ComboString:
        print();
        print(" ComboString:");
        print("hiHellohi : " + comboString("Hello", "hi"));
        print("hiHellohi : " + comboString("hi", "Hello"));
        print("baaab : " + comboString("aaa", "b"));

        // NonStart:
        print();
        print(" NonStart:");
        print("ellohere : " + nonStart("Hello", "There"));
        print("avaode : " + nonStart("java", "code"));
        print("hotlava : " + nonStart("shotl", "java"));

        // Left2:
        print();
        print(" Left2:");
        print("lloHe : " + left2("Hello"));
        print("vaja : " + left2("java"));
        print("Hi : " + left2("Hi"));

    }
}
