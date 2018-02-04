package ex2_Strings.t11_Tag_Content_Extractor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            //Write your code here

            Pattern p = Pattern.compile("<(.+)>([^<>]+)</\\1>", Pattern.DOTALL); //<(\w+)>(.*?)</\\1>
            Matcher m = p.matcher(line);

            boolean checkFind = false;

            while (m.find()) {
                System.out.println(m.group(2));
                checkFind = true;
            }

            if (!checkFind) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}
