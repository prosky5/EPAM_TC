package ex11_AP1;

import static utils.Print.*;

public class Solutions15_21 {

    /*
    Given two arrays, A and B, of non-negative int scores.
    A "special" score is one which is a multiple of 10, such as 40 or 90.
    Return the sum of largest special score in A and the largest special score in B.
    To practice decomposition,
    write a separate helper method which finds the largest special score in an array.
    Write your helper method after your scoresSpecial() method in the JavaBat text area.

    scoresSpecial([12, 10, 4], [2, 20, 30]) → 40
    scoresSpecial([20, 10, 4], [2, 20, 10]) → 40
    scoresSpecial([12, 11, 4], [2, 20, 31]) → 20
     */
    static int scoresSpecial(int[] a, int[] b) {
        return largest(a) + largest(b);
    }

    static int largest(int[] arr) {
        int res = 0;
        for (int score : arr) {
            if (score % 10 == 0 && score > res) {
                res = score;
            }
        }
        return res;
    }

    /*
    We have an array of heights,
    representing the altitude along a walking trail.
    Given start/end indexes into the array, return the sum of the changes
    for a walk beginning at the start index and ending at the end index.
    For example,
    with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1 + 5 = 6.
    The start end end index will both be valid indexes into the array with start <= end.

    sumHeights([5, 3, 6, 7, 2], 2, 4) → 6
    sumHeights([5, 3, 6, 7, 2], 0, 1) → 2
    sumHeights([5, 3, 6, 7, 2], 0, 4) → 11
     */
    static int sumHeights(int[] heights, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res += Math.abs(heights[i+1] - heights[i]);
        }
        return res;
    }

    /*
    We have an array of heights,
    representing the altitude along a walking trail.
    Given start/end indexes into the array, return the sum of the changes
    for a walk beginning at the start index and ending at the end index,
    however increases in height count double.
    For example,
    with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1*2 + 5 = 7.
    The start end end index will both be valid indexes into the array with start <= end.

    sumHeights2([5, 3, 6, 7, 2], 2, 4) → 7
    sumHeights2([5, 3, 6, 7, 2], 0, 1) → 2
    sumHeights2([5, 3, 6, 7, 2], 0, 4) → 15
     */
    static int sumHeights2(int[] heights, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            int diff = Math.abs(heights[i+1] - heights[i]);
            if (heights[i+1] > heights[i]) {
                res += diff * 2;
            } else {
                res += diff;
            }
        }
        return res;
    }

    /*
    We have an array of heights,
    representing the altitude along a walking trail.
    Given start/end indexes into the array,
    return the number of "big" steps for a walk starting at the start index and ending at the end index.
    We'll say that step is big if it is 5 or more up or down. The start end end index will both be valid indexes into the array with start <= end.

    bigHeights([5, 3, 6, 7, 2], 2, 4) → 1
    bigHeights([5, 3, 6, 7, 2], 0, 1) → 0
    bigHeights([5, 3, 6, 7, 2], 0, 4) → 1
     */
    static int bigHeights(int[] heights, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            int diff = Math.abs(heights[i+1] - heights[i]);
            if (diff >= 5) {
                res += 1;
            }
        }
        return res;
    }

    /*
    We have data for two users, A and B,
    each with a String name and an int id.
    The goal is to order the users such as for sorting.
    Return -1 if A comes before B, 1 if A comes after B,
    and 0 if they are the same.
    Order first by the string names,
    and then by the id numbers if the names are the same.
    Note: with Strings str1.compareTo(str2)
    returns an int value which is negative/0/positive
    to indicate how str1 is ordered to str2
    (the value is not limited to -1/0/1).
    (On the AP, there would be two User objects,
    but here the code simply takes the two strings and two ints directly.
    The code logic is the same.)

    userCompare("bb", 1, "zz", 2) → -1
    userCompare("bb", 1, "aa", 2) → 1
    userCompare("bb", 1, "bb", 1) → 0
     */
    static int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) > 0) {
            return 1;
        } else if (aName.compareTo(bName) < 0) {
            return -1;
        } else {
            return Integer.compare(aId, bId);
        }
    }

    /*
    Start with two arrays of strings, A and B,
    each with its elements in alphabetical order and without duplicates.
    Return a new array containing the first N elements from the two arrays.
    The result array should be in alphabetical order and without duplicates.
    A and B will both have a length which is N or more.
    The best "linear" solution makes a single pass over A and B,
    taking advantage of the fact that they are in alphabetical order,
    copying elements directly to the new array.

    mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
    mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
    mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]
     */
    static String[] mergeTwo(String[] a, String[] b, int n) {
        String[] arr = new String[n];
        int i = 0, j = 0;
        while (n > 0 && i < a.length && j < b.length ) {
            if (a[i].compareTo(b[j]) < 0) {
                arr[arr.length - n] = a[i];
                i++;
                n--;
            } else if (a[i].compareTo(b[j]) > 0) {
                arr[arr.length - n] = b[j];
                j++;
                n--;
            } else {
                arr[arr.length - n] = a[i];
                i++;
                n--;
                j++;
            }
        }
        return arr;
    }

    /*
    Start with two arrays of strings, a and b,
    each in alphabetical order, possibly with duplicates.
    Return the count of the number of strings which appear in both arrays.
    The best "linear" solution makes a single pass over both arrays,
    taking advantage of the fact that they are in alphabetical order.

    commonTwo(["a", "c", "x"], ["b", "c", "d", "x"]) → 2
    commonTwo(["a", "c", "x"], ["a", "b", "c", "x", "z"]) → 3
    commonTwo(["a", "b", "c"], ["a", "b", "c"]) → 3
     */
    static int commonTwo(String[] a, String[] b) {
        int count = 0;
        String str = "";
        for (String anA : a) {
            for (String aB : b) {
                if (anA.equals(aB) && !str.contains(anA)) {
                    str += anA;
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        // scoresSpecial:
        print();
        print(" scoresSpecial: \n" +
                "40 : " + scoresSpecial(new int[]{12, 10, 4}, new int[]{2, 20, 30}) + "\n" +
                "40 : " + scoresSpecial(new int[]{20, 10, 4}, new int[]{2, 20, 10}) + "\n" +
                "20 : " + scoresSpecial(new int[]{12, 11, 4}, new int[]{2, 20, 31}) + "\n");

        // sumHeights:
        print();
        print(" sumHeights: \n" +
                "6 : " + sumHeights(new int[]{5, 3, 6, 7, 2}, 2, 4) + "\n" +
                "2 : " + sumHeights(new int[]{5, 3, 6, 7, 2}, 0, 1) + "\n" +
                "11 : " + sumHeights(new int[]{5, 3, 6, 7, 2}, 0, 4) + "\n");

        // sumHeights2:
        print();
        print(" sumHeights2: \n" +
                "7 : " + sumHeights2(new int[]{5, 3, 6, 7, 2}, 2, 4) + "\n" +
                "2 : " + sumHeights2(new int[]{5, 3, 6, 7, 2}, 0, 1) + "\n" +
                "15 : " + sumHeights2(new int[]{5, 3, 6, 7, 2}, 0, 4) + "\n");

        // bigHeights:
        print();
        print(" bigHeights: \n" +
                "1 : " + bigHeights(new int[]{5, 3, 6, 7, 2}, 2, 4) + "\n" +
                "0 : " + bigHeights(new int[]{5, 3, 6, 7, 2}, 0, 1) + "\n" +
                "1 : " + bigHeights(new int[]{5, 3, 6, 7, 2}, 0, 4) + "\n");

        // userCompare:
        print();
        print(" userCompare: \n" +
                "-1 : " + userCompare("bb", 1, "zz", 2) + "\n" +
                "1 : " + userCompare("bb", 1, "aa", 2) + "\n" +
                "0 : " + userCompare("bb", 1, "bb", 1) + "\n");

        // mergeTwo:
        print();
        print(" mergeTwo: \n" +
                "[\"a\", \"b\", \"c\"] : " + arrPrint(mergeTwo(new String[]{"a", "c", "z"}, new String[]{"b", "f", "z"}, 3)) + "\n" +
                "[\"a\", \"c\", \"f\"] : " + arrPrint(mergeTwo(new String[]{"a", "c", "z"}, new String[]{"c", "f", "z"}, 3)) + "\n" +
                "[\"c\", \"f\", \"g\"] : " + arrPrint(mergeTwo(new String[]{"f", "g", "z"}, new String[]{"c", "f", "g"}, 3)) + "\n");

        // commonTwo:
        print();
        print(" commonTwo: \n" +
                "2 : " + commonTwo(new String[]{"a", "c", "x"}, new String[]{"b", "c", "d", "x"}) + "\n" +
                "3 : " + commonTwo(new String[]{"a", "c", "x"}, new String[]{"a", "b", "c", "x", "z"}) + "\n" +
                "3 : " + commonTwo(new String[]{"a", "b", "c"}, new String[]{"a", "b", "c"}) + "\n" +
                "1 : " + commonTwo(new String[]{"a", "a", "b", "b", "c"}, new String[]{"b", "b", "b", "x"}) + "\n");

    }


}
