package ex2_Strings.t6_Java_String_Tokens;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim();
        if (s.length() != 0) {
            String[] arrS = s.split("[\\s!,?._'@]+");
            System.out.println(arrS.length);
            for (String out : arrS) {
                System.out.println(out);
            }
            scan.close();
        } else {
            System.out.println(0);
        }
    }
}
