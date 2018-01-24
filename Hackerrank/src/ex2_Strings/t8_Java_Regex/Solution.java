package ex2_Strings.t8_Java_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
        String[] in = new String[]{"000.12.12.034",
                                    "121.234.12.12",
                                    "23.45.12.56",
                                    "00.12.123.123123.123",
                                    "122.23",
                                    "Hello.IP"};
        for (String IP : in) {
//            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
class MyRegex {
    public String pattern = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
}