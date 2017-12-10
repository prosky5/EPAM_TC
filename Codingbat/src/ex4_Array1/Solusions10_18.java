package ex4_Array1;

import java.util.Arrays;

import static utils.Print.*;

public class Solusions10_18 {

    /*
    Given 2 int arrays, a and b, each length 3,
    return a new array length 2 containing their middle elements.

    middleWay([1, 2, 3], [4, 5, 6]) → [2, 5]
    middleWay([7, 7, 7], [3, 8, 0]) → [7, 8]
    middleWay([5, 2, 9], [1, 4, 5]) → [2, 4]
     */
    static int[] middleWay(int[] a, int[] b) {
        return new int[]{a[1], b[1]};
    }

    /*
    Given an array of ints,
    return a new array length 2 containing the first and last elements from the original array.
    The original array will be length 1 or more.

    makeEnds([1, 2, 3]) → [1, 3]
    makeEnds([1, 2, 3, 4]) → [1, 4]
    makeEnds([7, 4, 6, 2]) → [7, 2]
     */
    static int[] makeEnds(int[] nums) {
        return new int[]{nums[0], nums[nums.length-1]};
    }

    /*
    Given an int array length 2, return true if it contains a 2 or a 3.

    has23([2, 5]) → true
    has23([4, 3]) → true
    has23([4, 5]) → false
     */
    static boolean has23(int[] nums) {
        return nums[0] == 2 || nums[0] == 3 || nums[1] == 2 || nums[1] == 3;
    }

    /*
    Given an int array length 2, return true if it does not contain a 2 or 3.

    no23([4, 5]) → true
    no23([4, 2]) → false
    no23([3, 5]) → false
     */
    static boolean no23(int[] nums) {
        return nums[0] != 2 && nums[0] != 3 && nums[1] != 2 && nums[1] != 3;
    }

    /*
    Given an int array,
    return a new array with double the length where its last element
    is the same as the original array,
    and all the other elements are 0.
    The original array will be length 1 or more.
    Note: by default, a new int array contains all 0's.

    makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
    makeLast([1, 2]) → [0, 0, 0, 2]
    makeLast([3]) → [0, 3]
     */
    static int[] makeLast(int[] nums) {
        int[] res = new int[nums.length * 2];
        res[res.length-1] = nums[nums.length-1];
        return res;
    }

    /*
    Given an int array,
    return true if the array contains 2 twice, or 3 twice.
    The array will be length 0, 1, or 2.

    double23([2, 2]) → true
    double23([3, 3]) → true
    double23([2, 3]) → false
     */
    static boolean double23(int[] nums) {
        if (nums.length == 2) {
            return (nums[0] == 2 || nums[0] == 3) && nums[0] == nums[1];
        } else {
            return false;
        }
    }

    /*
    Given an int array length 3,
    if there is a 2 in the array immediately followed by a 3, set the 3 element to 0.
    Return the changed array.

    fix23([1, 2, 3]) → [1, 2, 0]
    fix23([2, 3, 5]) → [2, 0, 5]
    fix23([1, 2, 1]) → [1, 2, 1]
     */
    static int[] fix23(int[] nums) {
        for (int i = 0; i+1 < nums.length; i++) {
            if (nums[i] == 2 && nums[i+1] == 3) {
                nums[i+1] = 0;
                return nums;
            }
        }
        return nums;
    }

    /*
    Start with 2 int arrays, a and b, of any length.
    Return how many of the arrays have 1 as their first element.

    start1([1, 2, 3], [1, 3]) → 2
    start1([7, 2, 3], [1]) → 1
    start1([1, 2], []) → 1
     */
    static int start1(int[] a, int[] b) {
        if ((a.length > 0 && a[0] == 1) || (b.length > 0 && b[0] == 1)) {
            if (a.length > 0 && b.length > 0) {
                return a[0] == b[0] ? 2 : 1;
            }
            return 1;
        }
        return 0;
    }

