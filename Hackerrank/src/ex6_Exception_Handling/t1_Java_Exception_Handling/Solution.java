package ex6_Exception_Handling.t1_Java_Exception_Handling;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (y == 0) {
                throw new ArithmeticException(": / by zero");
            }

            System.out.println(x / y);

        } catch (InputMismatchException | ArithmeticException e) {
            System.out.println(e.getClass().getName() + (e.getMessage() == null
                    || e.getMessage().startsWith("For input") ? "" : e.getMessage()));
        }
    }
}