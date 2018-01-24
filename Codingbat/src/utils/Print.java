package utils;

import java.io.*;

/**
 * Created by User on 029 29.11.17.
 */

public class Print {
    public static void print(Object obj) {
        System.out.println(obj);
    }
    public static void print() {
        System.out.println();
    }
    public static void printl(Object obj) {
        System.out.print(obj);
    }
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

    public static String arrPrint(Object[] array) {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (Object str : array) {
            out.append("\"").append(str).append("\"").append(", ");
        }
        out.append("]");
        return out.toString();
    }
}
