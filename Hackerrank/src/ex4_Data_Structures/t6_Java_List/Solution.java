package ex4_Data_Structures.t6_Java_List;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        while (n-- > 0) {
            list.add(sc.nextInt());
        }

        int q = sc.nextInt();
        while (q > 0) {
            switch (sc.nextLine()) {
                case "Insert":
                    list.add(sc.nextInt(), sc.nextInt());
                    q--;
                    break;
                case "Delete":
                    list.remove(sc.nextInt());
                    q--;
                    break;
            }
        }

        for (Integer out : list) {
            System.out.print(out + " ");
        }

        sc.close();
    }
}
