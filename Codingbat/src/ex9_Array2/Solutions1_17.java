package ex9_Array2;

import java.util.Arrays;

import static utils.Print.*;

public class Solutions1_17 {

    /*
    Return the number of even ints in the given array.

    countEvens([2, 1, 2, 3, 4]) → 3
    countEvens([2, 2, 0]) → 3
    countEvens([1, 3, 5]) → 0
     */
    static int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array length 1 or more of ints,
    return the difference between the largest and smallest values in the array.

    bigDiff([10, 3, 5, 6]) → 7
    bigDiff([7, 2, 10, 9]) → 8
    bigDiff([2, 10, 7, 2]) → 8
     */
    static int bigDiff(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min;
    }

    /*
    Return the "centered" average of an array of ints,
    which we'll say is the mean average of the values,
    except ignoring the largest and smallest values in the array.
    If there are multiple copies of the smallest value,
    ignore just one copy, and likewise for the largest value.
    Use int division to produce the final average.
    You may assume that the array is length 3 or more.

    centeredAverage([1, 2, 3, 4, 100]) → 3
    centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
    centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
     */
    static int centeredAverage(int[] nums) {
        int summ = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            summ += nums[i];
        }
        return (summ - max - min) / (nums.length - 2);
    }

    /*
    Return the sum of the numbers in the array, returning 0 for an empty array.
    Except the number 13 is very unlucky, so it does not count
    and numbers that come immediately after a 13 also do not count.

    sum13([1, 2, 2, 1]) → 6
    sum13([1, 1]) → 2
    sum13([1, 2, 2, 1, 13]) → 6
     */
    static int sum13(int[] nums) {
        int summ = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 13) {
                summ += nums[i];
            } else {
                i++;
            }
        }
        return summ;
    }

    /*
    Return the sum of the numbers in the array,
    except ignore sections of numbers starting with a 6
    and extending to the next 7 (every 6 will be followed by at least one 7).
    Return 0 for no numbers.

    sum67([1, 2, 2]) → 5
    sum67([1, 2, 2, 6, 99, 99, 7]) → 5
    sum67([1, 1, 6, 7, 2]) → 4
     */
    static int sum67(int[] nums) {
        int summ = 0;
        boolean miss = false;

        for (int num : nums) {
            if (num == 6) {
                miss = true;
                continue;
            }
            if (num == 7 && miss) {
                miss = false;
                continue;
            }
            if (!miss) {
                summ += num;
            }
        }
        return summ;
    }

    /*
    Given an array of ints,
    return true if the array contains a 2 next to a 2 somewhere.

    has22([1, 2, 2]) → true
    has22([1, 2, 1, 2]) → false
    has22([2, 1, 2]) → false
     */
    static boolean has22(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 2 && nums[i+1] == 2) {
                return true;
            }
        }
        return false;
    }

    /*
    Given an array of ints,
    return true if the array contains no 1's and no 3's.

    lucky13([0, 2, 4]) → true
    lucky13([1, 2, 3]) → false
    lucky13([1, 2, 4]) → false
     */
    static boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) {
                return false;
            }
        }
        return true;
    }

    /*
    Given an array of ints,
    return true if the sum of all the 2's in the array is exactly 8.

    sum28([2, 3, 2, 2, 4, 2]) → true
    sum28([2, 3, 2, 2, 4, 2, 2]) → false
    sum28([1, 2, 3, 4]) → false
     */
    static boolean sum28(int[] nums) {
        int summ = 0;
        for (int num : nums) {
            if (num == 2) {
                summ += 2;
            }
        }
        return summ == 8;
    }

    /*
    Given an array of ints,
    return true if the number of 1's is greater than the number of 4's

    more14([1, 4, 1]) → true
    more14([1, 4, 1, 4]) → false
    more14([1, 1]) → true
     */
    static boolean more14(int[] nums) {
        int count1 = 0;
        int count4 = 0;

        for (int num : nums) {
            if (num == 1) {
                count1++;
            }
            if (num == 4) {
                count4++;
            }
        }
        return count1 > count4;
    }

    /*
    Given a number n,
    create and return a new int array of length n,
    containing the numbers 0, 1, 2, ... n-1.
    The given n may be 0, in which case just return a length 0 array.
    You do not need a separate if-statement for the length-0 case;
    the for-loop should naturally execute 0 times in that case, so it just works.
    The syntax to make a new int array is: new int[desired_length]

    fizzArray(4) → [0, 1, 2, 3]
    fizzArray(1) → [0]
    fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     */
    static int[] fizzArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }

    /*
    Given an array of ints, return true if every element is a 1 or a 4.

    only14([1, 4, 1, 4]) → true
    only14([1, 4, 2, 4]) → false
    only14([1, 1]) → true
     */
    static boolean only14(int[] nums) {
        for (int num : nums) {
            if (num != 1 && num != 4) {
                return false;
            }
        }
        return true;
    }

    /*
    Given a number n,
    create and return a new string array of length n,
    containing the strings "0", "1" "2" .. through n-1.
    N may be 0, in which case just return a length 0 array.

    fizzArray2(4) → ["0", "1", "2", "3"]
    fizzArray2(10) → ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    fizzArray2(2) → ["0", "1"]
     */
    static String[] fizzArray2(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = String.valueOf(i);
        }
        return res;
    }

    /*
    Given an array of ints,
    return true if it contains no 1's or it contains no 4's.

    no14([1, 2, 3]) → true
    no14([1, 2, 3, 4]) → false
    no14([2, 3, 4]) → true
     */
    static boolean no14(int[] nums) {
        boolean check1 = false;
        boolean check4 = false;

        for (int num : nums) {
            if (num == 1) {
                check1 = true;
            }
            if (num == 4) {
                check4 = true;
            }
        }
        return !(check1 && check4);
    }

    /*
    We'll say that a value is "everywhere" in an array
    if for every pair of adjacent elements in the array,
    at least one of the pair is that value.
    Return true if the given value is everywhere in the array.

    isEverywhere([1, 2, 1, 3], 1) → true
    isEverywhere([1, 2, 1, 3], 2) → false
    isEverywhere([1, 2, 1, 3, 4], 1) → false
     */
    static boolean isEverywhere(int[] nums, int val) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val) {
                return false;
            }
        }
        return true;
    }

    /*
    Given an array of ints,
    return true if the array contains a 2 next to a 2 or a 4 next to a 4,
    but not both.

    either24([1, 2, 2]) → true
    either24([4, 4, 1]) → true
    either24([4, 4, 1, 2, 2]) → false
     */
    static boolean either24(int[] nums) {
        boolean check2 = false;
        boolean check4 = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i+1] == 2) {
                check2 = true;
            }
            if (nums[i] == 4 && nums[i+1] == 4) {
                check4 = true;
            }
        }
        return check2 ^ check4;
    }

    /*
    Given arrays nums1 and nums2 of the same length,
    for every element in nums1,
    consider the corresponding element in nums2 (at the same index).
    Return the count of the number of times that the two elements differ by 2 or less,
    but are not equal.

    matchUp([1, 2, 3], [2, 3, 10]) → 2
    matchUp([1, 2, 3], [2, 3, 5]) → 3
    matchUp([1, 2, 3], [2, 3, 3]) → 2
     */
    static int matchUp(int[] nums1, int[] nums2) {
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i] && Math.abs(nums1[i] - nums2[i]) <= 2) {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array of ints,
    return true if the array contains two 7's next to each other,
    or there are two 7's separated by one element, such as with {7, 1, 7}.

    has77([1, 7, 7]) → true
    has77([1, 7, 1, 7]) → true
    has77([1, 7, 1, 1, 7]) → false
     */
    static boolean has77(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 ) {
                if (nums[i+1] == 7) {
                    return true;
                }
                if (i+2 < nums.length && nums[i+2] == 7) {
                    return true;
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        // countEvens:
        print();
        print(" countEvens: \n" +
                "3 : " + countEvens(new int[]{2, 1, 2, 3, 4}) + "\n" +
                "3 : " + countEvens(new int[]{2, 2, 0}) + "\n" +
                "0 : " + countEvens(new int[]{1, 3, 5}));

        // bigDiff:
        print();
        print(" bigDiff: \n" +
                "7 : " + bigDiff(new int[]{10, 3, 5, 6}) + "\n" +
                "8 : " + bigDiff(new int[]{7, 2, 10, 9}) + "\n" +
                "8 : " + bigDiff(new int[]{2, 10, 7, 2}));

        // centeredAverage:
        print();
        print(" centeredAverage: \n" +
                "3 : " + centeredAverage(new int[]{1, 2, 3, 4, 100}) + "\n" +
                "5 : " + centeredAverage(new int[]{1, 1, 5, 5, 10, 8, 7}) + "\n" +
                "-3 : " + centeredAverage(new int[]{-10, -4, -2, -4, -2, 0}));

        // sum13:
        print();
        print(" sum13: \n" +
                "6 : " + sum13(new int[]{1, 2, 2, 1}) + "\n" +
                "2 : " + sum13(new int[]{1, 1}) + "\n" +
                "6 : " + sum13(new int[]{1, 2, 2, 1, 13}));

        // sum67:
        print();
        print(" sum67: \n" +
                "5 : " + sum67(new int[]{1, 2, 2}) + "\n" +
                "5 : " + sum67(new int[]{1, 2, 2, 6, 99, 99, 7}) + "\n" +
                "4 : " + sum67(new int[]{1, 1, 6, 7, 2}) + "\n" +
                "18 : " + sum67(new int[]{2, 7, 6, 2, 6, 7, 2, 7}));

        // has22:
        print();
        print(" has22: \n" +
                "True : " + has22(new int[]{1, 2, 2}) + "\n" +
                "False : " + has22(new int[]{1, 2, 1, 2}) + "\n" +
                "False : " + has22(new int[]{2, 1, 2}));

        // lucky13:
        print();
        print(" lucky13: \n" +
                "True : " + lucky13(new int[]{0, 2, 4}) + "\n" +
                "False : " + lucky13(new int[]{1, 2, 3}) + "\n" +
                "False : " + lucky13(new int[]{1 ,2 ,4}) + "\n");

        // sum28:
        print();
        print(" sum28: \n" +
                "True : " + sum28(new int[]{2, 3, 2, 2, 4, 2}) + "\n" +
                "False : " + sum28(new int[]{2, 3, 2, 2, 4, 2, 2}) + "\n" +
                "False : " + sum28(new int[]{1, 2, 3, 4}) + "\n");

        // more14:
        print();
        print(" more14: \n" +
                "True : " + more14(new int[]{1, 4, 1}) + "\n" +
                "False : " + more14(new int[]{1, 4, 1, 4}) + "\n" +
                "True : " + more14(new int[]{1, 1}) + "\n");

        // fizzArray:
        print();
        print(" fizzArray: \n" +
                "[0, 1, 2, 3] : " + Arrays.toString(fizzArray(4)) + "\n" +
                "[0] : " + Arrays.toString(fizzArray(1)) + "\n" +
                "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9] : " + Arrays.toString(fizzArray(10)) + "\n");

        // only14:
        print();
        print(" only14: \n" +
                "True : " + only14(new int[]{1, 4, 1, 4}) + "\n" +
                "False : " + only14(new int[]{1, 4, 2, 4}) + "\n" +
                "True : " + only14(new int[]{1, 1}) + "\n");

        // fizzArray2:
        print();
        print(" fizzArray2: \n" +
                "[\"0\", \"1\", \"2\", \"3\"] : " + arrPrint(fizzArray2(4)) + "\n" +
                "[\"0\", \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\"] : " + arrPrint(fizzArray2(10)) + "\n" +
                "[\"0\", \"1\"] : " + arrPrint(fizzArray2(2)) + "\n");

        // no14:
        print();
        print(" no14: \n" +
                "True : " + no14(new int[]{1, 2, 3}) + "\n" +
                "False : " + no14(new int[]{1, 2, 3, 4}) + "\n" +
                "True : " + no14(new int[]{2, 3, 4}) + "\n");

        // isEverywhere:
        print();
        print(" isEverywhere: \n" +
                "True : " + isEverywhere(new int[]{1, 2, 1, 3}, 1) + "\n" +
                "False : " + isEverywhere(new int[]{1, 2, 1, 3}, 2) + "\n" +
                "False : " + isEverywhere(new int[]{1, 2, 1, 3, 4}, 1) + "\n" +
                "True : " + isEverywhere(new int[]{3}, 1) + "\n" +
                "False : " + isEverywhere(new int[]{2, 1, 2, 2, 2, 1, 1, 2}, 2) + "\n");

        // either24:
        print();
        print(" either24: \n" +
                "True : " + either24(new int[]{1, 2, 2}) + "\n" +
                "True : " + either24(new int[]{4, 4, 1}) + "\n" +
                "False : " + either24(new int[]{4, 4, 1, 2, 2}) + "\n");

        // matchUp:
        print();
        print(" matchUp: \n" +
                "2 : " + matchUp(new int[]{1, 2, 3}, new int[]{2, 3, 10}) + "\n" +
                "3 : " + matchUp(new int[]{1, 2, 3}, new int[]{2, 3, 5}) + "\n" +
                "2 : " + matchUp(new int[]{1, 2, 3}, new int[]{2, 3, 3}) + "\n");

        // has77:
        print();
        print(" has77: \n" +
                "True : " + has77(new int[]{1, 7, 7}) + "\n" +
                "True : " + has77(new int[]{1, 7, 1 ,7}) + "\n" +
                "False : " + has77(new int[]{1, 7, 1, 1, 7}) + "\n" +
                "True : " + has77(new int[]{7, 7, 1, 1, 7}) + "\n" +
                "False : " + has77(new int[]{1, 7}));

    }

}
