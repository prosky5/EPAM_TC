package ex4_Data_Structures.t3_Java_Subarray;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int countNeg = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        countNeg = getCountNeg(arr, countNeg);
        System.out.println(countNeg);
    }

    private static int getCountNeg(int[] arr, int countNeg) {
        int sum;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum < 0) {
                    countNeg++;
                }
            }
        }
        return countNeg;
    }
}