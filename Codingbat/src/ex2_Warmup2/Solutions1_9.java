package ex2_Warmup2;

import static utils.Print.print;

/**
 * Created by User on 030 30.11.17.
 */

public class Solutions1_9 {
    /*
    Given a string and a non-negative int n,
    return a larger string that is n copies of the original string.

    stringTimes("Hi", 2) → "HiHi"
    stringTimes("Hi", 3) → "HiHiHi"
    stringTimes("Hi", 1) → "Hi"
     */
    static String stringTimes(String str, int n) {
        String out = "";
        for (int i = 0; i < n; i++) {
            out += str;
        }
        return out;
    }

    /*
    Given a string and a non-negative int n,
    we'll say that the front of the string is the first 3 chars,
    or whatever is there if the string is less than length 3.
    Return n copies of the front;

    frontTimes("Chocolate", 2) → "ChoCho"
    frontTimes("Chocolate", 3) → "ChoChoCho"
    frontTimes("Abc", 3) → "AbcAbcAbc"
     */
    static String frontTimes(String str, int n) {
        String out = "";
        if (str.length() >= 3) {
            for (int i = 0; i < n; i++) {
                out += str.substring(0, 3);
            }
        } else {
            for (int i = 0; i < n; i++) {
                out += str;
            }
        }
        return out;
    }

    /*
    Count the number of "xx" in the given string.
    We'll say that overlapping is allowed, so "xxx" contains 2 "xx".

    countXX("abcxx") → 1
    countXX("xxx") → 2
    countXX("xxxx") → 3
     */
    static int countXX(String str) {
        if(str.length() < 2) {
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i+1 < str.length(); i++) {
                if (str.substring(i, i+2).equals("xx")) {
                    count++;
                }
            }
            return count;
        }
    }

    /*
    Given a string,
    return true if the first instance of "x"
    in the string is immediately followed by another "x".

    doubleX("axxbb") → true
    doubleX("axaxax") → false
    doubleX("xxxxx") → true
     */
    static boolean doubleX(String str) {
        for (int i = 0; i+1 < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                if (str.substring(i, i + 2).equals("xx")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /*
    Given a string,
    return a new string made of every other char starting with the first,
    so "Hello" yields "Hlo".

    stringBits("Hello") → "Hlo"
    stringBits("Hi") → "H"
    stringBits("Heeololeo") → "Hello"
     */
    static String stringBits(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                out += str.charAt(i);
            }
        }
        return out;
    }

    /*
    Given a non-empty string like "Code" return a string like "CCoCodCode".

    stringSplosion("Code") → "CCoCodCode"
    stringSplosion("abc") → "aababc"
    stringSplosion("ab") → "aab"
     */
    static String stringSplosion(String str) {
        String out = "";
        for (int i = 1; i <= str.length(); i++) {
            out += str.substring(0, i);
        }
        return out;
    }

    /*
    Given a string,
    return the count of the number of times
    that a substring length 2 appears in the string
    and also as the last 2 chars of the string,
    so "hixxxhi" yields 1 (we won't count the end substring).

    last2("hixxhi") → 1
    last2("xaxxaxaxx") → 1
    last2("axxxaaxx") → 2
     */
    static int last2(String str) {
        int count = 0;
        int endLength = str.length();
        if (endLength < 3) {
            return 0;
        } else {
            String lastChrs = str.substring(endLength - 2, endLength);
            for (int i = 0; i < endLength - 2; i++) {
                if (str.substring(i, i + 2).equals(lastChrs)) {
                    count++;
                }
            }
            return count;
        }
    }

    /*
    Given an array of ints, return the number of 9's in the array.

    arrayCount9([1, 2, 9]) → 1
    arrayCount9([1, 9, 9]) → 2
    arrayCount9([1, 9, 9, 3, 9]) → 3
     */
    static int arrayCount9(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9) {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array of ints,
    return true if one of the first 4 elements in the array is a 9.
    The array length may be less than 4.

    arrayFront9([1, 2, 9, 3, 4]) → true
    arrayFront9([1, 2, 3, 4, 9]) → false
    arrayFront9([1, 2, 3, 4, 5]) → false
     */
    static boolean arrayFront9(int[] nums) {
        for (int i = 0; i < nums.length && i < 4; i++) {
            if (nums[i] == 9) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        print();
        print("Expectation : Reality");

        // StringTimes:
        print();
        print(" StringTimes:");
        print("HiHi : " + stringTimes("Hi", 2));
        print("HiHiHi : " + stringTimes("Hi", 3));
        print("Hi : " + stringTimes("Hi", 1));

        // FrontTimes:
        print();
        print(" FrontTimes:");
        print("ChoCho : " + frontTimes("Chocolate" , 2));
        print("ChoChoCho : " + frontTimes("Chocolate" , 3));
        print("AbcAbcAbc : " + frontTimes("Abc" , 3));

        // CountXX:
        print();
        print(" CountXX:");
        print("1 : " +  countXX("abcxx"));
        print("2 : " +  countXX("xxx"));
        print("3 : " +  countXX("xxxx"));

        // DoubleX:
        print();
        print(" DoubleX:");
        print("True : " + doubleX("axxbb"));
        print("False : " + doubleX("axaxax"));
        print("True : " + doubleX("xxxxx"));
        print("False : " + doubleX("xaxxx"));
        print("False : " + doubleX("xaxx"));

        // StringBits:
        print();
        print(" StringBits:");
        print("Hlo : " + stringBits("Hello"));
        print("H : " + stringBits("Hi"));
        print("Hello : " + stringBits("Heeololeo"));

        // StringSplosion:
        print();
        print(" StringSplosion:");
        print("CCoCodCode : " + stringSplosion("Code"));
        print("aababc : " + stringSplosion("abc"));
        print("aab : " + stringSplosion("ab"));

        // Last2:
        print();
        print(" Last2:");
        print("1 : " + last2("hixxhi"));
        print("1 : " + last2("xaxxaxaxx"));
        print("2 : " + last2("axxxaaxx"));

        // ArrayCount9:
        print();
        print(" ArrayCount9:");
        print("1 : " + arrayCount9(new int[]{1, 2, 9}));
        print("2 : " + arrayCount9(new int[]{1, 9, 9}));
        print("3 : " + arrayCount9(new int[]{1, 9, 9, 3, 9}));

        // ArrayFront9:
        print();
        print(" ArrayFront9");
        print("True : " + arrayFront9(new int[]{1, 2, 9, 3, 4}));
        print("False : " + arrayFront9(new int[]{1, 2, 3, 4, 9}));
        print("False : " + arrayFront9(new int[]{1, 2, 3, 4, 5}));




    }
}
