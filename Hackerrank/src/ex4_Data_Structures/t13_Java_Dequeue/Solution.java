package ex4_Data_Structures.t13_Java_Dequeue;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

//        long start = new Date().getTime();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);

            if (deque.size() == m) {
                max = set.size() > max ? set.size() : max;
                int first = deque.removeFirst();
                if (!deque.contains(first)) set.remove(first);
            }
        }
        System.out.println(max);
//        System.out.println(new Date().getTime() - start);
    }
}
