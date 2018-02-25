package ex4_Data_Structures.t7_Java_Map;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class SolutionFail2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[][] map = new String[n][2];
        String[] search = new String[n];

        for (int i = 0; i < n; i++) {
            map[i][0] = sc.nextLine();
            map[i][1] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            search[i] = sc.nextLine();
        }

        for (int i = 0, k = 0; k < n; i++) {
            if (i >= map.length) {
                System.out.println("Not found");
                i = 0;
                k++;
                continue;
            }
            if (search[k].equals(map[i][0])) {
                System.out.println(map[i][0] + "=" + map[i][1]);
                i = 0;
                k++;
            }
        }

        sc.close();
    }

}