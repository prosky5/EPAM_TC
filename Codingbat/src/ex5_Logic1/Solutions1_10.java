package ex5_Logic1;

import static utils.Print.*;

public class Solutions1_10 {

    /*
    When squirrels get together for a party, they like to have cigars.
    A squirrel party is successful when the number of cigars is between 40 and 60,
    inclusive. Unless it is the weekend,
    in which case there is no upper bound on the number of cigars.
    Return true if the party with the given values is successful, or false otherwise.

    cigarParty(30, false) → false
    cigarParty(50, false) → true
    cigarParty(70, true) → true
     */
    static boolean cigarParty(int cigars, boolean isWeekend) {
        return (cigars >= 40 && (isWeekend || cigars <= 60));
    }

    /*
    You and your date are trying to get a table at a restaurant.
    The parameter "you" is the stylishness of your clothes,
    in the range 0..10, and "date" is the stylishness of your date's clothes.
    The result getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes.
    If either of you is very stylish, 8 or more, then the result is 2 (yes).
    With the exception that if either of you has style of 2 or less, then the result is 0 (no).
    Otherwise the result is 1 (maybe).

    dateFashion(5, 10) → 2
    dateFashion(5, 2) → 0
    dateFashion(5, 5) → 1
     */
    static int dateFashion(int you, int date) {
        if (you <= 2 || date <= 2) {
            return 0;
        } else if (you >= 8 || date >= 8) {
            return 2;
        } else {
            return 1;
        }
    }

    /*
    The squirrels in Palo Alto spend most of the day playing.
    In particular, they play if the temperature is between 60 and 90 (inclusive).
    Unless it is summer, then the upper limit is 100 instead of 90.
    Given an int temperature and a boolean isSummer,
    return true if the squirrels play and false otherwise.

    squirrelPlay(70, false) → true
    squirrelPlay(95, false) → false
    squirrelPlay(95, true) → true
     */
    static boolean squirrelPlay(int temp, boolean isSummer) {
        return temp >= 60 && (temp <=90 || isSummer && temp <= 100);
    }

    /*
    You are driving a little too fast, and a police officer stops you.
    Write code to compute the result, encoded as an int value:
    0=no ticket, 1=small ticket, 2=big ticket.
    If speed is 60 or less, the result is 0.
    If speed is between 61 and 80 inclusive, the result is 1.
    If speed is 81 or more, the result is 2.
    Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.

    caughtSpeeding(60, false) → 0
    caughtSpeeding(65, false) → 1
    caughtSpeeding(65, true) → 0
     */
    static int caughtSpeeding(int speed, boolean isBirthday) {
        int[] limit = isBirthday ? new int[]{65, 85} : new int[]{60, 80};

        if (speed <= limit[0]) {
            return 0;
        }
        if (speed > limit[0] && speed <= limit[1]) {
            return 1;
        }
        return 2;
    }

