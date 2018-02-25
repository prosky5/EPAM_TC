package ex4_Data_Structures.t4_Java_Arraylist;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> line = new ArrayList<Integer>();
            int d = sc.nextInt();
            for (int j = 0; j < d; j++) {
                line.add(sc.nextInt());
            }
            lists.add(line);
        }

        Queries(sc, lists);

        sc.close();
    }

    private static void Queries(Scanner sc, List<List<Integer>> list) {
        // Queries:
        int q = sc.nextInt();
        int x;
        int y;
        while (q > 0) {
            x = sc.nextInt() - 1;   // lines and columns starts from 0,
            y = sc.nextInt() - 1;   // entering starts from 1.
            if (y <= list.get(x).size() - 1) {
                System.out.println(list.get(x).get(y));
            } else {
                System.out.println("ERROR!");
            }
            q--;
        }
    }


//    public class Solution {
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//
//            int[][] list = MyArrayList(sc, n);
//            Queries(sc, list);
//
//            sc.close();
//        }
//
//        private static int[][] MyArrayList(Scanner sc, int n) {
//            // ArrayList
//            int[][] list = new int[n][];
//
//            for (int i = 0; i < n; i++) {
//                list[i] = new int[sc.nextInt()];
//                for (int j = 0; j < list[i].length; j++) {
//                    list[i][j] = sc.nextInt();
//                }
//            }
//            return list;
//        }
//
//        private static void Queries(Scanner sc, int[][] list) {
//            int n;// Queries:
//            n = sc.nextInt();
//            int first;
//            int second;
//            while (n > 0) {
//                first = sc.nextInt() - 1;   // lines and columns starts from 0,
//                second = sc.nextInt() - 1;  // entering starts from 1.
//                try {
//                    System.out.println(list[first][second]);
//                } catch (ArrayIndexOutOfBoundsException ex) {
//                    System.out.println("ERROR!");
//                } finally {
//                    n--;
//                }
//            }
//        }
//    }
}