package ex11_AP1;

import java.util.ArrayList;
import java.util.List;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions1_7 {

    /*
    Given an array of scores,
    return true if each score is equal or greater than the one before.
    The array will be length 2 or more.

    scoresIncreasing([1, 3, 4]) → true
    scoresIncreasing([1, 3, 2]) → false
    scoresIncreasing([1, 1, 4]) → true
     */
    static boolean scoresIncreasing(int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < scores[i-1]) {
                return false;
            }
        }
        return true;
    }

    /*
    Given an array of scores,
    return true if there are scores of 100 next to each other in the array.
    The array length will be at least 2.

    scores100([1, 100, 100]) → true
    scores100([1, 100, 99, 100]) → false
    scores100([100, 1, 100, 100]) → true
     */
    static boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length-1; i++) {
            if (scores[i] == 100 && scores[i+1] == 100) {
                return true;
            }
        }
        return false;
    }

    /*
    Given an array of scores sorted in increasing order,
    return true if the array contains 3 adjacent scores
    that differ from each other by at most 2,
    such as with {3, 4, 5} or {3, 5, 5}.

    scoresClump([3, 4, 5]) → true
    scoresClump([3, 4, 6]) → false
    scoresClump([1, 3, 5, 5]) → true
     */
    static boolean scoresClump(int[] scores) {
        for (int i = 1; i < scores.length-1; i++) {
            if (scores[i+1] - scores[i-1] <= 2) {
                return true;
            }
        }
        return false;
    }

    /*
    Given an array of scores,
    compute the int average of the first half and the second half,
    and return whichever is larger.
    We'll say that the second half begins at index length/2.
    The array length will be at least 2.
    To practice decomposition, write a separate helper method
    int average(int[] scores, int start, int end) {
    which computes the average of the elements between indexes start..end.
    Call your helper method twice to implement scoresAverage().
    Write your helper method after your scoresAverage() method
    in the JavaBat text area.
    Normally you would compute averages with doubles,
    but here we use ints so the expected results are exact.

    scoresAverage([2, 2, 4, 4]) → 4
    scoresAverage([4, 4, 4, 2, 2, 2]) → 4
    scoresAverage([3, 4, 5, 1, 2, 3]) → 4
     */
    static int scoresAverage(int[] scores) {
        int firstHalf = average(scores, 0, scores.length/2);
        int secondHalf = average(scores, scores.length/2, scores.length);
        return firstHalf > secondHalf ? firstHalf : secondHalf;
    }

    static int average(int[] scores, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res += scores[i];
        }
        return res / (end - start);
    }

    /*
    Given an array of strings,
    return the count of the number of strings with the given length.

    wordsCount(["a", "bb", "b", "ccc"], 1) → 2
    wordsCount(["a", "bb", "b", "ccc"], 3) → 1
    wordsCount(["a", "bb", "b", "ccc"], 4) → 0
     */
    static int wordsCount(String[] words, int len) {
        int count = 0;
        for (String word : words) {
            if (word.length() == len) {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array of strings,
    return a new array containing the first N strings.
    N will be in the range 1..length.

    wordsFront(["a", "b", "c", "d"], 1) → ["a"]
    wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
    wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
     */
    static String[] wordsFront(String[] words, int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = words[i];
        }
        return res;
    }

    /*
    Given an array of strings,
    return a new List (e.g. an ArrayList) where all the strings of the given length are omitted.
    See wordsWithout() below which is more difficult because it uses arrays.

    wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
    wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
    wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
     */
    static List wordsWithoutList(String[] words, int len) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.length() != len) {
                list.add(word);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // scoresIncreasing:
        print();
        print(" scoresIncreasing: \n" +
                "True : " + scoresIncreasing(new int[]{1, 3, 4}) + "\n" +
                "False : " + scoresIncreasing(new int[]{1, 3, 2}) + "\n" +
                "True : " + scoresIncreasing(new int[]{1, 1, 4}) + "\n");

        // scores100:
        print();
        print(" scores100: \n" +
                "True : " + scores100(new int[]{1, 100, 100}) + "\n" +
                "False : " + scores100(new int[]{1, 100, 99, 100}) + "\n" +
                "True : " + scores100(new int[]{100, 1, 100, 100}) + "\n");

        // scoresClump:
        print();
        print(" scoresClump: \n" +
                "True : " + scoresClump(new int[]{3, 4, 5}) + "\n" +
                "False : " + scoresClump(new int[]{3, 4, 6}) + "\n" +
                "True : " + scoresClump(new int[]{1, 3, 5, 5}) + "\n");

        // scoresAverage:
        print();
        print(" scoresAverage: \n" +
                "4 : " + scoresAverage(new int[]{2, 2, 4, 4}) + "\n" +
                "4 : " + scoresAverage(new int[]{4, 4, 4, 2, 2, 2}) + "\n" +
                "4 : " + scoresAverage(new int[]{3, 4, 5, 1, 2, 3}) + "\n");

        // wordsCount:
        print();
        print(" wordsCount: \n" +
                "2 : " + wordsCount(new String[]{"a", "bb", "b", "ccc"}, 1) + "\n" +
                "1 : " + wordsCount(new String[]{"a", "bb", "b", "ccc"}, 3) + "\n" +
                "0 : " + wordsCount(new String[]{"a", "bb", "b", "ccc"}, 4) + "\n");

        // wordsFront:
        print();
        print(" wordsFront: \n" +
                "[\"a\"] : " + arrPrint(wordsFront(new String[]{"a", "b", "c", "d"}, 1)) + "\n" +
                "[\"a\", \"b\"] : " + arrPrint(wordsFront(new String[]{"a", "b", "c", "d"}, 2)) + "\n" +
                "[\"a\", \"b\", \"c\"] : " + arrPrint(wordsFront(new String[]{"a", "b", "c", "d"}, 3)) + "\n");

        // wordsWithoutList:
        print();
        print(" wordsWithoutList: \n" +
                "[bb, ccc] : " + wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 1) + "\n" +
                "[a, bb, b] : " + wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 3) + "\n" +
                "[a, bb, b, ccc] : " + wordsWithoutList(new String[]{"a", "bb", "b", "ccc"}, 4) + "\n");

    }

}
