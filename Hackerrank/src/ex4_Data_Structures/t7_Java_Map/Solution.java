package ex4_Data_Structures.t7_Java_Map;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            map.put(sc.nextLine(), sc.nextInt());
            sc.nextLine();
        }

        while (n-- > 0) {
            String searchKey = sc.nextLine();
            if (map.containsKey(searchKey)) {
                System.out.println(searchKey + "=" + map.get(searchKey));
            } else {
                System.out.println("Not found");
            }
        }

        sc.close();
    }
}
