package ex6_Logic2;


import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions1_9 {
    /*
    We want to make a row of bricks that is goal inches long.
    We have a number of small bricks (1 inch each) and big bricks (5 inches each).
    Return true if it is possible to make the goal by choosing from the given bricks.
    This is a little harder than it looks and can be done without any loops.

    makeBricks(3, 1, 8) → true
    makeBricks(3, 1, 9) → false
    makeBricks(3, 2, 10) → true
     */
    static boolean mekeBricks(int small, int big, int goal) {
        final int SMALL_SIZE_BRICKS = 1;
        final int BIG_SIZE_BRICKS = 5;
        int res = 0;

        while (res < goal && big > 0) {
            res += BIG_SIZE_BRICKS;
            big--;
            if (res == goal) {
                return true;
            }
            if (res > goal) {
                res -= BIG_SIZE_BRICKS;
                big = 0;
            }
        }

        while (res < goal && small > 0) {
            res += SMALL_SIZE_BRICKS;
            small--;
            if (res == goal) {
                return true;
            }
        }
        return false;
        //short solution:
//        if (goal > big * 5 + small) return false;
//        if (goal % 5 > small) return false;
//        return true;
    }

    /*
    Given 3 int values, a b c, return their sum.
    However, if one of the values is the same as another of the values,
    it does not count towards the sum.

    loneSum(1, 2, 3) → 6
    loneSum(3, 2, 3) → 2
    loneSum(3, 3, 3) → 0
     */
    static int loneSum(int a, int b, int c) {
        if (a == b && a == c && b == c) return 0;
        if (a == b) return c;
        if (b == c) return a;
        if (a == c) return b;
        return a + b + c;
    }

    /*
    Given 3 int values, a b c, return their sum.
    However, if one of the values is 13 then it does not count towards the sum
    and values to its right do not count.
    So for example, if b is 13, then both b and c do not count.

    luckySum(1, 2, 3) → 6
    luckySum(1, 2, 13) → 3
    luckySum(1, 13, 3) → 1
     */
    static int luckySum(int a, int b, int c) {
        final int WALLNUM = 13;
        if (a == WALLNUM) return 0;
        if (b == WALLNUM) return a;
        if (c == WALLNUM) return a + b;
        return a + b + c;
    }

    /*
    Given 3 int values, a b c, return their sum.
    However, if any of the values is a teen -- in the range 13..19 inclusive --
    then that value counts as 0, except 15 and 16 do not count as a teens.
    Write a separate helper "public int fixTeen(int n) {"
    that takes in an int value and returns that value fixed for the teen rule.
    In this way, you avoid repeating the teen code 3 times (i.e. "decomposition").
    Define the helper below and at the same indent level as the main noTeenSum().

    noTeenSum(1, 2, 3) → 6
    noTeenSum(2, 13, 1) → 3
    noTeenSum(2, 1, 14) → 3
     */
    static int noTeenSum(int a, int b, int c) {
        return fixTeen(a) + fixTeen(b) + fixTeen(c);
    }

    public static int fixTeen(int n) {
        final int minVal = 13;
        final int mid1Val = 15;
        final int mid2Val = 16;
        final int maxVal = 19;
        if (n >= minVal && n < mid1Val || n > mid2Val && n <= maxVal) {
            return 0;
        }
        return n;
    }

    /*
    For this problem, we'll round an int value up to the next multiple of 10
    if its rightmost digit is 5 or more, so 15 rounds up to 20.
    Alternately, round down to the previous multiple of 10
    if its rightmost digit is less than 5, so 12 rounds down to 10.
    Given 3 ints, a b c, return the sum of their rounded values.
    To avoid code repetition, write a separate helper "public int round10(int num) {"
    and call it 3 times.
    Write the helper entirely below and at the same indent level as roundSum().

    roundSum(16, 17, 18) → 60
    roundSum(12, 13, 14) → 30
    roundSum(6, 4, 4) → 10
     */
    static int roundSum(int a, int b, int c) {
        return round10(a) + round10(b) + round10(c);
    }

    public static int round10(int num) {
        int res = 0;
        int rem = num % 10;
        if (rem >= 5) {
            res = num + (10 - rem);
        } else {
            res = num - rem;
        }
        return res;
    }

    /*
    Given three ints, a b c,
    return true if one of b or c is "close" (differing from a by at most 1),
    while the other is "far", differing from both other values by 2 or more.

    closeFar(1, 2, 10) → true
    closeFar(1, 2, 3) → false
    closeFar(4, 1, 3) → true
     */
    static boolean closeFar(int a, int b, int c) {
        if (Math.abs(a - b) <= 1) {
            return Math.abs(a - c) > 1 && Math.abs(b - c) > 1;
        }
        if (Math.abs(a - c) <= 1) {
            return Math.abs(a - b) > 1 && Math.abs(c - b) > 1;
        }
        return false;
    }

    /*
    Given 2 int values greater than 0,
    return whichever value is nearest to 21 without going over.
    Return 0 if they both go over.

    blackjack(19, 21) → 21
    blackjack(21, 19) → 21
    blackjack(19, 22) → 19
     */
    static int blackjack(int a, int b) {
        int first = 21 - a;
        int second = 21 - b;

        if (21 - a < 0 && 21 - b < 0) {
            return 0;
        }

        if (first < 0) return b;
        if (second < 0) return a;

        if (first < second) {
            return a;
        } else {
            return b;
        }
    }

    /*
    Given three ints, a b c,
    one of them is small, one is medium and one is large.
    Return true if the three values are evenly spaced,
    so the difference between small and medium
    is the same as the difference between medium and large.

    evenlySpaced(2, 4, 6) → true
    evenlySpaced(4, 6, 2) → true
    evenlySpaced(4, 6, 3) → false
     */
    static boolean evenlySpaced(int a, int b, int c) {
        int tmp;
        boolean odd = true;
        while (!(a >= b && b >= c)) {   // Kruchu-verchu
            if (odd) {
                tmp = b;
                b = a;
                a = tmp;
                odd = false;
            } else {
                tmp = b;
                b = c;
                c = tmp;
                odd = true;
            }
        }
        return Math.abs(b - a) == Math.abs(b - c);
    }

    /*
    We want make a package of goal kilos of chocolate.
    We have small bars (1 kilo each) and big bars (5 kilos each).
    Return the number of small bars to use, assuming we always use big bars before small bars.
    Return -1 if it can't be done.

    makeChocolate(4, 1, 9) → 4
    makeChocolate(4, 1, 10) → -1
    makeChocolate(4, 1, 7) → 2
     */
    static int makeChocolate(int small, int big, int goal) {
        if (goal > big * 5 + small) return -1;
        if (goal % 5 > small) return -1;
        int tmp = 0;
        while (goal - tmp >= 5 && big > 0) {
            tmp += 5;
            big--;
        }
        return goal - tmp;
    }


    public static void main(String[] args) {
        // MakeBricks:
        print();
        print(" MakeBricks:");
        print("True : " + mekeBricks(3, 1, 8));
        print("False : " + mekeBricks(3, 1, 9));
        print("True : " + mekeBricks(3, 2, 10));

        // LoneSum:
        print();
        print(" LoneSum:");
        print("6 : " + loneSum(1, 2, 3));
        print("2 : " + loneSum(3, 2, 3));
        print("0 : " + loneSum(3, 3, 3));

        // LuckySum:
        print();
        print(" LuckySum:");
        print("6 : " + luckySum(1, 2, 3));
        print("3 : " + luckySum(1, 2, 13));
        print("1 : " + luckySum(1, 13, 3));

        // NoTeenSum:
        print();
        print(" NoTeenSum:");
        print("6 : " + noTeenSum(1, 2, 3));
        print("3 : " + noTeenSum(2, 13, 1));
        print("3 : " + noTeenSum(2, 1, 14));

        // RoundSum:
        print();
        print(" RoundSum:");
        print("60 : " + roundSum(16, 17, 18));
        print("30 : " + roundSum(12, 13, 14));
        print("10 : " + roundSum(6, 4, 4));

        // CloseFar:
        print();
        print(" CloseFar:");
        print("True : " + closeFar(1, 2, 10));
        print("False : " + closeFar(1, 2, 3));
        print("True : " + closeFar(4, 1, 3));

        // Blackjack:
        print();
        print(" Blackjack:");
        print("21 : " + blackjack(19, 21));
        print("21 : " + blackjack(21, 19));
        print("19 : " + blackjack(19, 22));

        // EvenlySpaced:
        print();
        print(" EvenlySpaced:");
        print("True : " + evenlySpaced(2, 4, 6));
        print("True : " + evenlySpaced(4, 6, 2));
        print("False : " + evenlySpaced(4, 6, 3));

        // MakeChocolate:
        print();
        print(" MakeChocolate:");
        print("4 : " + makeChocolate(4, 1, 9));
        print("-1 : " + makeChocolate(4, 1, 10));
        print("2 : " + makeChocolate(4, 1, 7));
        print("6 : " + makeChocolate(6, 1, 11));
        print("6 : " + makeChocolate(1000, 1000000, 5000006));

    }
}
