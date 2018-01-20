package ex7_String2;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions8_14 {

    /*
    We'll say that a String is xy-balanced
    if for all the 'x' chars in the string,
    there exists a 'y' char somewhere later in the string.
    So "xxy" is balanced, but "xyx" is not.
    One 'y' can balance multiple 'x's.
    Return true if the given string is xy-balanced.

    xyBalance("aaxbby") → true
    xyBalance("aaxbb") → false
    xyBalance("yaaxbb") → false
     */
    static boolean xyBalance(String str) {
        boolean res = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                res = false;
            } else if (str.charAt(i) == 'y') {
                res = true;
            }
        }
        return res;
    }

    /*
    Given two strings, a and b,
    create a bigger string made of the first char of a,
    the first char of b, the second char of a, the second char of b, and so on.
    Any leftover chars go at the end of the result.

    mixString("abc", "xyz") → "axbycz"
    mixString("Hi", "There") → "HTihere"
    mixString("xxxx", "There") → "xTxhxexre"
     */
    static String mixString(String a, String b) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length() + b.length(); i++) {
            if (i < a.length()) {
                res.append(a.charAt(i));
            }
            if (i < b.length()) {
                res.append(b.charAt(i));
            }
        }
        return res.toString();
    }

    /*
    Given a string and an int n,
    return a string made of n repetitions of the last n characters of the string.
    You may assume that n is between 0 and the length of the string, inclusive.

    repeatEnd("Hello", 3) → "llollollo"
    repeatEnd("Hello", 2) → "lolo"
    repeatEnd("Hello", 1) → "o"
     */
    static String repeatEnd(String str, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(str.substring(str.length()-n, str.length()));
        }
        return res.toString();
    }

    /*
    Given a string and an int n,
    return a string made of the first n characters of the string,
    followed by the first n-1 characters of the string, and so on.
    You may assume that n is between 0 and the length of the string, inclusive
    (i.e. n >= 0 and n <= str.length()).

    repeatFront("Chocolate", 4) → "ChocChoChC"
    repeatFront("Chocolate", 3) → "ChoChC"
    repeatFront("Ice Cream", 2) → "IcI"
     */
    static String repeatFront(String str, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(str.substring(0, n-i));
        }
        return res.toString();
    }

    /*
    Given two strings, word and a separator sep,
    return a big string made of count occurrences of the word,
    separated by the separator string.

    repeatSeparator("Word", "X", 3) → "WordXWordXWord"
    repeatSeparator("This", "And", 2) → "ThisAndThis"
    repeatSeparator("This", "And", 1) → "This"
     */
    static String repeatSeparator(String word, String sep, int count) {
        StringBuilder res = new StringBuilder();
        if (count == 0) {
            return "";
        } else {
            res.append(word);
        }
        for (int i = 1; i < count; i++) {
            res.append(sep).append(word);
        }
        return res.toString();
    }

    /*
    Given a string,
    consider the prefix string made of the first N chars of the string.
    Does that prefix string appear somewhere else in the string?
    Assume that the string is not empty and that N is in the range 1..str.length().

    prefixAgain("abXYabc", 1) → true
    prefixAgain("abXYabc", 2) → true
    prefixAgain("abXYabc", 3) → false
     */
    static boolean prefixAgain(String str, int n) {
        String pattern = str.substring(0, n);
        for (int i = n; i <= str.length()-n; i++) {
            if (str.substring(i, i + pattern.length()).equals(pattern)) {
                return true;
            }
        }
        return false;
    }

    /*
    Given a string,
    does "xyz" appear in the middle of the string?
    To define middle, we'll say that the number of chars
    to the left and right of the "xyz" must differ by at most one.
    This problem is harder than it looks.

    xyzMiddle("AAxyzBB") → true
    xyzMiddle("AxyzBB") → true
    xyzMiddle("AxyzBBB") → false
     */
    static boolean xyzMiddle(String str) {
        if (str.length() < 3) {
            return false;
        }
        int endMid = str.length()/2 - 1;
        int startMid = str.length() % 2 == 0 ? str.length()/2 - 2 : endMid;

        for (; startMid <= endMid; startMid++) {
//            print(str.substring(startMid, startMid + 3));
            if (str.substring(startMid, startMid + 3).equals("xyz")) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // XyBalance:
        print();
        print(" XyBalance:");
        print("True : " + xyBalance("aaxbby"));
        print("False : " + xyBalance("aaxbb"));
        print("False : " + xyBalance("yaaxbb"));

        // MixString:
        print();
        print(" MixString:");
        print("axbycz : " + mixString("abc", "xyz"));
        print("HTihere : " + mixString("Hi", "There"));
        print("xTxhxexre : " + mixString("xxxx", "There"));

        // RepeatEnd:
        print();
        print(" RepeatEnd:");
        print("llollollo : " + repeatEnd("Hello", 3));
        print("lolo : " + repeatEnd("Hello", 2));
        print("o : " + repeatEnd("Hello", 1));

        // RepeatFront:
        print();
        print(" RepeatFront:");
        print("ChocChoChC : " + repeatFront("Chocolate", 4));
        print("ChoChC : " + repeatFront("Chocolate", 3));
        print("IcI : " + repeatFront("Ice Cream", 2));

        // RepeatSeparator:
        print();
        print(" RepeatSeparator:");
        print("WordXWordXWord : " + repeatSeparator("Word", "X", 3));
        print("ThisAndThis : " + repeatSeparator("This", "And", 2));
        print("This : " + repeatSeparator("This", "And", 1));

        // PrefixAgain:
        print();
        print(" PrefixAgain:");
        print("True : " + prefixAgain("abXYabc", 1));
        print("True : " + prefixAgain("abXYabc", 2));
        print("False : " + prefixAgain("abXYabc", 3));
        print("True : " + prefixAgain("aa", 1));

        // XyzMiddle:
        print();
        print(" XyzMiddle:");
        print("True : " + xyzMiddle("AAxyzBB"));
        print("True : " + xyzMiddle("AxyzBB"));
        print("False : " + xyzMiddle("AxyzBBB"));
        print("True : " + xyzMiddle("AAxyzB"));
        print("True : " + xyzMiddle("xyzxyzAxyzxyzxyz"));
        print("False : " + xyzMiddle("xyzxyzAxyzxyzxy"));

    }
}
