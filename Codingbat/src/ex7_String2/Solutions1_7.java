package ex7_String2;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions1_7 {

    /*
    Given a string, return a string where for every char in the original,
    there are two chars.

    doubleChar("The") → "TThhee"
    doubleChar("AAbb") → "AAAAbbbb"
    doubleChar("Hi-There") → "HHii--TThheerree"
     */
    static String doubleChar(String str) {
        char[] ch = str.toCharArray();
        char[] res = new char[str.length() * 2];
        for (int i = 0, j = 0; i < ch.length; i++, j = j + 2) {
            res[j] = res[j+1] = ch[i];
        }
        return String.valueOf(res);
    }

    /*
    Return the number of times that the string "hi" appears anywhere in the given string.

    countHi("abc hi ho") → 1
    countHi("ABChi hi") → 2
    countHi("hihi") → 2
     */
    static int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i+2).equals("hi")) {
                count++;
            }
        }
        return count;
    }

    /*
    Return true if the string "cat" and "dog" appear the same number of times
    in the given string.

    catDog("catdog") → true
    catDog("catcat") → false
    catDog("1cat1cadodog") → true
     */
    static boolean catDog(String str) {
        if (str.length() < 3) {
            return true;
        }
        int catCount = 0;
        int dogCount = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i+3).equals("cat")) {
                catCount++;
            }
            if (str.substring(i, i+3).equals("dog")) {
                dogCount++;
            }
        }
        return catCount == dogCount;
    }

    /*
    Return the number of times that the string "code" appears anywhere in the given string,
    except we'll accept any letter for the 'd', so "cope" and "cooe" count.

    countCode("aaacodebbb") → 1
    countCode("codexxcode") → 2
    countCode("cozexxcope") → 2
     */
    static int countCode(String str) {
        if (str.length() < 4) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i+2).equals("co") && str.substring(i+3, i+4).equals("e")) {
                count++;
            }
        }
        return count;
    }

    /*
    Given two strings,
    return true if either of the strings appears at the very end of the other string,
    ignoring upper/lower case differences
    (in other words, the computation should not be "case sensitive").

    endOther("Hiabc", "abc") → true
    endOther("AbC", "HiaBc") → true
    endOther("abc", "abXabc") → true
     */
    static boolean endOther(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        if (b.substring(b.length()-a.length()).toLowerCase().equals(a.toLowerCase())) {
            return true;
        }
        return false;
    }

    /*
    Return true if the given string contains an appearance of "xyz"
    where the xyz is not directly preceeded by a period (.).
    So "xxyz" counts but "x.xyz" does not.

    xyzThere("abcxyz") → true
    xyzThere("abc.xyz") → false
    xyzThere("xyz.abc") → true
     */
    static boolean xyzThere(String str) {
        if (str.length() < 3) {
            return false;
        }
        if (str.substring(0, 3).equals("xyz")) {
            return true;
        }
        for (int i = 1; i < str.length()-2; i++) {
            if (str.substring(i, i+3).equals("xyz") && str.charAt(i-1) != '.') {
                return true;
            }
        }
        return false;
    }

    /*
    Return true if the given string contains a "bob" string,
    but where the middle 'o' char can be any char.

    bobThere("abcbob") → true
    bobThere("b9b") → true
    bobThere("bac") → false
     */
    static boolean bobThere(String str) {
        if (str.length() < 3) return false;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b') {
                return true;
            }
        }
        return false;
    }

    

    public static void main(String[] args) {
        // DoubleChar:
        print();
        print(" DoubleChar:");
        print("TThhee : " + doubleChar("The"));
        print("AAAAbbbb : " + doubleChar("AAbb"));
        print("HHii--TThheerree : " + doubleChar("Hi-There"));

        // CountHi:
        print();
        print(" CountHi:");
        print("1 : " + countHi("abc hi ho"));
        print("2 : " + countHi("ABCChi hi"));
        print("2 : " + countHi("hihi"));

        // CatDog:
        print();
        print(" CatDog:");
        print("True : " + catDog("catdog"));
        print("False : " + catDog("catcat"));
        print("True : " + catDog("1cat1cadodog"));

        // CountCode:
        print();
        print(" CountCode:");
        print("1 : " + countCode("aaacodebbb"));
        print("2 : " + countCode("codexxcode"));
        print("2 : " + countCode("cozexxcope"));

        // EndOther:
        print();
        print(" EndOther:");
        print("True : " + endOther("Hiabc", "abc"));
        print("True : " + endOther("AbC", "HiaBc"));
        print("True : " + endOther("abc", "abXabc"));

        // XyzThere:
        print();
        print(" XyzThere:");
        print("True : " + xyzThere("abcxyz"));
        print("False : " + xyzThere("abc.xyz"));
        print("True : " + xyzThere("xyz.abc"));
        print("True : " + xyzThere("xyz"));

        // BobThere:
        print();
        print(" BobThere:");
        print("True : " + bobThere("abcbob"));
        print("True : " + bobThere("b9b"));
        print("False : " + bobThere("bac"));

    }

}
