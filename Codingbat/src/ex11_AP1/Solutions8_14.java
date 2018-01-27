package ex11_AP1;

import java.util.Arrays;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions8_14 {

    /*
    Given a positive int n,
    return true if it contains a 1 digit.

    hasOne(10) → true
    hasOne(22) → false
    hasOne(220) → false
     */
    static boolean hasOne(int n) {
        while (n > 0) {
            if (n % 10 == 1) {
                return true;
            }
            n = n/10;
        }
        return false;
    }

    /*
    We'll say that a positive int divides itself
    if every digit in the number divides into the number evenly.
    So for example 128 divides itself since 1, 2, and 8 all divide into 128 evenly.
    We'll say that 0 does not divide into anything evenly,
    so no number with a 0 digit divides itself.

    dividesSelf(128) → true
    dividesSelf(12) → true
    dividesSelf(120) → false
     */
    static boolean dividesSelf(int n) {
        int num = n;
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            if (num % (n % 10) != 0) {
                return false;
            }
            n = n/10;
        }
        return true;
    }

    /*
    Given an array of positive ints, return a new array of length "count"
    containing the first even numbers from the original array.
    The original array will contain at least "count" even numbers.

    copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
    copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
    copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
     */
    static int[] copyEvens(int[] nums, int count) {
        int[] res = new int[count];
        for (int i = 0; i < nums.length && count > 0; i++) {
            if (nums[i] % 2 == 0 && count > 0) {
                res[res.length - count] = nums[i];
                count--;
            }
        }
        return res;
    }

    /*
    We'll say that a positive int n is "endy"
    if it is in the range 0..10 or 90..100 (inclusive).
    Given an array of positive ints,
    return a new array of length "count" containing the first endy numbers
    from the original array.
    Decompose out a separate isEndy(int n) method to test if a number is endy.
    The original array will contain at least "count" endy numbers.

    copyEndy([9, 11, 90, 22, 6], 2) → [9, 90]
    copyEndy([9, 11, 90, 22, 6], 3) → [9, 90, 6]
    copyEndy([12, 1, 1, 13, 0, 20], 2) → [1, 1]
     */
    static int[] copyEndy(int[] nums, int count) {
        int[] res = new int[count];
        for (int num : nums) {
            if (isEndy(num) && count > 0) {
                res[res.length - count] = num;
                count--;
            }
        }
        return res;
    }

    static boolean isEndy(int n) {
        return n >= 0 && n <= 10 || n >= 90 && n <= 100;
    }

    /*
    Given 2 arrays that are the same length containing strings,
    compare the 1st string in one array to the 1st string in the other array,
    the 2nd to the 2nd and so on.
    Count the number of times that the 2 strings are non-empty and start with the same char.
    The strings may be any length, including 0.

    matchUp(["aa", "bb", "cc"], ["aaa", "xx", "bb"]) → 1
    matchUp(["aa", "bb", "cc"], ["aaa", "b", "bb"]) → 2
    matchUp(["aa", "bb", "cc"], ["", "", "ccc"]) → 1
     */
    static int matchUp(String[] a, String[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].isEmpty() && !b[i].isEmpty()
                    && a[i].charAt(0) == b[i].charAt(0)) {
                count++;
            }
        }
        return count;
    }

    /*
    The "key" array is an array containing the correct answers to an exam,
    like {"a", "a", "b", "b"}.
    the "answers" array contains a student's answers,
    with "?" representing a question left blank.
    The two arrays are not empty and are the same length.
    Return the score for this array of answers, giving +4 for each correct answer,
    -1 for each incorrect answer, and +0 for each blank answer.

    scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
    scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
    scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
     */
    static int scoreUp(String[] key, String[] answers) {
        int res = 0;
        for (int i = 0; i < key.length; i++) {
            if (answers[i].equals("?")) {
                res += 0;
            } else if (answers[i].equals(key[i])) {
                res += 4;
            } else {
                res += -1;
            }
        }
        return res;
    }

    /*
    Given an array of strings,
    return a new array without the strings that are equal to the target string.
    One approach is to count the occurrences of the target string,
    make a new array of the correct length,
    and then copy over the correct strings.

    wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
    wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
    wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
     */
    static String[] wordsWithout(String[] words, String target) {
        int count = 0;
        for (String word : words) {
            if (!word.equals(target)) {
                count++;
            }
        }
        String[] res = new String[count];
        for (String word : words) {
            if (count > 0 && !word.equals(target)) {
                res[res.length - count] = word;
                count--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        // hasOne:
        print();
        print(" hasOne: \n" +
                "True : " + hasOne(10) + "\n" +
                "False : " + hasOne(22) + "\n" +
                "False : " + hasOne(220) + "\n");

        // dividesSelf:
        print();
        print(" dividesSelf: \n" +
                "True : " + dividesSelf(128) + "\n" +
                "True : " + dividesSelf(12) + "\n" +
                "False : " + dividesSelf(120) + "\n" +
                "False : " + dividesSelf(42) + "\n");

        // copyEvens:
        print();
        print(" copyEvens: \n" +
                "[2, 4] : " + Arrays.toString(copyEvens(new int[]{3, 2, 4, 5, 8}, 2)) + "\n" +
                "[2, 4, 8] : " + Arrays.toString(copyEvens(new int[]{3, 2, 4, 5, 8}, 3)) + "\n" +
                "[6, 2, 4] : " + Arrays.toString(copyEvens(new int[]{6, 1, 2, 4, 5, 8}, 3)) + "\n");

        // copyEndy:
        print();
        print(" copyEndy: \n" +
                "[9, 90] : " + Arrays.toString(copyEndy(new int[]{9, 11, 90, 22, 6}, 2)) + "\n" +
                "[9, 90, 6] : " + Arrays.toString(copyEndy(new int[]{9, 11, 90, 22, 6}, 3)) + "\n" +
                "[1, 1] : " + Arrays.toString(copyEndy(new int[]{12, 1, 1, 13, 0, 20, 2}, 2)) + "\n");

        // matchUp:
        print();
        print(" matchUp: \n" +
                "1 : " + matchUp(new String[]{"aa", "bb", "cc"}, new String[]{"aaa", "xx", "bb"}) + "\n" +
                "2 : " + matchUp(new String[]{"aa", "bb", "cc"}, new String[]{"aaa", "b", "bb"}) + "\n" +
                "1 : " + matchUp(new String[]{"aa", "bb", "cc"}, new String[]{"", "", "ccc"}) + "\n");

        // scoreUp:
        print();
        print(" scoreUp: \n" +
                "6 : " + scoreUp(new String[]{"a", "a", "b", "b"}, new String[]{"a", "c", "b", "c"}) + "\n" +
                "11 : " + scoreUp(new String[]{"a", "a", "b", "b"}, new String[]{"a", "a", "b", "c"}) + "\n" +
                "16 : " + scoreUp(new String[]{"a", "a", "b", "b"}, new String[]{"a", "a", "b", "b"}) + "\n");

        // wordsWithout:
        print();
        print(" wordsWithout: \n" +
                "[\"b\", \"c\"] : " + arrPrint(wordsWithout(new String[]{"a", "b", "c", "a"}, "a")) + "\n" +
                "[\"a\", \"c\", \"a\"] : " + arrPrint(wordsWithout(new String[]{"a", "b", "c", "a"}, "b")) + "\n" +
                "[\"a\", \"b\", \"a\"] : " + arrPrint(wordsWithout(new String[]{"a", "b", "c", "a"}, "c")) + "\n");

    }



}
