package ex9_Array2;

import java.util.Arrays;

import static utils.Print.*;

public class Solutions18_34 {

    /*
    Given an array of ints,
    return true if there is a 1 in the array with a 2 somewhere later in the array.

    has12([1, 3, 2]) → true
    has12([3, 1, 2]) → true
    has12([3, 1, 4, 5, 2]) → true
     */
    static boolean has12(int[] nums) {
        boolean check1 = false;
        for (int num : nums) {
            if (num == 1) {
                check1 = true;
            }
            if (check1 && num == 2) {
                return true;
            }
        }
        return false;
    }

    /*
    Given an array of ints,
    return true if the array contains either 3 even
    or 3 odd values all next to each other.

    modThree([2, 1, 3, 5]) → true
    modThree([2, 1, 2, 5]) → false
    modThree([2, 4, 2, 5]) → true
     */
    static boolean modThree(int[] nums) {
        int count = 0;
        int tmp = 0;
        for (int num : nums) {
            if (tmp % 2 != num % 2) {
                count = 0;
            }

            if (num % 2 == 0) {
                tmp = num;
                count++;
            } else if (num % 2 != 0) {
                tmp = num;
                count++;
            }

            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    /*
    Given an array of ints,
    return true if the value 3 appears in the array exactly 3 times,
    and no 3's are next to each other.

    haveThree([3, 1, 3, 1, 3]) → true
    haveThree([3, 1, 3, 3]) → false
    haveThree([3, 4, 3, 3, 4]) → false
     */
    static boolean haveThree(int[] nums) {
        int count3 = 0;
        int tmp = 0;
        for (int num : nums) {
            if (num == 3) {
                if (tmp == 3 || count3 > 3) {
                    return false;
                }
                count3++;
            }
            tmp = num;
        }
        return count3 == 3;
    }

    /*
    Given an array of ints,
    return true if every 2 that appears in the array is next to another 2.

    twoTwo([4, 2, 2, 3]) → true
    twoTwo([2, 2, 4]) → true
    twoTwo([2, 2, 4, 2]) → false
     */
    static boolean twoTwo(int[] nums) {
        boolean check = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                check = i + 1 > nums.length && nums[i + 1] == 2
                        || i - 1 >= 0 && nums[i - 1] == 2;
            }
        }
        return check;
    }

    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    Return true if the group of N numbers
    at the start and end of the array are the same.
    For example, with {5, 6, 45, 99, 13, 5, 6},
    the ends are the same for n=0 and n=2, and false for n=1 and n=3.
    You may assume that n is in the range 0..nums.length inclusive.

    sameEnds([5, 6, 45, 99, 13, 5, 6], 1) → false
    sameEnds([5, 6, 45, 99, 13, 5, 6], 2) → true
    sameEnds([5, 6, 45, 99, 13, 5, 6], 3) → false
     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    static boolean sameEnds(int[] nums, int len) {
        for (int i = 0, j = nums.length-len; i < len; i++, j++){
            if (nums[i] != nums[j])
                return false;
        }
        return true;
    }

