package ex12_Recursion1;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions21_30 {
    /*
    We'll say that a "pair" in a string is two instances of a char separated by a char.
    So "AxA" the A's make a pair.
    Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x.
    Recursively compute the number of pairs in the given string.

    countPairs("axa") → 1
    countPairs("axax") → 2
    countPairs("axbx") → 1
     */
    static int countPairs(String str) {
        if (str.length() <= 2 || str.substring(2).equals("")) return 0;
        if (str.charAt(0) == str.charAt(2)) return 1 + countPairs(str.substring(1));
        return countPairs(str.substring(1));
    }

    /*
    Count recursively
    the total number of "abc" and "aba" substrings
    that appear in the given string.

    countAbc("abc") → 1
    countAbc("abcxxabc") → 2
    countAbc("abaxxaba") → 2
     */
    static int countAbc(String str) {
        if (str.length() < 3) return 0;
        if (str.substring(0, 3).equals("abc")
                || str.substring(0, 3).equals("aba")) {
            return 1 + countAbc(str.substring(1));
        }
        return countAbc(str.substring(1));
    }

    /*
    Given a string,
    compute recursively (no loops) the number of "11" substrings in the string.
    The "11" substrings should not overlap.

    count11("11abc11") → 2
    count11("abc11x11x11") → 3
    count11("111") → 1
     */
    static int count11(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("11")) {
            return 1 + count11(str.substring(2));
        }
        return count11(str.substring(1));
    }

    /*
    Given a string,
    return recursively a "cleaned" string
    where adjacent chars that are the same have been reduced to a single char.
    So "yyzzza" yields "yza".

    stringClean("yyzzza") → "yza"
    stringClean("abbbcdd") → "abcd"
    stringClean("Hello") → "Helo"
     */
    static String stringClean(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));
        return str.charAt(0) + stringClean(str.substring(1));
    }

    /*
    Given a string,
    compute recursively the number of times lowercase "hi" appears in the string,
    however do not count "hi" that have an 'x' immedately before them.

    countHi2("ahixhi") → 1
    countHi2("ahibhi") → 2
    countHi2("xhixhi") → 0
     */
    static int countHi2(String str) {
        if (str.length() < 2) return 0;
        if (str.charAt(0) == 'x' && str.charAt(1) != 'x') return countHi2(str.substring(2));
        if (str.substring(0, 2).equals("hi")) return 1 + countHi2(str.substring(1));
        return countHi2(str.substring(1));
    }

    /*
    Given a string that contains a single pair of parenthesis,
    compute recursively a new string made of only of the parenthesis and their contents,
    so "xyz(abc)123" yields "(abc)".

    parenBit("xyz(abc)123") → "(abc)"
    parenBit("x(hello)") → "(hello)"
    parenBit("(xy)1") → "(xy)"
     */
    static String parenBit(String str) {
        if (str.charAt(0) != '(') {
            return parenBit(str.substring(1));
        }
        if (str.charAt(str.length()-1) != ')') {
            return parenBit(str.substring(0, str.length()-1));
        }
        return str;
    }

    /*
    Given a string,
    return true if it is a nesting of zero or more pairs of parenthesis,
    like "(())" or "((()))".
    Suggestion: check the first and last chars,
    and then recur on what's inside them.

    nestParen("(())") → true
    nestParen("((()))") → true
    nestParen("(((x))") → false
     */
    static boolean nestParen(String str) {
        if (str.length() == 0) return true;
        if (str.length() == 1) return false;
        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return nestParen(str.substring(1, str.length()-1));
        } else if (str.charAt(0) == '(') {
            return nestParen(str.substring(0, str.length()-1));
        } else if (str.charAt(str.length()-1) == ')') {
            return nestParen(str.substring(1));
        }
        return nestParen(str.substring(1));
    }

    /*
    Given a string and a non-empty substring sub,
    compute recursively the number of times that sub appears in the string,
    without the sub strings overlapping.

    strCount("catcowcat", "cat") → 2
    strCount("catcowcat", "cow") → 1
    strCount("catcowcat", "dog") → 0
     */
    static int strCount(String str, String sub) {
        if (str.length() < sub.length()) return 0;
        if (str.substring(0, sub.length()).equals(sub)) {
            return 1 + strCount(str.substring(sub.length()), sub);
        }
        return strCount(str.substring(1), sub);
    }

    /*
    Given a string and a non-empty substring sub,
    compute recursively if at least n copies of sub appear in the string somewhere,
    possibly with overlapping. N will be non-negative.

    strCopies("catcowcat", "cat", 2) → true
    strCopies("catcowcat", "cow", 2) → false
    strCopies("catcowcat", "cow", 1) → true
     */
    static boolean strCopies(String str, String sub, int n) {
        if (str.length() < sub.length()) {
            return n == 0;
        } else if (str.substring(0, sub.length()).equals(sub)) {
            return strCopies(str.substring(1), sub, n-1);
        }
        return strCopies(str.substring(1), sub, n);
    }

    /*
    Given a string and a non-empty substring sub,
    compute recursively the largest substring
    which starts and ends with sub and return its length.

    strDist("catcowcat", "cat") → 9
    strDist("catcowcat", "cow") → 3
    strDist("cccatcowcatxx", "cat") → 9
     */
    static int strDist(String str, String sub) {
//        print(str);
        if (str.length() < sub.length()) {
            return 0;
        }
        if (str.substring(0, sub.length()).equals(sub)
                && str.substring(str.length()-sub.length()).equals(sub)) {
            return str.length();
        }
        if (str.substring(0, sub.length()).equals(sub)) {
            return strDist(str.substring(0, str.length()-1), sub);
        }
        if (str.substring(str.length()-sub.length(), str.length()).equals(sub)) {
            return strDist(str.substring(1), sub);
        }
        return strDist(str.substring(1), sub);
    }



    public static void main(String[] args) {

        // countPairs:
        print();
        print(" countPairs: \n" +
                "1 : " + countPairs("axa") + "\n" +
                "2 : " + countPairs("axax") + "\n" +
                "1 : " + countPairs("axbx") + "\n");

        // countAbc:
        print();
        print(" countAbc: \n" +
                "1 : " + countAbc("abc") + "\n" +
                "2 : " + countAbc("abcxxabc") + "\n" +
                "2 : " + countAbc("abaxxaba") + "\n");

        // count11:
        print();
        print(" count11: \n" +
                "2 : " + count11("11abc11") + "\n" +
                "3 : " + count11("abc11x11x11") + "\n" +
                "1 : " + count11("111") + "\n");

        // stringClean:
        print();
        print(" noX: \n" +
                "yza : " + stringClean("yyzzza") + "\n" +
                "abcd : " + stringClean("abbbcdd") + "\n" +
                "Helo : " + stringClean("Hello") + "\n");

        // countHi2:
        print();
        print(" countHi2: \n" +
                "1 : " + countHi2("ahixhi") + "\n" +
                "2 : " + countHi2("ahibhi") + "\n" +
                "0 : " + countHi2("xhixhi") + "\n");

        // parenBit:
        print();
        print(" parenBit: \n" +
                "(abc) : " + parenBit("xyz(abc)123") + "\n" +
                "(hello) : " + parenBit("x(hello)") + "\n" +
                "(xy) : " + parenBit("(xy)1") + "\n");

        // nestParen:
        print();
        print(" nestParen: \n" +
                "True : " + nestParen("(())") + "\n" +
                "True : " + nestParen("((()))") + "\n" +
                "False : " + nestParen("(((x))") + "\n" +
                "False : " + nestParen("(yy)") + "\n");

        // strCount:
        print();
        print(" strCount: \n" +
                "2 : " + strCount("catcowcat", "cat") + "\n" +
                "1 : " + strCount("catcowcat", "cow") + "\n" +
                "0 : " + strCount("catcowcat", "dog") + "\n" +
                "2 : " + strCount("iiiijj", "ii") + "\n");


        // strCopies:
        print();
        print(" strCopies: \n" +
                "True : " + strCopies("catcowcat", "cat", 2) + "\n" +
                "False : " + strCopies("catcowcat", "cow", 2) + "\n" +
                "True : " + strCopies("catcowcat", "cow", 1) + "\n");

        // strDist:
        print();
        print(" strDist: \n" +
                "9 : " + strDist("catcowcat", "cat") + "\n" +
                "3 : " + strDist("catcowcat", "cow") + "\n" +
                "9 : " + strDist("cccatcowcatxx", "cat") + "\n");

    }

}
