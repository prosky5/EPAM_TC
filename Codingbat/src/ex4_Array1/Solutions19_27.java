package ex4_Array1;

import java.util.Arrays;

import static utils.Print.*;

public class Solutions19_27 {

    /*
    Given an array of ints of even length,
    return a new array length 2 containing the middle two elements from the original array.
    The original array will be length 2 or more.

    makeMiddle([1, 2, 3, 4]) → [2, 3]
    makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
    makeMiddle([1, 2]) → [1, 2]
     */
    static int[] makeMiddle(int[] nums) {
        int mid = nums.length / 2;
        return new int[]{nums[mid - 1], nums[mid]};
    }

    /*
    Given 2 int arrays, each length 2,
    return a new array length 4 containing all their elements.

    plusTwo([1, 2], [3, 4]) → [1, 2, 3, 4]
    plusTwo([4, 4], [2, 2]) → [4, 4, 2, 2]
    plusTwo([9, 2], [3, 4]) → [9, 2, 3, 4]
     */
    static int[] plusTwo(int[] a, int[] b) {
        return new int[]{a[0], a[1], b[0], b[1]};
    }

    /*
    Given an array of ints, swap the first and last elements in the array.
    Return the modified array. The array length will be at least 1.

    swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    swapEnds([1, 2, 3]) → [3, 2, 1]
    swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
     */
    static int[] swapEnds(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = nums[i];
        }
        res[nums.length - 1] = nums[0];
        return res;
    }

    /*
    Given an array of ints of odd length,
    return a new array length 3 containing the elements from the middle of the array.
    The array length will be at least 3.

    midThree([1, 2, 3, 4, 5]) → [2, 3, 4]
    midThree([8, 6, 7, 5, 3, 0, 9]) → [7, 5, 3]
    midThree([1, 2, 3]) → [1, 2, 3]
     */
    static int[] midThree(int[] nums) {
        int mid = nums.length / 2;
        return new int[]{nums[mid - 1], nums[mid], nums[mid + 1]};
    }

    /*
    Given an array of ints of odd length,
    look at the first, last, and middle values in the array and return the largest.
    The array length will be a least 1.

    maxTriple([1, 2, 3]) → 3
    maxTriple([1, 5, 3]) → 5
    maxTriple([5, 2, 3]) → 5
     */
    static int maxTriple(int[] nums) {
        if (nums.length > 1) {
            int first = nums[0];
            int mid = nums[nums.length / 2];
            int last = nums[nums.length - 1];

            if (first >= last && first >= mid) {
                return nums[0];
            } else if (last >= first && last >= mid) {
                return nums[nums.length - 1];
            } else {
                return nums[nums.length / 2];
            }
        } else {
            return nums[0];
        }
    }

    /*
    Given an int array of any length,
    return a new array of its first 2 elements.
    If the array is smaller than length 2, use whatever elements are present.

    frontPiece([1, 2, 3]) → [1, 2]
    frontPiece([1, 2]) → [1, 2]
    frontPiece([1]) → [1]
     */
    static int[] frontPiece(int[] nums) {
        if (nums.length >= 1) {                     // считается костылем?
            return nums.length == 1 ? new int[]{nums[0]} : new int[]{nums[0], nums[1]};
        } else {
            return new int[]{};
        }
    }

    /*
    We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1.
    Return true if the given array contains an unlucky 1 in the first 2
    or last 2 positions in the array.

    unlucky1([1, 3, 4, 5]) → true
    unlucky1([2, 1, 3, 4, 5]) → true
    unlucky1([1, 1, 1]) → false
     */
    static boolean unlucky1(int[] nums) {
        int[] unlucky = new int[]{1, 3};
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < 2 || i > nums.length - 3 && i < nums.length) {
                if (nums[i] == unlucky[0] && nums[i + 1] == unlucky[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Given 2 int arrays, a and b,
    return a new array length 2 containing, as much as will fit,
    the elements from a followed by the elements from b. The arrays may be any length,
    including 0, but there will be 2 or more elements available between the 2 arrays.

    make2([4, 5], [1, 2, 3]) → [4, 5]
    make2([4], [1, 2, 3]) → [4, 1]
    make2([], [1, 2]) → [1, 2]
     */
    static int[] make2(int[] a, int[] b) {
        int[] res = new int[2];

//        if (b.length > 0 && a.length > 0) {
//            for (int numA : a) {
//                if (res[0] == 0 && numA > b[b.length - 1]) {
//                    res[0] = numA;
//                } else if (res[1] == 0 && numA > res[0]) {
//                    res[1] = numA;
//                }
//            }
//            if (res[1] == 0) {
//                res[1] = b[0];
//            }
//        }
        if (a.length == 1) {
            return new int[]{a[0], b[0]};
        }
        if (a.length == 0) {
            return new int[]{b[0], b[1]};
        }
        return new int[]{a[0], a[1]};
    }

    /*
    Given 2 int arrays, a and b, of any length,
    return a new array with the first element of each array.
    If either array is length 0, ignore that array.

    front11([1, 2, 3], [7, 9, 8]) → [1, 7]
    front11([1], [2]) → [1, 2]
    front11([1, 7], []) → [1]
     */
    static int[] front11(int[] a, int[] b) {
        if (a.length == 0 && b.length == 0) {
            return new int[]{};
        }
        if (a.length == 0) {
            return new int[]{b[0]};
        }
        if (b.length == 0) {
            return new int[]{a[0]};
        } else {
            return new int[]{a[0], b[0]};
        }
    }


    public static void main(String[] args) {

        // MakeMiddle:
        print();
        print(" MakeMiddle:");
        print("[2, 3] : " + Arrays.toString(makeMiddle(new int[]{1, 2, 3, 4})));
        print("[2, 3] : " + Arrays.toString(makeMiddle(new int[]{7, 1, 2, 3, 4, 9})));
        print("[1, 2] : " + Arrays.toString(makeMiddle(new int[]{1, 2})));

        // PlusTwo:
        print();
        print(" PlusTwo:");
        print("[1, 2, 3, 4] : " + Arrays.toString(plusTwo(new int[]{1, 2}, new int[]{3, 4})));
        print("[4, 4, 2, 2] : " + Arrays.toString(plusTwo(new int[]{4, 4}, new int[]{2, 2})));
        print("[9, 2, 3, 4] : " + Arrays.toString(plusTwo(new int[]{9, 2}, new int[]{3, 4})));

        // SwapEnds:
        print();
        print(" SwapEnds:");
        print("[4, 2, 3, 1] : " + Arrays.toString(swapEnds(new int[]{1, 2, 3, 4})));
        print("[3, 2, 1] : " + Arrays.toString(swapEnds(new int[]{1, 2, 3})));
        print("[5, 6, 7, 9, 8] : " + Arrays.toString(swapEnds(new int[]{8, 6, 7, 9, 5})));

        // MidThree:
        print();
        print(" MidThree:");
        print("[2, 3, 4] : " + Arrays.toString(midThree(new int[]{1, 2, 3, 4, 5})));
        print("[7, 5, 3] : " + Arrays.toString(midThree(new int[]{8, 6, 7, 5, 3, 0, 9})));
        print("[1, 2, 3] : " + Arrays.toString(midThree(new int[]{1, 2, 3})));

        // MaxTriple:
        print();
        print(" MaxTriple:");
        print("3 : " + maxTriple(new int[]{1, 2, 3}));
        print("5 : " + maxTriple(new int[]{1, 5, 3}));
        print("5 : " + maxTriple(new int[]{5, 2, 3}));

        // FrontPiece:
        print();
        print(" FrontPiece:");
        print("[1, 2] : " + Arrays.toString(frontPiece(new int[]{1, 2, 3})));
        print("[1, 2] : " + Arrays.toString(frontPiece(new int[]{1, 2})));
        print("[1] : " + Arrays.toString(frontPiece(new int[]{1})));
        print("[] : " + Arrays.toString(frontPiece(new int[]{})));

        // Unlucky1:
        print();
        print(" Unlucky1:");
        print("True : " + unlucky1(new int[]{1, 3, 4, 5}));
        print("True : " + unlucky1(new int[]{2, 1, 3, 4, 5}));
        print("False : " + unlucky1(new int[]{1, 1, 1}));

        // Make2:
        print();
        print(" Make2:");
        print("[4, 5] : " + Arrays.toString(make2(new int[]{4, 5}, new int[]{1, 2, 3})));
        print("[4, 1] : " + Arrays.toString(make2(new int[]{4}, new int[]{1, 2, 3})));
        print("[1, 2] : " + Arrays.toString(make2(new int[]{1, 2}, new int[]{})));
        print("[1, 2] : " + Arrays.toString(make2(new int[]{}, new int[]{1, 2})));
        print("[3, 1] : " + Arrays.toString(make2(new int[]{3}, new int[]{1, 2, 3})));
        print("[1, 1] : " + Arrays.toString(make2(new int[]{1}, new int[]{1})));
        print("[1, 1] : " + Arrays.toString(make2(new int[]{1, 2, 3}, new int[]{7, 8})));

        // Front11:
        print();
        print(" Front11:");
        print("[1, 7] : " + Arrays.toString(front11(new int[]{1, 2, 3}, new int[]{7, 9, 8})));
        print("[1, 2] : " + Arrays.toString(front11(new int[]{1}, new int[]{2})));
        print("[1] : " + Arrays.toString(front11(new int[]{1, 7}, new int[]{})));
        print("[2] : " + Arrays.toString(front11(new int[]{}, new int[]{2, 8})));
        print("[] : " + Arrays.toString(front11(new int[]{}, new int[]{})));

    }
}
