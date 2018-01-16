package ex5_Logic1;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions21_30 {

    /*
    Given three ints, a b c,
    return true if they are in strict increasing order,
    such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7.
    However, with the exception that if "equalOk" is true, equality is allowed,
    such as 5 5 7 or 5 5 5.

    inOrderEqual(2, 5, 11, false) → true
    inOrderEqual(5, 7, 6, false) → false
    inOrderEqual(5, 5, 7, true) → true
     */
    static boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        return equalOk ? a <= b && b <= c : a < b && b < c;
    }

    /*
    Given three ints, a b c,
    return true if two or more of them have the same rightmost digit.
    The ints are non-negative.

    lastDigit(23, 19, 13) → true
    lastDigit(23, 19, 12) → false
    lastDigit(23, 19, 3) → true
     */
    static boolean lastDigit(int a, int b, int c) {
        a = a % 10;
        b = b % 10;
        c = c % 10;
        return a == b || b == c || a == c;
    }

    /*
    Given three ints, a b c,
    return true if one of them is 10 or more less than one of the others.

    lessBy10(1, 7, 11) → true
    lessBy10(1, 7, 10) → false
    lessBy10(11, 1, 7) → true
     */
    static boolean lessBy10(int a, int b, int c) {
        return Math.abs(a - b) >= 10 || Math.abs(b - c) >= 10 || Math.abs(a - c) >= 10;
    }

    /*
    Return the sum of two 6-sided dice rolls, each in the range 1..6.
    However, if noDoubles is true, if the two dice show the same value,
    increment one die to the next value, wrapping around to 1 if its value was 6.

    withoutDoubles(2, 3, true) → 5
    withoutDoubles(3, 3, true) → 7
    withoutDoubles(3, 3, false) → 6
     */
    static int withoutDoubles(int die1, int die2, boolean noDoubles) {
        return noDoubles ? ifDoublesTrue(die1, die2) : die1 + die2;
    }

    static int ifDoublesTrue(int a, int b) {
        int summ = a + b;
        if (a == b) {
            if (a == 6) a = 1;
            else a++;
            summ = a + b;
        }
        return summ;
    }

    /*
    Given two int values, return whichever value is larger.
    However if the two values have the same remainder when divided by 5,
    then the return the smaller value.
    However, in all cases, if the two values are the same, return 0.

    maxMod5(2, 3) → 3
    maxMod5(6, 2) → 6
    maxMod5(3, 2) → 3
     */
    static int maxMode5(int a, int b) {
        if (a == b) {
            return 0;
        }
        if (a % 5 == b % 5) {
            return a > b ? b : a;
        } else {
            return a > b ? a : b;
        }
    }

    /*
    You have a red lottery ticket showing ints a, b, and c, each of which is 0, 1, or 2.
    If they are all the value 2, the result is 10.
    Otherwise if they are all the same, the result is 5.
    Otherwise so long as both b and c are different from a, the result is 1.
    Otherwise the result is 0.

    redTicket(2, 2, 2) → 10
    redTicket(2, 2, 1) → 0
    redTicket(0, 0, 0) → 5
     */
    static int redTicket(int a, int b, int c) {
        if (a == 2 && b == 2 && c == 2) {
            return 10;
        }
        else if (a == b && b == c && a == c) {
            return 5;
        }
        else if (b != a && c != a) {
            return 1;
        } else {
            return 0;
        }
    }

    /*
    You have a green lottery ticket, with ints a, b, and c on it.
    If the numbers are all different from each other, the result is 0.
    If all of the numbers are the same, the result is 20.
    If two of the numbers are the same, the result is 10.

    greenTicket(1, 2, 3) → 0
    greenTicket(2, 2, 2) → 20
    greenTicket(1, 1, 2) → 10
     */
    static int greenTicket(int a, int b, int c) {
        boolean one = a == b;
        boolean two = b == c;
        boolean three = a == c;
        if (one && two && three) {
            return 20;
        }
        if (one ^ two ^ three) {
            return 10;
        }
        return 0;
    }

    /*
    You have a blue lottery ticket, with ints a, b, and c on it.
    This makes three pairs, which we'll call ab, bc, and ac.
    Consider the sum of the numbers in each pair.
    If any pair sums to exactly 10, the result is 10.
    Otherwise if the ab sum is exactly 10 more than either bc or ac sums, the result is 5.
    Otherwise the result is 0.

    blueTicket(9, 1, 0) → 10
    blueTicket(9, 2, 0) → 0
    blueTicket(6, 1, 4) → 10
     */
    static int blueTicket(int a, int b, int c) {
        int ab = a + b;
        int bc = b + c;
        int ac = a + c;
        if (ab == 10 || bc == 10 || ac == 10) {
            return 10;
        }
        else if (ab - bc == 10 || ab - ac == 10) {
            return 5;
        } else {
            return 0;
        }
    }

    /*
    Given two ints, each in the range 10..99,
    return true if there is a digit that appears in both numbers,
    such as the 2 in 12 and 23.

    shareDigit(12, 23) → true
    shareDigit(12, 43) → false
    shareDigit(12, 44) → false
     */
    static boolean shareDigit(int a, int b) {
        int aOne = a / 10;
        int aTwo = a % 10;
        int bOne = b / 10;
        int bTwo = b % 10;
        return (aOne == bOne || aOne == bTwo) || (aTwo == bOne || aTwo == bTwo);
    }

    /*
    Given 2 non-negative ints, a and b, return their sum,
    so long as the sum has the same number of digits as a.
    If the sum has more digits than a, just return a without b.

    sumLimit(2, 3) → 5
    sumLimit(8, 3) → 8
    sumLimit(8, 1) → 9
     */
    static int sumLimit(int a, int b) {
        int lim = String.valueOf(a).length();
        int sum = a + b;
        return String.valueOf(sum).length() == lim ? sum : a;
    }

    public static void main(String[] args) {
        // InOrderEqual:
        print();
        print(" InOrderEqual:");
        print("True : " + inOrderEqual(2, 5, 11, false));
        print("False : " + inOrderEqual(5, 7, 6, false));
        print("True : " + inOrderEqual(5, 5, 7, true));

        // LastDigit:
        print();
        print(" LastDigit:");
        print("True : " + lastDigit(23, 19, 13));
        print("False : " + lastDigit(23, 19, 12));
        print("True : " + lastDigit(23, 19, 3));

        // LessBy10:
        print();
        print(" LessBy10:");
        print("True : " + lessBy10(1, 7, 11));
        print("False : " + lessBy10(1, 7, 10));
        print("True : " + lessBy10(11, 1, 7));

        // WithoutDoubles:
        print();
        print(" WithoutDoubles:");
        print("5 : " + withoutDoubles(2, 3, true));
        print("7 : " + withoutDoubles(3, 3, true));
        print("6 : " + withoutDoubles(3, 3, false));

        // MaxMode5:
        print();
        print(" MaxMode5:");
        print("3 : " + maxMode5(2, 3));
        print("6 : " + maxMode5(6, 2));
        print("3 : " + maxMode5(3, 2));

        // RedTicket:
        print();
        print(" RedTicket:");
        print("10 : " + redTicket(2, 2, 2));
        print("0 : " + redTicket(2, 2, 1));
        print("5 : " + redTicket(0, 0, 0));

        // GreenTicket:
        print();
        print(" GreenTicket:");
        print("0 : " + greenTicket(1, 2, 3));
        print("20 : " + greenTicket(2, 2, 2));
        print("10 : " + greenTicket(1, 1, 2));

        // BlueTicket:
        print();
        print(" BlueTicket:");
        print("10 : " + blueTicket(9, 1, 0));
        print("0 : " + blueTicket(9, 2, 0));
        print("10 : " + blueTicket(6, 1, 4));

        // ShareDigit:
        print();
        print(" ShareDigit:");
        print("True : " + shareDigit(12, 23));
        print("False : " + shareDigit(12, 43));
        print("False : " + shareDigit(12, 44));

        // SumLimit:
        print();
        print(" SumLimit:");
        print("5 : " + sumLimit(2, 3));
        print("8 : " + sumLimit(8, 3));
        print("9 : " + sumLimit(8, 1));

    }
}
