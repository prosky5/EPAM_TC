package ex10_Array3;

import java.util.Arrays;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions1_9 {
    /*
    Consider the leftmost and righmost appearances of some value in an array.
    We'll say that the "span" is the number of elements between the two inclusive.
    A single value has a span of 1.
    Returns the largest span found in the given array.
    (Efficiency is not a priority.)

    maxSpan([1, 2, 1, 1, 3]) → 4
    maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
    maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */
    static int maxSpan(int[] nums) {
        int span = 0;
        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    tmp = j - i + 1;
                    span = tmp > span ? tmp : span;
                }
            }
        }
        return span;
    }

    /*
    Return an array that contains exactly the same numbers as the given array,
    but rearranged so that every 3 is immediately followed by a 4.
    Do not move the 3's, but every other number may move.
    The array contains the same number of 3's and 4's,
    every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.

    fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
     */
    static int[] fix34(int[] nums) {
        int tmp = 0;
        int lastFindFourId = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                for (int j = lastFindFourId; j < nums.length; j++) {
                    if (nums[j] == 4) {
                        lastFindFourId = j;
                        tmp = nums[i+1];
                        nums[i+1] = 4;
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    /*
    (This is a slightly harder version of the fix34 problem.)
    Return an array that contains exactly the same numbers as the given array,
    but rearranged so that every 4 is immediately followed by a 5.
    Do not move the 4's, but every other number may move.
    The array contains the same number of 4's and 5's,
    and every 4 has a number after it that is not a 4.
    In this version, 5's may appear anywhere in the original array.

    fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
    fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
    fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
     */
    static int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 4 && nums[i+1] != 5) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == 5 && j == 0) {
                        nums[0] = nums[i+1];
                        nums[i+1] = 5;
                    }
                    if (nums[j] == 5 && nums[j-1] != 4) {
                        nums[j] = nums[i+1];
                        nums[i+1] = 5;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    /*
    Given a non-empty array,
    return true if there is a place to split the array
    so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.

    canBalance([1, 1, 1, 2, 1]) → true
    canBalance([2, 1, 1, 2, 1]) → false
    canBalance([10, 10]) → true
     */
    static boolean canBalance(int[] nums) {
        long sum = 0;
        long half = 0;
        for (int num : nums) {
            sum += (long) num;
        }
        for (int i = 0; half < sum/2.0 && i < nums.length; i++) {
            half += (long) nums[i];
        }
//        print(half + " " + sum/2.0);
        return half == sum/2.0;
    }

    /*
    Given two arrays of ints sorted in increasing order, outer and inner,
    return true if all of the numbers in inner appear in outer.
    The best solution makes only a single "linear" pass of both arrays,
    taking advantage of the fact that both arrays are already in sorted order.

    linearIn([1, 2, 4, 6], [2, 4]) → true
    linearIn([1, 2, 4, 6], [2, 3, 4]) → false
    linearIn([1, 2, 4, 4, 6], [2, 4]) → true
     */
    static boolean linearIn(int[] outer, int[] inner) {
        if (inner.length < 1) {
            return true;
        }
        int olen = outer.length;
        int ilen = inner.length;
        for (int i = 0, j = 0; i < olen; i++) {
            if (inner[j] == outer[i]) {
                j++;
            }
            if (j >= ilen) {
                return true;
            }
        }
        return false;
    }

    /*
    Given n>=0, create an array length n*n with the following pattern,
    shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1}
    (spaces added to show the 3 groups).

    squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
    squareUp(2) → [0, 1, 2, 1]
    squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
     */
    static int[] squareUp(int n) {
        int[] arr = new int[n*n];
        int tmp = n;
        for (int i = n*n-1, count = 1; i >= 0; i--, count++) {
            if (count <= tmp) {
                arr[i] = count;
            } else if ((i+1) % n == 0) {
                count = 1;
                tmp--;
                arr[i] = count;
            }
        }
        return arr;
    }

    /*
    Given n>=0, create an array with the pattern
    {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n}
    (spaces added to show the grouping).
    Note that the length of the array will be 1 + 2 + 3 ... + n,
    which is known to sum to exactly n*(n + 1)/2.

    seriesUp(3) → [1, 1, 2, 1, 2, 3]
    seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
    seriesUp(2) → [1, 1, 2]
     */
    static int[] seriesUp(int n) {
        int[] arr = new int[n*(n + 1)/2];
        int i = 0;
        for (int j = 1; j <= n; ++j) {
            for (int k = 1; k <= j; ++k) {
                arr[i++] = k;
            }
        }
        return arr;
    }

    /*
    We'll say that a "mirror" section in an array
    is a group of contiguous elements such that somewhere in the array,
    the same group appears in reverse order.
    For example, the largest mirror section in
    {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part).
    Return the size of the largest mirror section found in the given array.

    maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
    maxMirror([1, 2, 1, 4]) → 3
    maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
     */
    static int maxMirror(int[] nums) {
        int addCount = 0;
        int max = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            addCount = 0;
            for (int j = len -1; i + addCount < len && j >= 0; j--) {
                if (nums[i+addCount] == nums[j]) {
                    addCount++;
                } else {
                    if (addCount > 0) {
                        max = Math.max(addCount, max);
                        addCount = 0;
                    }
                }
            }
            max = Math.max(addCount, max);
        }
        return max;
    }

    /*
    Say that a "clump" in an array is a series of 2
    or more adjacent elements of the same value.
    Return the number of clumps in the given array.

    countClumps([1, 2, 2, 3, 4, 4]) → 2
    countClumps([1, 1, 2, 1, 1]) → 2
    countClumps([1, 1, 1, 1, 1]) → 1
     */
    static int countClumps(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                if (i+1 >= nums.length || nums[i] != nums[i+1]) {
                    count++;
                }
            }
        }
        return count;
    }




    public static void main(String[] args) {

        // maxSpan:
        print();
        print(" maxSpan: \n" +
                "4 : " + maxSpan(new int[]{1, 2, 1, 1, 3}) + "\n" +
                "6 : " + maxSpan(new int[]{1, 4, 2, 1, 4, 1, 4}) + "\n" +
                "6 : " + maxSpan(new int[]{1, 4, 2, 1, 4, 4, 4}) + "\n");

        // fix34:
        print();
        print(" fix34: \n" +
                "[1, 3, 4, 1] : " + Arrays.toString(fix34(new int[]{1, 3, 4, 1})) + "\n" +
                "[1, 3, 4, 1, 1, 3, 4] : " + Arrays.toString(fix34(new int[]{1, 3, 1, 4, 4, 3, 1})) + "\n" +
                "[3, 4, 2, 2] : " + Arrays.toString(fix34(new int[]{3, 2, 2, 4})) + "\n" +
                "[2, 3, 4, 3, 4, 2, 2] : " + Arrays.toString(fix34(new int[]{2, 3, 2, 3, 2, 4, 4})) + "\n" +
                "[5, 3, 4, 5, 5, 5, 5, 5, 3, 4, 3, 4] : " + Arrays.toString(fix34(new int[]{5, 3, 5, 4, 5, 4, 5, 4, 3, 5, 3, 5})) + "\n");


        // fix45:
        print();
        print(" fix45: \n" +
                "[9, 4, 5, 4, 5, 9] : " + Arrays.toString(fix45(new int[]{5, 4, 9, 4, 9, 5})) + "\n" +
                "[1, 4, 5, 1] : " + Arrays.toString(fix45(new int[]{1, 4, 1, 5})) + "\n" +
                "[1, 4, 5, 1, 1, 4, 5] : " + Arrays.toString(fix45(new int[]{1, 4, 1, 5, 5, 4, 1})) + "\n");

        // canBalance:
        print();
        print(" canBalance: \n" +
                "True : " + canBalance(new int[]{1, 1, 1, 2, 1}) + "\n" +
                "False : " + canBalance(new int[]{2, 1, 1, 2, 1}) + "\n" +
                "True : " + canBalance(new int[]{10, 10}) + "\n");

        // linearIn:
        print();
        print(" linearIn: \n" +
                "True : " + linearIn(new int[]{1, 2, 4, 6}, new int[]{2, 4}) + "\n" +
                "False : " + linearIn(new int[]{1, 2, 4, 6}, new int[]{2, 3, 4}) + "\n" +
                "True : " + linearIn(new int[]{1, 2, 4, 4, 6}, new int[]{2, 4}) + "\n" +
                "True : " + linearIn(new int[]{2, 2, 2, 2, 4}, new int[]{2, 4}) + "\n" +
                "True : " + linearIn(new int[]{1, 2, 3}, new int[]{}) + "\n" +
                "False : " + linearIn(new int[]{2, 2, 2, 2}, new int[]{2, 4}) + "\n");

        // squareUp:
        print();
        print(" squareUp: \n" +
                "[0, 0, 1, 0, 2, 1, 3, 2, 1] : " + Arrays.toString(squareUp(3)) + "\n" +
                "[0, 1, 2, 1] : " + Arrays.toString(squareUp(2)) + "\n" +
                "[0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1] : " + Arrays.toString(squareUp(4)) + "\n");

        // seriesUp:
        print();
        print(" seriesUp: \n" +
                "[1, 1, 2, 1, 2, 3] : " + Arrays.toString(seriesUp(3)) + "\n" +
                "[1, 1, 2, 1, 2, 3, 1, 2, 3, 4] : " + Arrays.toString(seriesUp(4)) + "\n" +
                "[1, 1, 2] : " + Arrays.toString(seriesUp(2)) + "\n");

        // maxMirror:
        print();
        print(" maxMirror: \n" +
                "3 : " + maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}) + "\n" +
                "3 : " + maxMirror(new int[]{1, 2, 1, 4}) + "\n" +
                "2 : " + maxMirror(new int[]{7, 1, 2, 9, 7, 2, 1}) + "\n");

        // countClumps:
        print();
        print(" countClumps: \n" +
                "2 : " + countClumps(new int[]{1, 2, 2, 3, 4, 4}) + "\n" +
                "2 : " + countClumps(new int[]{1, 1, 2, 1, 1}) + "\n" +
                "1 : " + countClumps(new int[]{1, 1, 1, 1, 1}) + "\n");

    }
}