    /*
    Start with 2 int arrays, a and b, each length 2.
    Consider the sum of the values in each array.
    Return the array which has the largest sum. In event of a tie, return a.

    biggerTwo([1, 2], [3, 4]) → [3, 4]
    biggerTwo([3, 4], [1, 2]) → [3, 4]
    biggerTwo([1, 1], [1, 2]) → [1, 2]
     */
    static int[] biggerTwo(int[] a, int[] b) {
        return (a[0] + a[1] >= b[0] + b[1]) ? a : b;
    }



    public static void main(String[] args) {

        // MiddleWay:
        print();
        print(" MiddleWay:");
        print("[2, 5] : " + Arrays.toString(middleWay(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
        print("[7, 8] : " + Arrays.toString(middleWay(new int[]{7, 7, 7}, new int[]{3, 8, 0})));
        print("[2, 4] : " + Arrays.toString(middleWay(new int[]{5, 2, 9}, new int[]{1, 4, 5})));

        // MakeEnds:
        print();
        print(" MakeEnds:");
        print("[1, 3] : " + Arrays.toString(makeEnds(new int[]{1, 2, 3})));
        print("[1, 4] : " + Arrays.toString(makeEnds(new int[]{1, 2, 3, 4})));
        print("[7, 2] : " + Arrays.toString(makeEnds(new int[]{7, 4, 6, 2})));

        // Has23:
        print();
        print(" Has23:");
        print("True : " + has23(new int[]{2, 5}));
        print("True : " + has23(new int[]{4, 3}));
        print("False : " + has23(new int[]{4, 5}));

        // no23:
        print();
        print(" no23:");
        print("True : " + no23(new int[]{2, 5}));
        print("True : " + no23(new int[]{4, 3}));
        print("False : " + no23(new int[]{4, 5}));

        // MakeLast:
        print();
        print(" MakeLast:");
        print("[0, 0, 0, 0, 0, 6] : " + Arrays.toString(makeLast(new int[]{4, 5, 6})));
        print("[0, 0, 0, 2] : " + Arrays.toString(makeLast(new int[]{1, 2})));
        print("[0, 3] : " + Arrays.toString(makeLast(new int[]{3})));

        // Double23:
        print();
        print(" Double23:");
        print("True : " + double23(new int[]{2, 2}));
        print("True : " + double23(new int[]{3, 3}));
        print("False : " + double23(new int[]{2, 3}));

        // Fix23:
        print();
        print(" Fix23:");
        print("[1, 2, 0] : " + Arrays.toString(fix23(new int[]{1, 2, 3})));
        print("[2, 0, 5] : " + Arrays.toString(fix23(new int[]{2, 3, 5})));
        print("[1, 2, 1] : " + Arrays.toString(fix23(new int[]{1, 2, 1})));
        print("[3, 2, 1] : " + Arrays.toString(fix23(new int[]{3, 2, 1})));
        print("[2, 0, 3] : " + Arrays.toString(fix23(new int[]{2, 3, 3})));

        // Start1:
        print();
        print(" Start1:");
        print("2 : " + start1(new int[]{1, 2, 3}, new int[]{1, 3}));
        print("1 : " + start1(new int[]{7, 2, 3}, new int[]{1}));
        print("1 : " + start1(new int[]{1, 2}, new int[]{}));
        print("0 : " + start1(new int[]{7}, new int[]{}));
        print("0 : " + start1(new int[]{7}, new int[]{8}));

        // BiggerTwo:
        print();
        print(" BiggerTwo:");
        print("[3, 4] : " + Arrays.toString(biggerTwo(new int[]{1, 2}, new int[]{3, 4})));
        print("[3, 4] : " + Arrays.toString(biggerTwo(new int[]{3, 4}, new int[]{1, 2})));
        print("[1, 2] : " + Arrays.toString(biggerTwo(new int[]{1, 1}, new int[]{1, 2})));


    }

}
