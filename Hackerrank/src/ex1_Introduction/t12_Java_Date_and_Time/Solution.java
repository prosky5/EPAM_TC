package ex1_Introduction.t12_Java_Date_and_Time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static String getDay(String day, String month, String year) {
        /*
        * Write your code here.
        */
//        // First try
//        GregorianCalendar myCal = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//        return new SimpleDateFormat("EEEE").format(myCal.getTime()).toUpperCase();

//        // Second-third try
//        Calendar calendar = Calendar.getInstance();
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//        calendar.setLenient(false);
//        calendar.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
//        return new SimpleDateFormat("EEEE").format(calendar.getTime()).toUpperCase();
//        return new SimpleDateFormat("EEEE").format(calendar.get(Calendar.DAY_OF_WEEK)).toUpperCase();

        // Finally try (success!) JDK 8+
        LocalDate ld = LocalDate.parse(year+"-"+month+"-"+ day);
        return ld.getDayOfWeek().getDisplayName( TextStyle.FULL, Locale.US ).toUpperCase();

        // Success with JDK 7 (JDK-6. Maybe...)

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        System.out.println(getDay(day, month, year));
    }
}