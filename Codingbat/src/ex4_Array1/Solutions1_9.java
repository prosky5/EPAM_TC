package ex4_Array1;

import java.util.Arrays;

import static utils.Print.*;

public class Solutions1_9 {

    /*
    Given an array of ints,
    return true if 6 appears as either the first or last element in the array.
    The array will be length 1 or more.

    firstLast6([1, 2, 6]) → true
    firstLast6([6, 1, 2, 3]) → true
    firstLast6([13, 6, 1, 2, 3]) → false
     */
    static boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length-1] == 6;
    }

    /*
    Given an array of ints,
    return true if the array is length 1 or more,
    and the first element and the last element are equal.

    sameFirstLast([1, 2, 3]) → false
    sameFirstLast([1, 2, 3, 1]) → true
    sameFirstLast([1, 2, 1]) → true
     */
    static boolean sameFirstLast(int[] nums) {
        return nums.length != 0 && nums[0] == nums[nums.length-1];
    }

    /*
    Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.

    makePi() → [3, 1, 4]
     */
    static int[] makePi() {
        return new int[]{3, 1, 4};
    }

    /*
    Given 2 arrays of ints, a and b,
    return true if they have the same first element or they have the same last element.
    Both arrays will be length 1 or more.

    commonEnd([1, 2, 3], [7, 3]) → true
    commonEnd([1, 2, 3], [7, 3, 2]) → false
    commonEnd([1, 2, 3], [1, 3]) → true
     */
    static boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length-1] == b[b.length-1];
    }

    /*
    Given an array of ints length 3, return the sum of all the elements.

    sum3([1, 2, 3]) → 6
    sum3([5, 11, 2]) → 18
    sum3([7, 0, 0]) → 7
     */
    static int sum3(int[] nums) {
        return nums[0] + nums[1] + nums[2];
    }

    /*
    Given an array of ints length 3,
    return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}.

    rotateLeft3([1, 2, 3]) → [2, 3, 1]
    rotateLeft3([5, 11, 9]) → [11, 9, 5]
    rotateLeft3([7, 0, 0]) → [0, 0, 7]
     */
    static int[] rotateLeft3(int[] nums) {
        return new int[]{nums[1], nums[2], nums[0]};
    }

    /*
    Given an array of ints length 3,
    return a new array with the elements in reverse order,
    so {1, 2, 3} becomes {3, 2, 1}.

    reverse3([1, 2, 3]) → [3, 2, 1]
    reverse3([5, 11, 9]) → [9, 11, 5]
    reverse3([7, 0, 0]) → [0, 0, 7]
     */
    static int[] reverse3(int[] nums) {
        return new int[]{nums[2], nums[1], nums[0]};
    }

    /*
    Given an array of ints length 3,
    figure out which is larger, the first or last element in the array,
    and set all the other elements to be that value. Return the changed array.

    maxEnd3([1, 2, 3]) → [3, 3, 3]
    maxEnd3([11, 5, 9]) → [11, 11, 11]
    maxEnd3([2, 11, 3]) → [3, 3, 3]
     */
    static int[] maxEnd3(int[] nums) {
        return nums[0] >= nums[2] ?
                new int[]{nums[0], nums[0], nums[0]} :
                new int[]{nums[2], nums[2], nums[2]} ;
    }

    /*
    Given an array of ints,
    return the sum of the first 2 elements in the array.
    If the array length is less than 2, just sum up the elements that exist,
    returning 0 if the array is length 0.

    sum2([1, 2, 3]) → 3
    sum2([1, 1]) → 2
    sum2([1, 1, 1, 1]) → 2
     */
    static int sum2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        return nums[0] + nums[1];
    }


    public static void main(String[] args) {

        // FirstLast6:
        print();
        print(" FirstLast6:");
        print("True : " + firstLast6(new int[]{1, 2, 6}));
        print("True : " + firstLast6(new int[]{6, 1, 2, 3}));
        print("False : " + firstLast6(new int[]{13, 6, 1, 2, 3}));

        // SameFirstLast:
        print();
        print(" SameFirstLast:");
        print("False : " + sameFirstLast(new int[]{1, 2, 3}));
        print("True : " + sameFirstLast(new int[]{1, 2, 3, 1}));
        print("True : " + sameFirstLast(new int[]{1, 2, 1}));
        print("False : " + sameFirstLast(new int[]{}));

        // MakePi:
        print();
        print(" MakePi:");
        print("[3, 1, 4] : " + Arrays.toString(makePi()));

        // CommonEnd:
        print();
        print(" CommonEnd:");
        print("True : " + commonEnd(new int[]{1, 2, 3}, new int[]{7, 3}));
        print("False : " + commonEnd(new int[]{1, 2, 3}, new int[]{7, 3, 2}));
        print("True : " + commonEnd(new int[]{1, 2, 3}, new int[]{1, 3}));

        // Sum3:
        print();
        print(" Sum3:");
        print("6 : " + sum3(new int[]{1, 2, 3}));
        print("18 : " + sum3(new int[]{5, 11, 2}));
        print("7 : " + sum3(new int[]{7, 0, 0}));

        // RotateLeft3:
        print();
        print(" RotateLeft3:");
        print("[2, 3, 1] : " + Arrays.toString(rotateLeft3(new int[]{1, 2, 3})));
        print("[11, 9, 5] : " + Arrays.toString(rotateLeft3(new int[]{5, 11, 9})));
        print("[0, 0, 7] : " + Arrays.toString(rotateLeft3(new int[]{7, 0, 0})));

        // Reverse3:
        print();
        print(" Reverse3:");
        print("[3, 2, 1] : " + Arrays.toString(reverse3(new int[]{1, 2, 3})));
        print("[9, 11, 5] : " + Arrays.toString(reverse3(new int[]{5, 11, 9})));
        print("[0, 0, 7] : " + Arrays.toString(reverse3(new int[]{7, 0, 0})));

        // MaxEnd3:
        print();
        print(" MaxEnd3:");
        print("[3, 3, 3] : " + Arrays.toString(maxEnd3(new int[]{1, 2, 3})));
        print("[11, 11, 11] : " + Arrays.toString(maxEnd3(new int[]{11, 5, 9})));
        print("[3, 3, 3] : " + Arrays.toString(maxEnd3(new int[]{2, 11, 3})));

        // Sum2:
        print();
        print(" Sum2:");
        print("3 : " + sum2(new int[]{1, 2, 3}));
        print("2 : " + sum2(new int[]{1, 1}));
        print("2 : " + sum2(new int[]{1, 1, 1, 1}));
        print("0 : " + sum2(new int[]{}));




    }
}
