package ex13_Recursion2;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions1_8 {

    /*
    Given an array of ints,
    is it possible to choose a group of some of the ints,
    such that the group sums to the given target?
    This is a classic backtracking recursion problem.
    Once you understand the recursive backtracking strategy in this problem,
    you can use the same pattern for many problems to search a space of choices.
    Rather than looking at the whole array,
    our convention is to consider the part of the array
    starting at index start and continuing to the end of the array.
    The caller can specify the whole array simply by passing start as 0.
    No loops are needed -- the recursive calls progress down the array.

    groupSum(0, [2, 4, 8], 10) → true
    groupSum(0, [2, 4, 8], 14) → true
    groupSum(0, [2, 4, 8], 9) → false
     */
    static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        return groupSum(start + 1, nums, target)
                || groupSum(start + 1, nums, target - nums[start]);
    }

    /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    beginning at the start index, such that the group sums to the given target?
    However, with the additional constraint that all 6's must be chosen.
    (No loops needed.)

    groupSum6(0, [5, 6, 2], 8) → true
    groupSum6(0, [5, 6, 2], 9) → false
    groupSum6(0, [5, 6, 2], 7) → false
     */
    static boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        if (nums[start] == 6) return groupSum6(start + 1, nums, target - 6);
        return groupSum6(start + 1, nums, target)
                || groupSum6(start + 1, nums, target - nums[start]);
    }

    /*
    Given an array of ints,
    is it possible to choose a group of some of the ints,
    such that the group sums to the given target with this additional constraint:
    If a value in the array is chosen to be in the group,
    the value immediately following it in the array must not be chosen.
    (No loops needed.)

    groupNoAdj(0, [2, 5, 10, 4], 12) → true
    groupNoAdj(0, [2, 5, 10, 4], 14) → false
    groupNoAdj(0, [2, 5, 10, 4], 7) → false
     */
    static boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        return groupNoAdj(start + 1, nums, target)
                || groupNoAdj(start + 2, nums, target - nums[start]);
    }

    /*
    Given an array of ints,
    is it possible to choose a group of some of the ints,
    such that the group sums to the given target with these additional constraints:
    all multiples of 5 in the array must be included in the group.
    If the value immediately following a multiple of 5 is 1,
    it must not be chosen. (No loops needed.)

    groupSum5(0, [2, 5, 10, 4], 19) → true
    groupSum5(0, [2, 5, 10, 4], 17) → true
    groupSum5(0, [2, 5, 10, 4], 12) → false
     */
    static boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        if (nums[start] % 5 == 0) {
            if (start+1 < nums.length && nums[start+1] == 1) {
                nums[start+1] = 0;
            }
            return groupSum5(start + 1, nums, target - nums[start]);
        }

        return groupSum5(start + 1, nums, target)
                || groupSum5(start + 1, nums, target - nums[start]);
    }

    /*
    Given an array of ints,
    is it possible to choose a group of some of the ints,
    such that the group sums to the given target,
    with this additional constraint:
    if there are numbers in the array that are adjacent and the identical value,
    they must either all be chosen, or none of them chosen.
    For example, with the array {1, 2, 2, 2, 5, 2},
    either all three 2's in the middle must be chosen or not, all as a group.
    (one loop can be used to find the extent of the identical values).

    groupSumClump(0, [2, 4, 8], 10) → true
    groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
    groupSumClump(0, [2, 4, 4, 8], 14) → false
     */
    static boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        int n = 1;
        while (start + n < nums.length && nums[start] == nums[start+n]) {
            n++;
        }

        return groupSumClump(start+n, nums, target - (int) Math.pow(nums[start], n))
                || groupSumClump(start+n, nums, target);
    }

    /*
    Given an array of ints,
    is it possible to divide the ints into two groups,
    so that the sums of the two groups are the same.
    Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitArray().
    (No loops needed.)

    splitArray([2, 2]) → true
    splitArray([2, 3]) → false
    splitArray([5, 2, 3]) → true
     */
    static boolean splitArray(int[] nums) {
        return splitHelper(0, nums, 0);
    }

    static boolean splitHelper(int start, int[] arr, int target) {
        if (start >= arr.length) return target == 0;

        return splitHelper(start+1, arr, target - arr[start])
                || splitHelper(start+1, arr, target + arr[start]);
    }

    /*
    Given an array of ints,
    is it possible to divide the ints into two groups,
    so that the sum of one group is a multiple of 10,
    and the sum of the other group is odd.
    Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitOdd10().
    (No loops needed.)

    splitOdd10([5, 5, 5]) → true
    splitOdd10([5, 5, 6]) → false
    splitOdd10([5, 5, 6, 1]) → true
     */
    static boolean splitOdd10(int[] nums) {
        return splitHelper2(0, nums, 0, 0);
    }

    static boolean splitHelper2(int start, int[] arr, int sum1, int sum2) {
        if (start >= arr.length) return sum1 % 10 == 0 && sum2 % 2 != 0;

        return splitHelper2(start+1, arr, sum1 + arr[start], sum2)
                || splitHelper2(start+1, arr, sum1, sum2 + arr[start]);
    }

    /*
    Given an array of ints,
    is it possible to divide the ints into two groups,
    so that the sum of the two groups is the same,
    with these constraints:
    all the values that are multiple of 5 must be in one group,
    and all the values that are a multiple of 3
    (and not a multiple of 5) must be in the other.
    (No loops needed.)

    split53([1, 1]) → true
    split53([1, 1, 1]) → false
    split53([2, 4, 2]) → true
     */
    static boolean split53(int[] nums) {
        return splitHelper3(0, nums, 0, 0);
    }

    static boolean splitHelper3(int start, int[] arr, int sum1, int sum2) {
        if (start >= arr.length) return sum1 == sum2;

        if (arr[start] % 5 == 0) {
            return splitHelper3(start+1, arr, sum1 + arr[start], sum2);
        } else if (arr[start] % 3 == 0 && arr[start] % 5 != 0) {
            return splitHelper3(start+1, arr, sum1, sum2 + arr[start]);
        }
        return splitHelper3(start+1, arr, sum1 + arr[start], sum2)
                || splitHelper3(start+1, arr, sum1, sum2 + arr[start]);
    }


    public static void main(String[] args) {
        // groupSum:
        print();
        print(" groupSum: \n" +
                "True : " + groupSum(0, new int[]{2, 4, 8}, 10) + "\n" +
                "True : " + groupSum(0, new int[]{2, 4, 8}, 14) + "\n" +
                "False : " + groupSum(0, new int[]{2, 4, 8}, 9) + "\n");

        // groupSum6:
        print();
        print(" groupSum6: \n" +
                "True : " + groupSum6(0, new int[]{5, 6, 2}, 8) + "\n" +
                "False : " + groupSum6(0, new int[]{5, 6, 2}, 9) + "\n" +
                "False : " + groupSum6(0, new int[]{5, 6, 2}, 7) + "\n");

        // groupNoAdj:
        print();
        print(" groupNoAdj: \n" +
                "True : " + groupNoAdj(0, new int[]{2, 5, 10, 4}, 12) + "\n" +
                "False : " + groupNoAdj(0, new int[]{2, 5, 10, 4}, 14) + "\n" +
                "False : " + groupNoAdj(0, new int[]{2, 5, 10, 4}, 7) + "\n");

        // groupSum5:
        print();
        print(" groupSum5: \n" +
                "True : " + groupSum5(0, new int[]{2, 5, 10, 4}, 19) + "\n" +
                "True : " + groupSum5(0, new int[]{2, 5, 10, 4}, 17) + "\n" +
                "False : " + groupSum5(0, new int[]{2, 5, 10, 4}, 12) + "\n" +
                "False : " + groupSum5(0, new int[]{2, 5, 4, 10}, 12) + "\n");

        // groupSumClump:
        print();
        print(" groupSumClump: \n" +
                "True : " + groupSumClump(0, new int[]{2, 4, 8}, 10) + "\n" +
                "True : " + groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14) + "\n" +
                "False : " + groupSumClump(0, new int[]{2, 4, 4, 8}, 14) + "\n" +
                "True : " + groupSumClump(0, new int[]{8, 2, 2, 1}, 9) + "\n");

        // splitArray:
        print();
        print(" splitArray: \n" +
                "True : " + splitArray(new int[]{2, 2}) + "\n" +
                "False : " + splitArray(new int[]{2, 3}) + "\n" +
                "True : " + splitArray(new int[]{5, 2, 3}) + "\n");

        // splitOdd10:
        print();
        print(" splitOdd10: \n" +
                "True : " + splitOdd10(new int[]{5, 5, 5}) + "\n" +
                "False : " + splitOdd10(new int[]{5, 5, 6}) + "\n" +
                "True : " + splitOdd10(new int[]{5, 5, 6, 1}) + "\n");

        // split53:
        print();
        print(" split53: \n" +
                "True : " + split53(new int[]{1, 1}) + "\n" +
                "False : " + split53(new int[]{1, 1, 1}) + "\n" +
                "True : " + split53(new int[]{2, 4, 2}) + "\n");
    }
}
