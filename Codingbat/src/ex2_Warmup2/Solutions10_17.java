package ex2_Warmup2;

import static utils.Print.print;

public class Solutions10_17 {

    /*
    Given an array of ints,
    return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.

    array123([1, 1, 2, 3, 1]) → true
    array123([1, 1, 2, 4, 1]) → false
    array123([1, 1, 2, 1, 2, 3]) → true
     */
    static boolean array123(int[] nums) {
        int[] check = {1, 2, 3};
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == check[0] &&
                    nums[i+1] == check[1] &&
                    nums[i+2] == check[2]) {
                return true;
            }
        }
        return false;
    }

    /*
    Given 2 strings, a and b,
    return the number of the positions where they contain the same length 2 substring.
    So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa",
    and "az" substrings appear in the same place in both strings.

    stringMatch("xxcaazz", "xxbaaz") → 3
    stringMatch("abc", "abc") → 2
    stringMatch("abc", "axc") → 0
     */
    static int stringMatch(String a, String b) {
        if (b.length() > a.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int count = 0;
        for (int i = 0; i+1 < b.length(); i++) {
            if (b.substring(i, i+2).equals(a.substring(i, i+2))) {
                count++;
            }
        }
        return count;
    }

    /*
    Given a string,
    return a version where all the "x" have been removed.
    Except an "x" at the very start or end should not be removed.

    stringX("xxHxix") → "xHix"
    stringX("abxxxcd") → "abcd"
    stringX("xabxxxcdx") → "xabcdx"
     */
    static String stringX(String str) {
        StringBuilder res = new StringBuilder();
        if (str.length() > 1) {
            res.append(str.substring(0, 1));
            for (int i = 1; i < str.length() - 1; i++) {
                if (str.charAt(i) != 'x') {
                    res.append(str.charAt(i));
                }
            }
            return res.toString() + str.charAt(str.length() - 1);
        } else {
            return str;
        }
    }

    /*
    Given a string,
    return a string made of the chars at indexes 0,1, 4,5, 8,9 ...
    so "kittens" yields "kien".

    altPairs("kitten") → "kien"
    altPairs("Chocolate") → "Chole"
    altPairs("CodingHorror") → "Congrr"
     */
    static String altPairs(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0, k = 1; i < str.length(); i++) { // k - коэффициент выборки 3го числа
            if (k == 3) {
                i += 1;
                k = 1;
            } else {
                res.append(str.substring(i, i + 1));
                k++;
            }
        }
        return res.toString();
    }

    /*
    Suppose the string "yak" is unlucky.
    Given a string, return a version where all the "yak" are removed,
    but the "a" can be any char. The "yak" strings will not overlap.

    stringYak("yakpak") → "pak"
    stringYak("pakyak") → "pak"
    stringYak("yak123ya") → "123ya"
     */
    static String stringYak(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (i+2 < str.length() && str.substring(i, i+3).equals("yak")) {
                i += 2;
            } else {
                out += str.substring(i, i+1);
            }
        }
        return out;
    }

    /*
    Given an array of ints,
    return the number of times that two 6's are next to each other in the array.
    Also count instances where the second "6" is actually a 7.

    array667([6, 6, 2]) → 1
    array667([6, 6, 2, 6]) → 1
    array667([6, 7, 2, 6]) → 1
     */
    static int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i+1 < nums.length; i++) {
            if (nums[i] == 6 && nums[i+1] == 6 || nums[i+1] == 7) {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array of ints,
    we'll say that a triple is a value appearing 3 times in a row in the array.
    Return true if the array does not contain any triples.

    noTriples([1, 1, 2, 2, 1]) → true
    noTriples([1, 1, 2, 2, 2, 1]) → false
    noTriples([1, 1, 1, 2, 2, 2, 1]) → false
     */
    static boolean noTriples(int[] nums) {
        for (int i = 0; i+3 <= nums.length; i++) {
            if (nums[i] == nums[i+1] && nums[i] == nums[i+2]) {
                return false;
            }
        }
        return true;
    }

    /*
    Given an array of ints,
    return true if it contains a 2, 7, 1 pattern: a value,
    followed by the value plus 5, followed by the value minus 1.
    Additionally the 271 counts even if the "1" differs by 2 or less
    from the correct value.

    has271([1, 2, 7, 1]) → true
    has271([1, 2, 8, 1]) → false
    has271([2, 7, 1]) → true
     */
    static boolean has271(int[] nums) {
        int[] pattern;
        for (int i = 0; i+2 < nums.length; i++) {
            pattern = new int[]{nums[i], nums[i] + 5, nums[i] - 1};
            if (nums[i+1] == pattern[1] &&
                    nums[i+2] >= pattern[2]-2 && nums[i+2] <= pattern[2]+2) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // Array123:
        print();
        print(" Array123:");
        print("True : " + array123(new int[]{1, 1, 2, 3, 1}));
        print("False : " + array123(new int[]{1, 1, 2, 4, 1}));
        print("True : " + array123(new int[]{1, 1, 2, 1, 2, 3}));

        // StringMatch:
        print();
        print(" StringMatch:");
        print("3 : " + stringMatch("xxcaazz", "xxbaaz"));
        print("2 : " + stringMatch("abc", "abc"));
        print("0 : " + stringMatch("abc", "axc"));

        // StringX:
        print();
        print(" StringX:");
        print("xHix : " + stringX("xxHxix"));
        print("abcd : " + stringX("abxxxcd"));
        print("xabcdx : " + stringX("xabxxxcdx"));

        // AltPairs:
        print();
        print(" AltPairs:");
        print("kien : " + altPairs("kittens"));
        print("Chole : " + altPairs("Chocolate"));
        print("Congrr : " + altPairs("CodingHorror"));

        // StringYak:
        print();
        print(" StringYak:");
        print("pak : " + stringYak("yakpak"));
        print("pak : " + stringYak("pakyak"));
        print("123ya : " + stringYak("yak123ya"));
        print("HiHi : " + stringYak("HiyakHi"));

        // Array667:
        print();
        print(" Array667:");
        print("1 : " + array667(new int[]{6, 6, 2}));
        print("1 : " + array667(new int[]{6, 6, 2, 6}));
        print("1 : " + array667(new int[]{6, 7, 6, 2}));

        // NoTriples:
        print();
        print(" NoTriples:");
        print("True : " + noTriples(new int[]{1, 1, 2, 2, 1}));
        print("False : " + noTriples(new int[]{1, 1, 2, 2, 2, 1}));
        print("False : " + noTriples(new int[]{1, 1, 1, 2, 2, 2, 1}));
        print("False : " + noTriples(new int[]{1, 1, 1}));

        // Has271:
        print();
        print(" Has271:");
        print("True : " + has271(new int[]{1, 2, 7, 1}));
        print("False : " + has271(new int[]{1, 2, 8, 1}));
        print("True : " + has271(new int[]{2, 7, 1}));
    }
}
