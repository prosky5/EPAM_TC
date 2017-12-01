package ex1_Warmup1;

import static utils.Print.print;

public class Solutions1_10 {
    /*
    The parameter weekday is true if it is a weekday,
    and the parameter vacation is true if we are on vacation.
    We sleep in if it is not a weekday or we're on vacation.
    Return true if we sleep in.

    sleepIn(false, false) → true
    sleepIn(true, false) → false
    sleepIn(false, true) → true */
    private static boolean sleepIn(boolean weekday, boolean vacation) {
        return (!weekday || vacation);
    }

    /*
    We have two monkeys, a and b, and the parameters aSmile
    and bSmile indicate if each is smiling.
    We are in trouble if they are both smiling or if neither of them is smiling.
    Return true if we are in trouble.

    monkeyTrouble(true, true) → true
    monkeyTrouble(false, false) → true
    monkeyTrouble(true, false) → false
     */
    private static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return  (aSmile == bSmile);
    }

    /*
    Given two int values, return their sum.
    Unless the two values are the same, then return double their sum.

    sumDouble(1, 2) → 3
    sumDouble(3, 2) → 5
    sumDouble(2, 2) → 8
     */
    private static int sumDouble(int a, int b) {
        if (a == b) {
            return a * 4;
        } else {
            return a + b;
        }
    }

    /*
    Given an int n, return the absolute difference between n and 21,
    except return double the absolute difference if n is over 21.

    diff21(19) → 2
    diff21(10) → 11
    diff21(21) → 0
     */
    private static int diff21(int n) {
        if (n > 21) {
            return Math.abs(21 - n) * 2;
        } else {
            return 21 - n;
        }
    }

    /*
    We have a loud talking parrot.
    The "hour" parameter is the current hour time in the range 0..23.
    We are in trouble if the parrot is talking and the hour is before 7 or after 20.
    Return true if we are in trouble.

    parrotTrouble(true, 6) → true
    parrotTrouble(true, 7) → false
    parrotTrouble(false, 6) → false
     */
    private static boolean parrotTrouble(boolean talking, int hour) {
        return ( talking && ((hour > 20) || (hour < 7)) );
    }

    /*
    Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.

    makes10(9, 10) → true
    makes10(9, 9) → false
    makes10(1, 9) → true
     */
    private static boolean makes10(int a, int b) {
        return  (a == 10 || b == 10 || a + b == 10);
    }

    /*
    Given an int n, return true if it is within 10 of 100 or 200.
    Note: Math.abs(num) computes the absolute value of a number.

    nearHundred(93) → true
    nearHundred(90) → true
    nearHundred(89) → fals
     */
    private static boolean nearHundred(int n) {
        return  ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10));
    }

    /*
    Given 2 int values, return true if one is negative and one is positive.
    Except if the parameter "negative" is true,
    then return true only if both are negative.

    posNeg(1, -1, false) → true
    posNeg(-1, 1, false) → true
    posNeg(-4, -5, true) → true
     */
    private static boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return (a < 0 && b < 0);
        } else {
            return (a < 0 ^ b < 0);
        }
    }

    /*
    Given a string, return a new string where "not " has been added to the front.
    However, if the string already begins with "not", return the string unchanged.
    Note: use .equals() to compare 2 strings.

    notString("candy") → "not candy"
    notString("x") → "not x"
    notString("not bad") → "not bad"
     */
    private static String notString(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
            return str;
        } else {
            return "not " + str;
        }
    }

    /*
    Given a non-empty string and an int n,
    return a new string where the char at index n has been removed.
    The value of n will be a valid index of a char in the original string
    (i.e. n will be in the range 0..str.length()-1 inclusive).

    missingChar("kitten", 1) → "ktten"
    missingChar("kitten", 0) → "itten"
    missingChar("kitten", 4) → "kittn"
     */
    private static String missingChar(String str, int n) {
        String a = str.substring(0, n);
        String b = str.substring(n+1, str.length());
        return a + b;
    }




    public static void main(String[] args) {
        // SleepIn:
        print();
        print(" SleepIn:");
        print("True : " + sleepIn(true, true));
        print("False : " + sleepIn(true, false));
        print("True : " + sleepIn(false, true));
        print("True : " + sleepIn(false, false));

        // MonkeyTrouble:
        print();
        print(" MonkeyTrouble:");
        print("True : " + monkeyTrouble(true, true));
        print("False : " + monkeyTrouble(true, false));
        print("False : " + monkeyTrouble(false, true));
        print("True : " + monkeyTrouble(false, false));

        // SumDouble:
        print();
        print(" SumDouble:");
        print("3 = " + sumDouble(1, 2));
        print("5 = " + sumDouble(3, 2));
        print("8 = " + sumDouble(2, 2));

        // Dif21:
        print();
        print(" Dif21:");
        print("2 = " + diff21(19));
        print("11 = " + diff21(10));
        print("0 = " + diff21(21));
        print("5 = " + diff21(26));

        // ParrotTrouble:
        print();
        print(" ParrotTrouble:");
        print("True : " + parrotTrouble(true, 6));
        print("False : " + parrotTrouble(true, 7));
        print("False : " + parrotTrouble(true, 13));
        print("True : " + parrotTrouble(true, 21));
        print("False : " + parrotTrouble(false, 6));
        print("False : " + parrotTrouble(false, 22));

        // Makes10:
        print();
        print(" Makes10:");
        print("True : " + makes10(9, 10));
        print("False : " + makes10(9, 9));
        print("True : " + makes10(1, 9));

        // NearHundred:
        print();
        print(" NearHundred:");
        print("True : " + nearHundred(93));
        print("True : " + nearHundred(90));
        print("False : " + nearHundred(83));
        print("False : " + nearHundred(89));

        // PosNeg:
        print();
        print(" PosNeg:");
        print("True : " + posNeg(1, -1, false));
        print("True : " + posNeg(-1, 1, false));
        print("True : " + posNeg(-4, -5, true));
        print("False : " + posNeg(1, 1, true));
        print("False : " + posNeg(4, 5, true));
        print("False : " + posNeg(4, -5, true));
        print("False : " + posNeg(-4, -5, false));

        // NotString:
        print();
        print(" NotString:");
        print("not candy : " + notString("candy"));
        print("not x : " + notString("x"));
        print("not bad : " + notString("not bad"));

        // MissingChar:
        print();
        print(" MissingChar:");
        print("ktten : " + missingChar("kitten", 1));
        print("itten : " + missingChar("kitten", 0));
        print("kittn : " + missingChar("kitten", 4));

    }
}
