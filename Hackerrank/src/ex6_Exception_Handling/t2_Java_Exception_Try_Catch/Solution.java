package ex6_Exception_Handling.t2_Java_Exception_Try_Catch;

import java.util.Scanner;

class MyCalculator {
    /*
    * Create the method long power(int, int) here.
    */
    public static long power(int num, int p) throws Exception {
        if (num == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        if (num < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        if (num == 0) {
            return 0;
        }
        if (p == 0) {
            return 1;
        }
        int res = num;
        for (int i = 1; i < p; i++) {
            res *= num;
        }
        return res;
    }
}

public class Solution {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int n = in .nextInt();
            int p = in .nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
