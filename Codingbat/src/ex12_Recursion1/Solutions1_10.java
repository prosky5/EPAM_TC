package ex12_Recursion1;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions1_10 {

    /*
    Given n of 1 or more,
    return the factorial of n, which is n * (n-1) * (n-2) ... 1.
    Compute the result recursively (without loops).

    factorial(1) → 1
    factorial(2) → 2
    factorial(3) → 6
     */
    static int factorial(int n) {
        if (n > 1) {
            return n * factorial(n - 1);
        }
        else return 1;
    }

    /*
    We have a number of bunnies
    and each bunny has two big floppy ears.
    We want to compute the total number of ears across all the bunnies recursively
    (without loops or multiplication).

    bunnyEars(0) → 0
    bunnyEars(1) → 2
    bunnyEars(2) → 4
     */
    static int bunnyEars(int bunnies) {
        if (bunnies > 0) {
            return 2 + bunnyEars(bunnies - 1);
        }
        return 0;
    }

    /*
    The fibonacci sequence is a famous bit of mathematics,
    and it happens to have a recursive definition.
    The first two values in the sequence are 0 and 1
    (essentially 2 base cases).
    Each subsequent value is the sum of the previous two values,
    so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
    Define a recursive fibonacci(n) method that returns the nth fibonacci number,
    with n=0 representing the start of the sequence.

    fibonacci(0) → 0
    fibonacci(1) → 1
    fibonacci(2) → 1
     */
    static int fibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        return fibonacci(n-2) + fibonacci( n-1);
    }

    /*
    We have bunnies standing in a line,
    numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
    The even bunnies (2, 4, ..) we'll say have 3 ears,
    because they each have a raised foot.
    Recursively return the number of "ears" in the bunny line 1, 2, ... n
    (without loops or multiplication).

    bunnyEars2(0) → 0
    bunnyEars2(1) → 2
    bunnyEars2(2) → 5
     */
    static int bunnyEars2(int bunnies) {
        if (bunnies > 0) {
            if (bunnies % 2 != 0) {
                return 2 + bunnyEars2(bunnies - 1);
            } else {
                return 3 + bunnyEars2(bunnies - 1);
            }
        }
        return 0;
    }

    /*
    We have triangle made of blocks.
    The topmost row has 1 block, the next row down has 2 blocks,
    the next row has 3 blocks, and so on.
    Compute recursively (no loops or multiplication)
    the total number of blocks in such a triangle with the given number of rows.

    triangle(0) → 0
    triangle(1) → 1
    triangle(2) → 3
     */
    static int triangle(int rows) {
        if (rows <= 0) {
            return 0;
        } else {
            return rows + triangle(rows-1);
        }
    }

    /*
    Given a non-negative int n,
    return the sum of its digits recursively (no loops).

    sumDigits(126) → 9
    sumDigits(49) → 13
    sumDigits(12) → 3
     */
    static int sumDigits(int n) {
        if (n > 9) {
            return (n % 10) + sumDigits(n/10);
        } else {
            return n % 10;
        }
    }

    /*
    Given a non-negative int n,
    return the count of the occurrences of 7 as a digit,
    so for example 717 yields 2. (no loops).

    count7(717) → 2
    count7(7) → 1
    count7(123) → 0
     */
    static int count7(int n) {
        if (n > 0) {
            if (n % 10 == 7) {
                return 1 + count7(n / 10);
            } else {
                return count7(n / 10);
            }
        }
        return 0;
    }

    /*
    Given a non-negative int n, compute recursively (no loops)
    the count of the occurrences of 8 as a digit,
    except that an 8 with another 8 immediately to its left counts double,
    so 8818 yields 4.

    count8(8) → 1
    count8(818) → 2
    count8(8818) → 4
     */
    static int count8(int n) {
        if (n > 0) {
            if (n/10 % 10 == 8 && n % 10 == 8) {
                return 2 + count8(n / 10);
            } else if (n % 10 == 8) {
                return 1 + count8(n / 10);
            } else {
                return count8(n / 10);
            }
        }
        return 0;
    }

    /*
    Given base and n that are both 1 or more,
    compute recursively (no loops) the value of base to the n power,
    so powerN(3, 2) is 9 (3 squared).

    powerN(3, 1) → 3
    powerN(3, 2) → 9
    powerN(3, 3) → 27
     */
    static int powerN(int base, int n) {
        if (n > 1) {
            return base * powerN(base, n-1);
        }
        return base;
    }

    /*
    Given a string, compute recursively (no loops)
    the number of lowercase 'x' chars in the string.

    countX("xxhixx") → 4
    countX("xhixhix") → 3
    countX("hi") → 0
     */
    static int countX(String str) {
        if (str.equals("")) return 0;
        if (str.charAt(0) == 'x') return 1 + countX(str.substring(1));
        return countX(str.substring(1));
    }


    public static void main(String[] args) {

        // factorial:
        print();
        print(" factorial: \n" +
                "1 : " + factorial(1) + "\n" +
                "2 : " + factorial(2) + "\n" +
                "6 : " + factorial(3) + "\n");

        // bunnyEars:
        print();
        print(" bunnyEars: \n" +
                "0 : " + bunnyEars(0) + "\n" +
                "2 : " + bunnyEars(1) + "\n" +
                "4 : " + bunnyEars(2) + "\n");

        // fibonacci:
        print();
        print(" fibonacci: \n" +
                "0 : " + fibonacci(0) + "\n" +
                "1 : " + fibonacci(1) + "\n" +
                "1 : " + fibonacci(2) + "\n" +
                "21 : " + fibonacci(8) + "\n");

        // bunnyEars2:
        print();
        print(" bunnyEars2: \n" +
                "0 : " + bunnyEars2(0) + "\n" +
                "2 : " + bunnyEars2(1) + "\n" +
                "5 : " + bunnyEars2(2) + "\n");

        // triangle:
        print();
        print(" triangle: \n" +
                "1 : " + triangle(1) + "\n" +
                "2 : " + triangle(2) + "\n" +
                "6 : " + triangle(3) + "\n");

        // sumDigits:
        print();
        print(" sumDigits: \n" +
                "9 : " + sumDigits(126) + "\n" +
                "13 : " + sumDigits(49) + "\n" +
                "3 : " + sumDigits(12) + "\n");

        // count7:
        print();
        print(" count7: \n" +
                "2 : " + count7(717) + "\n" +
                "1 : " + count7(7) + "\n" +
                "0 : " + count7(123) + "\n");

        // count8:
        print();
        print(" count8: \n" +
                "1 : " + count8(8) + "\n" +
                "2 : " + count8(818) + "\n" +
                "4 : " + count8(8818) + "\n" +
                "9 : " + count8(88888) + "\n");

        // powerN:
        print();
        print(" powerN: \n" +
                "3 : " + powerN(3, 1) + "\n" +
                "9 : " + powerN(3, 2) + "\n" +
                "27 : " + powerN(3, 3) + "\n");

        // countX:
        print();
        print(" countX: \n" +
                "4 : " + countX("xxhixx") + "\n" +
                "3 : " + countX("xhixhix") + "\n" +
                "0 : " + countX("hi") + "\n");

    }

}
