package ex2_Strings.t1_Java_Strings_Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        String out = "Yes";
        List list = new ArrayList();
        list.add(A);
        list.add(B);
        Collections.sort(list);
        if (list.get(0) == A) {
            out = "No";
        }

        System.out.println(A.length() + B.length());
        System.out.println(out);
        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1) +
                " " + B.substring(0,1).toUpperCase() + B.substring(1));
    }
}