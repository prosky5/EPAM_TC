package ex12_Recursion1;

import static utils.Print.*;

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
        return 0;
    }



    public static void main(String[] args) {

        // factorial:
        print();
        print(" factorial: \n" +
                "1 : " + factorial(1) + "\n" +
                "2 : " + factorial(2) + "\n" +
                "6 : " + factorial(3) + "\n" +
                "");

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
                "21 : " + fibonacci(8));

        // bunnyEars2:
        print();
        print(" bunnyEars2: \n" +
                "0 : " + bunnyEars2(0) + "\n" +
                "2 : " + bunnyEars2(1) + "\n" +
                "5 : " + bunnyEars2(2) + "\n");

//        // triangle:
//        print();
//        print(" triangle: \n" +
//                "1 : " + triangle(1) + "\n" +
//                "2 : " + triangle(2) + "\n" +
//                "6 : " + triangle(6) + "\n");
//
//        // sumDigits:
//        print();
//        print(" sumDigits: \n" +
//                "1 : " + sumDigits(1) + "\n" +
//                "2 : " + sumDigits(2) + "\n" +
//                "6 : " + sumDigits(6) + "\n");
//
//        // count7:
//        print();
//        print(" count7: \n" +
//                "1 : " + count7(1) + "\n" +
//                "2 : " + count7(2) + "\n" +
//                "6 : " + count7(6) + "\n");
//
//        // count8:
//        print();
//        print(" count8: \n" +
//                "1 : " + count8(1) + "\n" +
//                "2 : " + count8(2) + "\n" +
//                "6 : " + count8(6) + "\n");
//
//        // powerN:
//        print();
//        print(" powerN: \n" +
//                "1 : " + powerN(1) + "\n" +
//                "2 : " + powerN(2) + "\n" +
//                "6 : " + powerN(6) + "\n");
//
//        // countX:
//        print();
//        print(" countX: \n" +
//                "1 : " + countX(1) + "\n" +
//                "2 : " + countX(2) + "\n" +
//                "6 : " + countX(6) + "\n");

    }

}
