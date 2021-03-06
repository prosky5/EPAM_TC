package ex5_Logic1;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions11_20 {

    /*
    Return true if the given non-negative number is a multiple of 3 or 5, but not both.
    Use the % "mod" operator.

    old35(3) → true
    old35(10) → true
    old35(15) → false
     */
    static boolean old35(int n) {
        return (n % 3 == 0) ^ (n % 5 == 0);
    }

    /*
    Return true if the given non-negative number is 1 or 2 less than a multiple of 20.
    So for example 38 and 39 return true, but 40 returns false.

    less20(18) → true
    less20(19) → true
    less20(20) → false
     */
    static boolean less20(int n) {
        return (n+1) % 20 == 0 || (n+2) % 20 == 0;
    }

    /*
    Given a non-negative number "num",
    return true if num is within 2 of a multiple of 10.
    Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2.

    nearTen(12) → true
    nearTen(17) → false
    nearTen(19) → true
     */
    static boolean nearTen(int num) {
        return num % 10 <= 2 || num % 10 >= 8;
    }

    /*
    Given 2 ints, a and b, return their sum.
    However, "teen" values in the range 13..19 inclusive, are extra lucky.
    So if either value is a teen, just return 19.

    teenSum(3, 4) → 7
    teenSum(10, 13) → 19
    teenSum(13, 2) → 19
     */
    static int teenSum(int a, int b) {
        if (a >= 13 && a <= 19 || b >= 13 && b <= 19) {
            return 19;
        } else {
            return a + b;
        }
    }

    /*
    Your cell phone rings. Return true if you should answer it.
    Normally you answer, except in the morning you only answer if it is your mom calling.
    In all cases, if you are asleep, you do not answer.

    answerCell(false, false, false) → true
    answerCell(false, false, true) → false
    answerCell(true, false, false) → false
     */
    static boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
        return !(isMorning && !isMom || isAsleep);
    }

    /*
    We are having a party with amounts of tea and candy.
    Return the int outcome of the party encoded as 0=bad, 1=good, or 2=great.
    A party is good (1) if both tea and candy are at least 5.
    However, if either tea or candy is at least double the amount of the other one,
    the party is great (2).
    However, in all cases, if either tea or candy is less than 5,
    the party is always bad (0).

    teaParty(6, 8) → 1
    teaParty(3, 8) → 0
    teaParty(20, 6) → 2
     */
    static int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5) {
            return 0;
        } else if (tea/candy >= 2 || candy/tea >= 2) {
                return 2;
        } else {
            return 1;
        }
    }

    /*
    Given a string str, if the string starts with "f" return "Fizz".
    If the string ends with "b" return "Buzz".
    If both the "f" and "b" conditions are true, return "FizzBuzz".
    In all other cases, return the string unchanged.

    fizzString("fig") → "Fizz"
    fizzString("dib") → "Buzz"
    fizzString("fib") → "FizzBuzz"
     */
    static String fizzString(String str) {
        String str2 = "";
        if (str.length() > 0) {
            if (str.charAt(0) == 'f') {
                str2 += "Fizz";
            }
            if (str.charAt(str.length() - 1) == 'b') {
                str2 += "Buzz";
            }
        }
        return str2.length() == 0 ? str : str2;
    }

    /*
    Given an int n, return the string form of the number followed by "!".
    So the int 6 yields "6!".
    Except if the number is divisible by 3 use "Fizz" instead of the number,
    and if the number is divisible by 5 use "Buzz",
    and if divisible by both 3 and 5, use "FizzBuzz".
    Note: the % "mod" operator computes the remainder after division,
    so 23 % 10 yields 3.
    What will the remainder be when one number divides evenly into another?

    fizzString2(1) → "1!"
    fizzString2(2) → "2!"
    fizzString2(3) → "Fizz!"
     */
    static String fizzString2(int n) {
        boolean f = (n % 3 == 0);
        boolean b = (n % 5 == 0);

        if (f && b) return "FizzBuzz!";
        if (f) return "Fizz!";
        if (b) return "Buzz!";
        return n + "!";
    }

    /*
    Given three ints, a b c,
    return true if it is possible to add two of the ints to get the third.

    twoAsOne(1, 2, 3) → true
    twoAsOne(3, 1, 2) → true
    twoAsOne(3, 2, 2) → false
     */
    static boolean twoAsOne(int a, int b, int c) {
        return a - b == c || a - c == b
                || c - a == b || c - b == a
                || b - a == c || b - c == a;
    }

    /*
    Given three ints, a b c,
    return true if b is greater than a, and c is greater than b.
    However, with the exception that if "bOk" is true, b does not need to be greater than a.

    inOrder(1, 2, 4, false) → true
    inOrder(1, 2, 1, false) → false
    inOrder(1, 1, 2, true) → true
     */
    static boolean inOrder(int a, int b, int c, boolean bOk) {
        return bOk ? (c > b) : (c > b) && (b > a);
    }



    public static void main(String[] args) {

        // Old35:
        print();
        print(" Old35:");
        print("True : " + old35(3));
        print("True : " + old35(10));
        print("False : " + old35(15));

        // Less20:
        print();
        print(" Less20:");
        print("True : " + less20(18));
        print("True : " + less20(19));
        print("False : " + less20(20));

        // NearTen:
        print();
        print(" NearTen:");
        print("True : " + nearTen(12));
        print("False : " + nearTen(17));
        print("True : " + nearTen(19));

        // TeenSum:
        print();
        print(" TeenSum:");
        print("7 : " + teenSum(3, 4));
        print("19 : " + teenSum(10, 13));
        print("19 : " + teenSum(13, 2));

        // AnswerCell:
        print();
        print(" AnswerCell:");
        print("True : " + answerCell(false, false , false));
        print("False : " + answerCell(false, false , true));
        print("False : " + answerCell(true, false , false));
        print("True : " + answerCell(true, true , false));

        // TeaParty:
        print();
        print(" TeaParty:");
        print("1 : " + teaParty(6, 8));
        print("0 : " + teaParty(3, 8));
        print("2 : " + teaParty(20, 6));

        // FizzString:
        print();
        print(" FizzString:");
        print("Fizz : " + fizzString("fig"));
        print("Buzz : " + fizzString("dib"));
        print("FizzBuzz : " + fizzString("fib"));

        // FizzString2:
        print();
        print(" FizzString2:");
        print("1! : " + fizzString2(1));
        print("2! : " + fizzString2(2));
        print("Fizz! : " + fizzString2(3));

        // TwoAsOne:
        print();
        print(" TwoAsOne:");
        print("True : " + twoAsOne(1, 2, 3));
        print("True : " + twoAsOne(3, 1, 2));
        print("False : " + twoAsOne(3, 2, 2));

        // InOrder:
        print();
        print(" InOrder:");
        print("True : " + inOrder(1, 2, 4, false));
        print("False : " + inOrder(1, 2, 1, false));
        print("True : " + inOrder(1, 1, 2, true));

    }
}