    /*
    Given 2 ints, a and b, return their sum.
    However, sums in the range 10..19 inclusive, are forbidden,
    so in that case just return 20.

    sortaSum(3, 4) → 7
    sortaSum(9, 4) → 20
    sortaSum(10, 11) → 21
     */
    static int sortaSum(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum < 20) {
            return 20;
        } else {
            return sum;
        }
    }

    /*
    Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat,
    and a boolean indicating if we are on vacation,
    return a string of the form "7:00" indicating when the alarm clock should ring.
    Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00".
    Unless we are on vacation -- then on weekdays it should be "10:00"
    and weekends it should be "off".

    alarmClock(1, false) → "7:00"
    alarmClock(5, false) → "7:00"
    alarmClock(0, false) → "10:00"
     */
    static String alarmClock(int day, boolean vacation) {
        if (day > 0 && day < 6) {
            return vacation ? "10:00" : "7:00";
        } else {
            return vacation ? "off" : "10:00";
        }
    }

    /*
    The number 6 is a truly great number.
    Given two int values, a and b, return true if either one is 6.
    Or if their sum or difference is 6.
    Note: the function Math.abs(num) computes the absolute value of a number.

    love6(6, 4) → true
    love6(4, 5) → false
    love6(1, 5) → true
     */
    static boolean love6(int a, int b) {
        return a == 6 || b == 6 || a + b == 6 || a - b == 6 || b - a == 6;
    }

    /*
    Given a number n, return true if n is in the range 1..10, inclusive.
    Unless outsideMode is true,
    in which case return true if the number is less or equal to 1,
    or greater or equal to 10.

    in1To10(5, false) → true
    in1To10(11, false) → false
    in1To10(11, true) → true
     */
    static boolean in1To10(int n, boolean outsideMode) {
        return outsideMode ? n <= 1 || n >= 10 : n >= 1 && n <= 10;
    }

    /*
    We'll say a number is special if it is a multiple of 11
    or if it is one more than a multiple of 11.
    Return true if the given non-negative number is special.
    Use the % "mod" operator

    specialEleven(22) → true
    specialEleven(23) → true
    specialEleven(24) → false
     */
    static boolean specialEleven(int n) {
        return (n-1) % 11 == 0 || n % 11 == 0;
    }

    /*
    Return true if the given non-negative number is 1 or 2 more than a multiple of 20.

    more20(20) → false
    more20(21) → true
    more20(22) → true
     */
    static boolean more20(int n) {
        return (n-1) % 20 == 0 || (n-2) % 20 == 0;
    }

    public static void main(String[] args) {

        // CigarParty:
        print();
        print(" CigarParty:");
        print("False : " + cigarParty(30, false));
        print("True : " + cigarParty(50, false));
        print("True : " + cigarParty(70, true));

        // DateFashion:
        print();
        print(" DateFashion:");
        print("2 : " + dateFashion(5, 10));
        print("0 : " + dateFashion(5, 2));
        print("1 : " + dateFashion(5, 5));

        // SquirrelPlay:
        print();
        print(" SquirrelPlay:");
        print("True : " + squirrelPlay(70, false));
        print("False : " + squirrelPlay(95, false));
        print("True : " + squirrelPlay(95, true));

        // CaughtSpeeding:
        print();
        print(" CaughtSpeeding:");
        print("0 : " + caughtSpeeding(60, false));
        print("1 : " + caughtSpeeding(65, false));
        print("0 : " + caughtSpeeding(65, true));

        // SortaSum:
        print();
        print(" SortaSum:");
        print("7 : " + sortaSum(3, 4));
        print("20 : " + sortaSum(9, 4));
        print("21 : " + sortaSum(10, 11));

        // AlarmClock:
        print();
        print(" AlarmClock:");
        print("7:00 : " + alarmClock(1, false));
        print("7:00 : " + alarmClock(5, false));
        print("10:00 : " + alarmClock(0, false));
        print("off : " + alarmClock(0, true));
        print("off : " + alarmClock(6, true));

        // Love6:
        print();
        print(" Love6:");
        print("True : " + love6(6, 4));
        print("False : " + love6(4, 5));
        print("True : " + love6(1, 5));
        print("True : " + love6(1, 7));

        // in1To10:
        print();
        print(" in1To10:");
        print("True : " + in1To10(5, false));
        print("False : " + in1To10(11, false));
        print("True : " + in1To10(11, true));
        print("True : " + in1To10(10, true));
        print("True : " + in1To10(1, true));

        // SpecialEleven:
        print();
        print(" SpecialEleven:");
        print("True : " + specialEleven(22));
        print("True : " + specialEleven(23));
        print("False : " + specialEleven(24));
        print("True : " + specialEleven(66));
        print("True : " + specialEleven(67));
        print("False : " + specialEleven(65));

        // More20:
        print();
        print( "More20:");
        print("False : " + more20(20));
        print("True : " + more20(21));
        print("True : " + more20(22));

    }
}