    /*
    Return true if the array contains, somewhere,
    three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.

    tripleUp([1, 4, 5, 6, 2]) → true
    tripleUp([1, 2, 3]) → true
    tripleUp([1, 2, 4]) → false
     */
    static boolean tripleUp(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1] - 1 ) {
                count++;
            } else {
                count = 1;
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }

    /*
    Given start and end numbers,
    return a new array containing the sequence of integers
    from start up to but not including end,
    so start=5 and end=10 yields {5, 6, 7, 8, 9}.
    The end number will be greater or equal to the start number.
    Note that a length-0 array is valid. (See also: FizzBuzz Code)

    fizzArray3(5, 10) → [5, 6, 7, 8, 9]
    fizzArray3(11, 18) → [11, 12, 13, 14, 15, 16, 17]
    fizzArray3(1, 3) → [1, 2]
     */
    static int[] fizzArray3(int start, int end) {
        int[] res = new int[end - start];
        for (int i = 0; i < end - start; i++) {
            res[i] = start + i;
        }
        return res;
    }

    /*
    Return an array that is "left shifted" by one --
    so {6, 2, 5, 3} returns {2, 5, 3, 6}.
    You may modify and return the given array, or return a new array.

    shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    shiftLeft([1, 2]) → [2, 1]
    shiftLeft([1]) → [1]
     */
    static int[] shiftLeft(int[] nums) {
        if (nums.length > 0) {
            int tmp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                nums[i - 1] = nums[i];
            }
            nums[nums.length - 1] = tmp;
        }
        return nums;
    }

    /*
    For each multiple of 10 in the given array,
    change all the values following it to be that multiple of 10,
    until encountering another multiple of 10.
    So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.

    tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
    tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
    tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]
     */
    static int[] tenRun(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] % 10 == 0 && nums[i] % 10 != 0 ) {
                nums[i] = nums[i-1];
            }
        }
        return nums;
    }

    /*
    Given a non-empty array of ints,
    return a new array containing the elements from the original array
    that come before the first 4 in the original array.
    The original array will contain at least one 4.
    Note that it is valid in java to create an array of length 0.

    pre4([1, 2, 4, 1]) → [1, 2]
    pre4([3, 1, 4]) → [3, 1]
    pre4([1, 4, 4]) → [1]
     */
    static int[] pre4(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 4) {
                break;
            }
            i++;
        }

        int[] res = new int[i];
        for (int j = 0; j < i; j++) {
            res[j] = nums[j];
        }

        return res;
    }

    /*
    Given a non-empty array of ints,
    return a new array containing the elements from the original array
    that come after the last 4 in the original array.
    The original array will contain at least one 4.
    Note that it is valid in java to create an array of length 0.

    post4([2, 4, 1, 2]) → [1, 2]
    post4([4, 1, 4, 2]) → [2]
    post4([4, 4, 1, 2, 3]) → [1, 2, 3]
     */
    static int[] post4(int[] nums) {
        int k = 0;
        int last4id = 0;
        while (k < nums.length) {
            if (nums[k] == 4) {
                last4id = k;
            }
            k++;
        }

        k = 0;
        int[] res = new int[nums.length - last4id - 1];
        for (int i = last4id + 1; k < res.length; i++, k++) {
            res[k] = nums[i];
        }

        return res;
    }

    /*
    We'll say that an element in an array is "alone"
    if there are values before and after it,
    and those values are different from it.
    Return a version of the given array where every instance of the given value
    which is alone is replaced by whichever value to its left or right is larger.

    notAlone([1, 2, 3], 2) → [1, 3, 3]
    notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
    notAlone([3, 4], 3) → [3, 4]
     */
    static int[] notAlone(int[] nums, int val) {
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] == val && nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                nums[i] = Math.max(nums[i-1], nums[i+1]);
            }
        }
        return nums;
    }

    /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    Return an array that contains the exact same numbers as the given array,
    but rearranged so that all the zeros are grouped at the start of the array.
    The order of the non-zero numbers does not matter.
    So {1, 0, 0, 1} becomes {0 ,0, 1, 1}.
    You may modify and return the given array or make a new array.

    zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    zeroFront([1, 0]) → [0, 1]
     !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
    static int[] zeroFront(int[] nums) {
        int len = nums.length;

        int count = len - 1;
        int[] tmp = new int[len];

        for (int i = 1; i <= len; i++) {
            if (nums[len - i] != 0) {
                tmp[count] = nums[len - i];
                count--;
            }
        }
        return tmp;
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            print("nums["+i+"] = " + nums[i] + "   "+ "nums["+count+"] = " + nums[count]);
//            if (nums[i] == 0) {
//                nums[i] = nums[count];
//                nums[count] = 0;
//                count++;
//            }
//        }
//        print();
//        return nums;
    }

    /*
    Return a version of the given array where all the 10's have been removed.
    The remaining elements should shift left towards the start of the array as needed,
    and the empty spaces a the end of the array should be 0.
    So {1, 10, 10, 2} yields {1, 2, 0, 0}.
    You may modify and return the given array or make a new array.

    withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
    withoutTen([10, 2, 10]) → [2, 0, 0]
    withoutTen([1, 99, 10]) → [1, 99, 0]
     */
    static int[] withoutTen(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, k = 0; i < nums.length; i++) {
            if (nums[i] != 10) {
                res[k] = nums[i];
                k++;
            }
        }
        return res;
    }

    /*
    Return a version of the given array where each zero value in the array
    is replaced by the largest odd value to the right of the zero in the array.
    If there is no odd value to the right of the zero,
    leave the zero as a zero.

    zeroMax([0, 5, 0, 3]) → [5, 5, 3, 3]
    zeroMax([0, 4, 0, 3]) → [3, 4, 3, 3]
    zeroMax([0, 1, 0]) → [1, 1, 0]
     */
    static int[] zeroMax(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) {
                int maxOdd = 0;
                for (int j = i; j + 1 < nums.length; j++) {
                    if (nums[j+1] % 2 != 0 && nums[j+1] > maxOdd) {
                        maxOdd = nums[j+1];
                    }
                }
                nums[i] = maxOdd;
            }
        }
        return nums;
    }

    /*
    Return an array that contains the exact same numbers as the given array,
    but rearranged so that all the even numbers come before all the odd numbers.
    Other than that, the numbers can be in any order.
    You may modify and return the given array, or make a new array.

    evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
    evenOdd([3, 3, 2]) → [2, 3, 3]
    evenOdd([2, 2, 2]) → [2, 2, 2]
     */
    static int[] evenOdd(int[] nums) {
        int len = nums.length;

        int endCount = len - 1;
        int startCount = 0;
        int[] tmp = new int[len];

        for (int i = 1; i <= len; i++) {
            if (nums[len - i] % 2 != 0) {
                tmp[endCount] = nums[len - i];
                endCount--;
            } else {
                tmp[startCount] = nums[len - i];
                startCount++;
            }
        }
        return tmp;
    }

    /*
    This is slightly more difficult version of the famous FizzBuzz problem
    which is sometimes given as a first problem for job interviews.
    Consider the series of numbers beginning at start and running up to
    but not including end,
    so for example start=1 and end=5 gives the series 1, 2, 3, 4.
    Return a new String[] array containing the string form of these numbers,
    except for multiples of 3, use "Fizz" instead of the number,
    for multiples of 5 use "Buzz",
    and for multiples of both 3 and 5 use "FizzBuzz".
    In Java, String.valueOf(xxx) will make the String form of an int or other type.
    This version is a little more complicated than the usual version
    since you have to allocate and index into an array instead of just printing,
    and we vary the start/end instead of just always doing 1..100.

    fizzBuzz(1, 6) → ["1", "2", "Fizz", "4", "Buzz"]
    fizzBuzz(1, 8) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
    fizzBuzz(1, 11) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]
     */
    static String[] fizzBuzz(int start, int end) {
        String[] res = new String[end-start];
        for (int i = 0; start < end; i++) {
            if (start % 5 == 0 && start % 3 == 0) {
                res[i] = "FizzBuzz";
            } else if (start % 5 == 0) {
                res[i] = "Buzz";
            } else if (start % 3 == 0) {
                res[i] = "Fizz";
            } else {
                res[i] = String.valueOf(start);
            }
            start++;
        }
        return res;
    }



    public static void main(String[] args) {
        // has12:
        print();
        print(" has12: \n" +
                "True : " + has12(new int[]{1, 3, 2}) + "\n" +
                "True : " + has12(new int[]{3, 1, 2}) + "\n" +
                "True : " + has12(new int[]{3, 1, 4, 5, 2}) + "\n");

        // modThree:
        print();
        print(" modThree: \n" +
                "True : " + modThree(new int[]{2, 1, 3, 5}) + "\n" +
                "False : " + modThree(new int[]{2, 1, 2, 5}) + "\n" +
                "True : " + modThree(new int[]{2, 4, 2, 5}) + "\n");

        // haveThree:
        print();
        print(" haveThree: \n" +
                "True : " + haveThree(new int[]{3, 1, 3, 1, 3}) + "\n" +
                "False : " + haveThree(new int[]{3, 1, 3, 3}) + "\n" +
                "False : " + haveThree(new int[]{3, 4, 3, 3, 4}) + "\n");

        // twoTwo:
        print();
        print(" twoTwo: \n" +
                "True : " + twoTwo(new int[]{4, 2, 2, 3}) + "\n" +
                "True : " + twoTwo(new int[]{2, 2, 4}) + "\n" +
                "False : " + twoTwo(new int[]{2, 2, 4, 2}) + "\n" +
                "True : " + twoTwo(new int[]{2, 2, 2}) + "\n" +
                "False : " + twoTwo(new int[]{2}) + "\n");

        // sameEnds:
        print();
        print(" sameEnds: \n" +
                "False : " + sameEnds(new int[]{5, 6, 45, 99, 13, 5, 6}, 1) + "\n" +
                "True : " + sameEnds(new int[]{5, 6, 45, 99, 13, 5, 6}, 2) + "\n" +
                "False : " + sameEnds(new int[]{5, 6, 45, 99, 13, 5, 6}, 3) + "\n" +
                "True : " + sameEnds(new int[]{1, 2, 5, 2, 1}, 5) + "\n" +
                "True : " + sameEnds(new int[]{1}, 1) + "\n" +
                "True : " + sameEnds(new int[]{}, 0) + "\n");

        // tripleUp:
        print();
        print(" tripleUp: \n" +
                "True : " + tripleUp(new int[]{1, 4, 5, 6, 2}) + "\n" +
                "True : " + tripleUp(new int[]{1, 2, 3}) + "\n" +
                "False : " + tripleUp(new int[]{1, 2, 4}) + "\n");

        // fizzArray3:
        print();
        print(" fizzArray3: \n" +
                "[5, 6, 7, 8, 9] : " + Arrays.toString(fizzArray3(5, 10)) + "\n" +
                "[11, 12, 13, 14, 15, 16, 17] : " + Arrays.toString(fizzArray3(11, 18)) + "\n" +
                "[1, 2] : " + Arrays.toString(fizzArray3(1 ,3)) + "\n");

        // shiftLeft:
        print();
        print(" shiftLeft: \n" +
                "[2, 5, 3, 6] : " + Arrays.toString(shiftLeft(new int[]{6, 2, 5, 3})) + "\n" +
                "[2, 1] : " + Arrays.toString(shiftLeft(new int[]{1, 2})) + "\n" +
                "[1] : " + Arrays.toString(shiftLeft(new int[]{1})) + "\n");

        // tenRun:
        print();
        print(" tenRun: \n" +
                "2, 10, 10, 10, 20, 20 : " + Arrays.toString(tenRun(new int[]{2, 10, 3, 4, 20, 5})) + "\n" +
                "10, 10, 20, 20 : " + Arrays.toString(tenRun(new int[]{10, 1, 20, 2})) + "\n" +
                "10, 10, 10, 20 : " + Arrays.toString(tenRun(new int[]{10, 1, 9, 20})) + "\n");

        // pre4:
        print();
        print(" pre4: \n" +
                "[1, 2] : " + Arrays.toString(pre4(new int[]{1, 2, 4, 1})) + "\n" +
                "[3, 1] : " + Arrays.toString(pre4(new int[]{3, 1, 4})) + "\n" +
                "[1] : " + Arrays.toString(pre4(new int[]{1, 4, 4})) + "\n");

        // post4:
        print();
        print(" post4: \n" +
                "[1, 2] : " + Arrays.toString(post4(new int[]{2, 4, 1, 2})) + "\n" +
                "[2] : " + Arrays.toString(post4(new int[]{4, 1, 4, 2})) + "\n" +
                "[1, 2, 3] : " + Arrays.toString(post4(new int[]{4, 4, 1, 2, 3})) + "\n");

        // notAlone:
        print();
        print(" notAlone: \n" +
                "[1, 3, 3] : " + Arrays.toString(notAlone(new int[]{1, 2, 3}, 2)) + "\n" +
                "[1, 3, 3, 5, 5, 2] : " + Arrays.toString(notAlone(new int[]{1, 2, 3, 2, 5, 2}, 2)) + "\n" +
                "[3, 4] : " + Arrays.toString(notAlone(new int[]{3, 4}, 3)) + "\n" +
                "[1, 1, 1, 2] : " + Arrays.toString(notAlone(new int[]{1, 1, 1, 2}, 1)));

        // zeroFront:
        print();
        print(" zeroFront: \n" +
                "[0, 0, 1, 1] : " + Arrays.toString(zeroFront(new int[]{1, 0, 0, 1})) + "\n" +
                "[0, 0, 1, 1, 1] : " + Arrays.toString(zeroFront(new int[]{0, 1, 1, 0, 1})) + "\n" +
                "[0, 1] : " + Arrays.toString(zeroFront(new int[]{1, 0})) + "\n" +
                "[0, 0, 0, -1, -1] : " + Arrays.toString(zeroFront(new int[]{-1, 0, 0, -1, 0})));

        // withoutTen:
        print();
        print(" withoutTen: \n" +
                "[1, 2, 0, 0] : " + Arrays.toString(withoutTen(new int[]{1, 10, 10, 2})) + "\n" +
                "[2, 0, 0] : " + Arrays.toString(withoutTen(new int[]{10, 2, 10})) + "\n" +
                "[1, 99, 0] : " + Arrays.toString(withoutTen(new int[]{1, 99, 10})) + "\n");

        // zeroMax:
        print();
        print(" zeroMax: \n" +
                "[5, 5, 3, 3] : " + Arrays.toString(zeroMax(new int[]{0, 5, 0, 3})) + "\n" +
                "[3, 4, 3, 3] : " + Arrays.toString(zeroMax(new int[]{0, 4, 0, 3})) + "\n" +
                "[1, 1, 0] : " + Arrays.toString(zeroMax(new int[]{0, 1, 0})) + "\n" +
                "[7, 3, 4, 3, 1, 1] : " + Arrays.toString(zeroMax(new int[]{7, 0, 4, 3, 0, 1})) + "\n" +
                "[5, 1, 5] : " + Arrays.toString(zeroMax(new int[]{0, 1, 5})) + "\n");

        // evenOdd:
        print();
        print(" evenOdd: \n" +
                "[0, 0, 0, 1, 1, 1, 1] : " + Arrays.toString(evenOdd(new int[]{1, 0, 1, 0, 0, 1, 1})) + "\n" +
                "[2, 3, 3] : " + Arrays.toString(evenOdd(new int[]{3, 3, 2})) + "\n" +
                "[2, 2, 2] : " + Arrays.toString(evenOdd(new int[]{2, 2, 2})) + "\n");

        // fizzBuzz:
        print();
        print(" fizzBuzz: \n" +
                "[\"1\", \"2\", \"Fizz\", \"4\", \"Buzz\"] : " + arrPrint(fizzBuzz(1, 6)) + "\n" +
                "[\"1\", \"2\", \"Fizz\", \"4\", \"Buzz\", \"Fizz\", \"7\"] : " + arrPrint(fizzBuzz(1, 8)) + "\n" +
                "[\"1\", \"2\", \"Fizz\", \"4\", \"Buzz\", \"Fizz\", \"7\", \"8\", \"Fizz\", \"Buzz\"] : " + arrPrint(fizzBuzz(1, 11)) + "\n");

    }

}
