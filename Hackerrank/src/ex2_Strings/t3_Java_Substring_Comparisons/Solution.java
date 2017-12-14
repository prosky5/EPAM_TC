package ex2_Strings.t3_Java_Substring_Comparisons;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        String[] sArr = new String[s.length()-k+1];
        for (int i = 0; i+k <= s.length(); i++) {
            sArr[i] = s.substring(i, i + k);
        }
        Arrays.sort(sArr);
        smallest = sArr[0];
        largest = sArr[sArr.length-1];

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
