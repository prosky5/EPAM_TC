package ex12_Recursion1;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions11_20 {

    /*
    Given a string, compute recursively (no loops)
    the number of times lowercase "hi" appears in the string.

    countHi("xxhixx") → 1
    countHi("xhixhix") → 2
    countHi("hi") → 1
     */
    static int countHi(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("hi")) return 1 + countHi(str.substring(1));
        return countHi(str.substring(1));
    }

    /*
    Given a string, compute recursively (no loops)
    a new string where all the lowercase 'x' chars have been changed to 'y' chars.

    changeXY("codex") → "codey"
    changeXY("xxhixx") → "yyhiyy"
    changeXY("xhixhix") → "yhiyhiy"
     */
    static String changeXY(String str) {
        if (str.equals("")) return "";
        if (str.charAt(0) == 'x') return 'y' + changeXY(str.substring(1));
        return str.charAt(0) + changeXY(str.substring(1));
    }

    /*
    Given a string, compute recursively (no loops)
    a new string where all appearances of "pi" have been replaced by "3.14".

    changePi("xpix") → "x3.14x"
    changePi("pipi") → "3.143.14"
    changePi("pip") → "3.14p"
     */
    static String changePi(String str) {
        if (str.length() < 2) return str;
        if (str.substring(0, 2).equals("pi")) return 3.14 + changePi(str.substring(2));
        return str.charAt(0) + changePi(str.substring(1));
    }

    /*
    Given a string,
    compute recursively a new string where all the 'x' chars have been removed.

    noX("xaxb") → "ab"
    noX("abc") → "abc"
    noX("xx") → ""
     */
    static String noX(String str) {
        if (str.equals("")) return "";
        if (str.charAt(0) == 'x') return "" + noX(str.substring(1));
        return str.charAt(0) + noX(str.substring(1));
    }

    /*
    Given an array of ints,
    compute recursively if the array contains a 6.
    We'll use the convention of considering only
    the part of the array that begins at the given index.

    array6([1, 6, 4], 0) → true
    array6([1, 4], 0) → false
    array6([6], 0) → true
     */
    static boolean array6(int[] nums, int index) {
        if (index == nums.length) return false;
        if (nums[index] == 6) return true;
        return array6(nums, index+1);
    }

    /*
    Given an array of ints,
    compute recursively the number of times
    that the value 11 appears in the array.
    We'll use the convention of considering only the part of the array
    that begins at the given index.

    array11([1, 2, 11], 0) → 1
    array11([11, 11], 0) → 2
    array11([1, 2, 3, 4], 0) → 0
     */
    static int array11(int[] nums, int index) {
        if (index == nums.length) return 0;
        if (nums[index] == 11) return 1 + array11(nums, index+1);
        return array11(nums, index+1);
    }

    /*
    Given an array of ints,
    compute recursively if the array contains somewhere
    a value followed in the array by that value times 10.
    We'll use the convention of considering
    only the part of the array that begins at the given index.

    array220([1, 2, 20], 0) → true
    array220([3, 30], 0) → true
    array220([3], 0) → false
     */
    static boolean array220(int[] nums, int index) {
        if (index + 1 >= nums.length) return false;
        if (nums[index] * 10 == nums[index+1]) return true;
        return array220(nums, index+1);
    }

    /*
    Given a string,
    compute recursively a new string
    where all the adjacent chars are now separated by a "*".

    allStar("hello") → "h*e*l*l*o"
    allStar("abc") → "a*b*c"
    allStar("ab") → "a*b"
     */
    static String allStar(String str) {
        if (str.equals("") || str.substring(1).equals("")) return str;
        return str.charAt(0) + "*"  + allStar(str.substring(1));
    }

    /*
    Given a string,
    compute recursively a new string where identical chars
    that are adjacent in the original string are separated from each other by a "*".

    pairStar("hello") → "hel*lo"
    pairStar("xxyy") → "x*xy*y"
    pairStar("aaaa") → "a*a*a*a"
     */
    static String pairStar(String str) {
        if (str.equals("") || str.substring(1).equals("")) return str;
        if (str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*"  + pairStar(str.substring(1));
        return str.charAt(0) + pairStar(str.substring(1));
    }

    /*
    Given a string, compute recursively a new string
    where all the lowercase 'x' chars have been moved to the end of the string.

    endX("xxre") → "rexx"
    endX("xxhixx") → "hixxxx"
    endX("xhixhix") → "hihixxx"
     */
    static String endX(String str) {
        if (str.equals("")) return "";
        if (str.charAt(0) == 'x') return endX(str.substring(1)) + "x";
        return str.charAt(0) + endX(str.substring(1));
    }

    public static void main(String[] args) {

        // countHi:
        print();
        print(" countHi: \n" +
                "1 : " + countHi("xxhixx") + "\n" +
                "2 : " + countHi("xhixhix") + "\n" +
                "1 : " + countHi("hi") + "\n");

        // changeXY:
        print();
        print(" changeXY: \n" +
                "codey : " + changeXY("codex") + "\n" +
                "yyhiyy : " + changeXY("xxhixx") + "\n" +
                "yhiyhiy : " + changeXY("xhixhix") + "\n");

        // changePi:
        print();
        print(" changePi: \n" +
                "x3.14x : " + changePi("xpix") + "\n" +
                "3.143.14 : " + changePi("pipi") + "\n" +
                "3.14p : " + changePi("pip") + "\n");

        // noX:
        print();
        print(" noX: \n" +
                "ab : " + noX("xabx") + "\n" +
                "abc : " + noX("abc") + "\n" +
                " : " + noX("xx") + "\n");

        // array6:
        print();
        print(" array6: \n" +
                "True : " + array6(new int[]{1, 6, 4}, 0) + "\n" +
                "False : " + array6(new int[]{1, 4}, 0) + "\n" +
                "True : " + array6(new int[]{6}, 0) + "\n");

        // array11:
        print();
        print(" array11: \n" +
                "1 : " + array11(new int[]{1, 2, 11}, 0) + "\n" +
                "2 : " + array11(new int[]{11, 11}, 0) + "\n" +
                "0 : " + array11(new int[]{1, 2, 3, 4}, 0) + "\n");

        // array220:
        print();
        print(" array220: \n" +
                "True : " + array220(new int[]{1, 2, 20}, 0) + "\n" +
                "True : " + array220(new int[]{3, 30}, 0) + "\n" +
                "False : " + array220(new int[]{3}, 0) + "\n");

        // allStar:
        print();
        print(" allStar: \n" +
                "h*e*l*l*o : " + allStar("hello") + "\n" +
                "a*b*c : " + allStar("abc") + "\n" +
                "a*b : " + allStar("ab") + "\n");

        // pairStar:
        print();
        print(" pairStar: \n" +
                "hel*lo : " + pairStar("hello") + "\n" +
                "x*xy*y : " + pairStar("xxyy") + "\n" +
                "a*a*a*a : " + pairStar("aaaa") + "\n");

        // endX:
        print();
        print(" endX: \n" +
                "rexx : " + endX("xxre") + "\n" +
                "hixxxx : " + endX("xxhixx") + "\n" +
                "hihixxx : " + endX("xhixhix") + "\n");

    }

}
