package ex1_Introduction.t13_Java_Currency_Formatter;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

//        double payment = 12324.134;

        // Write your code here
        Locale localeUS = Locale.US;
        Locale localeCH = Locale.CHINA;
        Locale localeFR = Locale.FRANCE;

        String us = NumberFormat.getCurrencyInstance(localeUS).format(payment);
        String china = NumberFormat.getCurrencyInstance(localeCH).format(payment);
        String france = NumberFormat.getCurrencyInstance(localeFR).format(payment);
        String india = "Rs." + us.substring(1, us.length());

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}