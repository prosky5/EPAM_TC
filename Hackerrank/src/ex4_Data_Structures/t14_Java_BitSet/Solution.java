package ex4_Data_Structures.t14_Java_BitSet;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        BitSet[] bitSets = new BitSet[]{ new BitSet(m), new BitSet(m) };

        while (n-- > 0) {

            String cmd = sc.next();
            if (cmd.equals("FLIP") || cmd.equals("SET")) {
                FLIPSET.valueOf(cmd).operate(bitSets[sc.nextInt()-1], sc.nextInt());
            } else {
                ANDORXOR.valueOf(cmd).operate(bitSets[sc.nextInt()-1], bitSets[sc.nextInt()-1]);
            }

            System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());

        }

        sc.close();
    }
}

enum FLIPSET {
    FLIP {
        @Override
        public void operate(BitSet set, int index) {
            set.flip(index);
        }
    },
    SET {
        @Override
        public void operate(BitSet set, int index) {
            set.set(index);
        }
    };

    public abstract void operate(BitSet x1, int x2);
}

enum ANDORXOR {
    AND {
        @Override
        public void operate(BitSet set1, BitSet set2) {
            set1.and(set2);
        }
    },
    OR {
        @Override
        public void operate(BitSet set1, BitSet set2) {
            set1.or(set2);
        }
    },
    XOR{
        @Override
        public void operate(BitSet set1, BitSet set2) {
            set1.xor(set2);
        }
    };

    public abstract void operate(BitSet x1, BitSet x2);
}