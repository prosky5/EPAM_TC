package ex4_Data_Structures.t1_Java_1D_Array;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // Declare array a here
        int[] a = new int[n];

        for(int i = 0 ; i < n; i++){
            // Fill array a here
            a[i] = scan.nextInt();
        }

        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}