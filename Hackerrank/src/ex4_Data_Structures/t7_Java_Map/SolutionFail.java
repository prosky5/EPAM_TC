package ex4_Data_Structures.t7_Java_Map;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class SolutionFail {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        myArrayMap(in, n);
//        myListMap(in, n);
    }

    private static void myListMap(Scanner in, int n) {
        List<Keyval> list = new ArrayList<>();
        int i = n;
        while (i-- > 0) {
            list.add(new Keyval(in.nextLine(), in.nextInt()));
            in.nextLine();
        }

        while (n-- > 0) {
            i = 0;
            String searchKey = in.nextLine();
            long time = new Date().getTime();
            while (i < list.size()) {
                if (list.get(i).getKey().equals(searchKey)) {
                    System.out.println(list.get(i).getKey() + "=" + list.get(i).getVal());
                }
                i++;
            }
            if (i >= list.size()) {
                System.out.println("Not found");
            }
            System.out.println("ArrayMap time : " + (new Date().getTime() - time));
        }
    }

    private static void myArrayMap(Scanner in, int n) {

        String[] names = new String[n];
        int[] phones = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = in.nextLine();
            phones[i] = in.nextInt();
            in.nextLine();
        }

        while(n-- > 0) {
            String key = in.nextLine();
            long time = new Date().getTime();
            int i = 0;
            for (; i < names.length; i++) {
                if (names[i].equals(key)) {
                    System.out.println(names[i] + "=" + phones[i]);
                }
            }
            if (i >= names.length) {
                System.out.println("Not found");
            }
            System.out.println("ArrayMap time : " + (new Date().getTime() - time));
        }
    }
}

class Keyval {
    private String key;
    private int val;

    public Keyval(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }

}