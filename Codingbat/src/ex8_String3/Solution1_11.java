package ex8_String3;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solution1_11 {

    /*
    Given a string, count the number of words ending in 'y' or 'z' --
    so the 'y' in "heavy" and the 'z' in "fez" count,
    but not the 'y' in "yellow" (not case sensitive).
    We'll say that a y or z is at the end of a word
    if there is not an alphabetic letter immediately following it.
    (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)

    countYZ("fez day") → 2
    countYZ("day fez") → 2
    countYZ("day fyyyz") → 2
     */
    static int countYZ(String str) {
        str = str.toLowerCase();
        int count = 0;

        for (int i = 0; i < str.length()-1; i++) {
            if ( (str.charAt(i) == 'y' || str.charAt(i) == 'z')
                    && !Character.isLetter(str.charAt(i+1))) {
                count++;
            }
        }
        if (str.endsWith("y") || str.endsWith("z")) {
            count++;
        }
        return count;
    }

    /*
    Given two strings, base and remove,
    return a version of the base string
    where all instances of the remove string have been removed (not case sensitive).
    You may assume that the remove string is length 1 or more.
    Remove only non-overlapping instances,
    so with "xxx" removing "xx" leaves "x".

    withoutString("Hello there", "llo") → "He there"
    withoutString("Hello there", "e") → "Hllo thr"
    withoutString("Hello there", "x") → "Hello there"
     */
    static String withoutString(String base, String remove) {
        StringBuilder res = new StringBuilder();

        int bLen = base.length();
        int rLen = remove.length();

        for (int i = 0; i < bLen; i++) {
            if (i <= bLen - rLen) {
                String tmp = base.substring(i, i + rLen);
                if ( tmp.equalsIgnoreCase(remove) ) {
                    i += rLen - 1;
                } else {
                    res.append(base.charAt(i));
                }
            } else {
                res.append(base.charAt(i));
            }
        }
        return res.toString();
    }

    /*
    Given a string,
    return true if the number of appearances of "is"
    anywhere in the string is equal to the number of appearances of "not"
    anywhere in the string (case sensitive).

    equalIsNot("This is not") → false
    equalIsNot("This is notnot") → true
    equalIsNot("noisxxnotyynotxisi") → true
     */
    static boolean equalIsNot(String str) {
        int countNot = 0;
        int countIs = 0;

        for (int i = 0; i < str.length(); i++) {
//            print(countIs + " - " + countNot);
            if (i < str.length() - 2) {
                String tmp = str.substring(i, i+3);
                if ( tmp.equals("not")) {
                    countNot++;
                }
            }
            if ( i < str.length() - 1) {
                String tmp = str.substring(i, i+2);
                if ( tmp.equals("is")) {
                    countIs++;
                }
            }
        }
        return countIs == countNot;
    }

    /*
    We'll say that a lowercase 'g' in a string is "happy"
    if there is another 'g' immediately to its left or right.
    Return true if all the g's in the given string are happy.

    gHappy("xxggxx") → true
    gHappy("xxgxx") → false
    gHappy("xxggyygxx") → false
     */
    static boolean gHappy(String str) {
        if (str.length() < 1) {
            return true;
        } else if (str.equals("g")) {
            return false;
        }
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i)== 'g') {
                if (i < str.length()-1 && tmp != 'g' && str.charAt(i+1) != 'g') {
                    return false;
                } else if (i == str.length()-1 && tmp != 'g') {
                    return false;
                }
            }
            tmp = str.charAt(i);
        }
        return true;
//        str = "x" + str + "x";
//        for (int i = 1; i < str.length(); i++) {
//            if (str.substring(i,i+1).equals("g") && str.substring(i-1,i+2).indexOf("gg") == -1)
//                return false;
//        }
//        return true;
    }

    /*
    We'll say that a "triple" in a string
    is a char appearing three times in a row.
    Return the number of triples in the given string.
    The triples may overlap.

    countTriple("abcXXXabc") → 1
    countTriple("xxxabyyyycd") → 3
    countTriple("a") → 0
     */
    static int countTriple(String str) {
        int count = 0;
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i-1)
                    && str.charAt(i) == str.charAt(i+1)) {
                count++;
            }
        }
        return count;
    }

    /*
    Given a string,
    return the sum of the digits 0-9 that appear in the string,
    ignoring all other characters.
    Return 0 if there are no digits in the string.
    (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
    Integer.parseInt(string) converts a string to an int.)

    sumDigits("aa1bc2d3") → 6
    sumDigits("aa11b33") → 8
    sumDigits("Chocolate") → 0
     */
    static int sumDigits(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                res += Integer.parseInt(str.substring(i, i+1));
            }
        }
        return res;
    }

    /*
    Given a string,
    return the longest substring that appears at both
    the beginning and end of the string without overlapping.
    For example, sameEnds("abXab") is "ab".

    sameEnds("abXYab") → "ab"
    sameEnds("xx") → "x"
    sameEnds("xxx") → "x"
     */
    static String sameEnds(String string) {
        String res = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.endsWith(string.substring(0, i+1))
                    && i < string.length() - 1 - i) {
                res = string.substring(0, i+1);
            }
        }
        return res;
    }

    /*
    Given a string,
    look for a mirror image (backwards) string at both the beginning
    and end of the given string.
    In other words, zero or more characters at the very begining of the given string,
    and at the very end of the string in reverse order
    (possibly overlapping).
    For example, the string "abXYZba" has the mirror end "ab".

    mirrorEnds("abXYZba") → "ab"
    mirrorEnds("abca") → "a"
    mirrorEnds("aba") → "aba"
     */
    static String mirrorEnds(String string) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(string.length()-1 - i)) {
                res.append(string.charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }

    /*
    Given a string,
    return the length of the largest "block" in the string.
    A block is a run of adjacent chars that are the same.

    maxBlock("hoopla") → 2
    maxBlock("abbCCCddBBBxx") → 3
    maxBlock("") → 0
     */
    static int maxBlock(String str) {
        int res = 0;
        int tmp = 1;
        for (int i = 1; i < str.length(); i++) {
//            print(tmp + " : " + str.charAt(i-1) + " " + str.charAt(i) + " : " + res);
            if (str.charAt(i) == str.charAt(i-1)) {
                tmp++;
            } else {
                tmp = 1;
            }
            if (tmp > res) {
                res = tmp;
            }
        }
//        print();
        return res;
    }

    /*
    Given a string,
    return the sum of the numbers appearing in the string,
    ignoring all other characters.
    A number is a series of 1 or more digit chars in a row.
    (Note: Character.isDigit(char) tests if a char
    is one of the chars '0', '1', .. '9'.
    Integer.parseInt(string) converts a string to an int.)

    sumNumbers("abc123xyz") → 123
    sumNumbers("aa11b33") → 44
    sumNumbers("7 11") → 18
     */
    static int sumNumbers(String str) {
        int res = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (i < str.length() - 1 && Character.isDigit(str.charAt(i + 1))) {
                    tmp.append(str.charAt(i));
                } else {
                    tmp.append(str.charAt(i));
                    res += Integer.parseInt(tmp.toString());
                    tmp.delete(0, tmp.length());
                }
            }
        }
        return res;
    }

    /*
    Given a string,
    return a string where every appearance of the lowercase word "is"
    has been replaced with "is not".
    The word "is" should not be immediately preceeded or followed by a letter --
    so for example the "is" in "this" does not count.
    (Note: Character.isLetter(char) tests if a char is a letter.)

    notReplace("is test") → "is not test"
    notReplace("is-is") → "is not-is not"
    notReplace("This is right") → "This is not right"
     */
    static String notReplace(String str) {
        StringBuilder res = new StringBuilder(str);
        for (int i = 0; i < res.length()-1; i++) {
            if ((i == 0 || !Character.isLetter(res.charAt(i-1)))
                    && res.substring(i).startsWith("is") &&
                    (i == res.length()-2 || !Character.isLetter(res.charAt(i+2)))) {
                res.replace(i, i+2, "is not");
                i += 5;
            }
        }
        return res.toString();
    }



    public static void main(String[] args) {
        // countYZ:
        print();
        print(" countYZ: \n" +
                "2 : " + countYZ("fez day") + "\n" +
                "2 : " + countYZ("day fez") + "\n" +
                "2 : " + countYZ("day fyyyz") + "\n");

        // withoutString:
        print();
        print(" withoutString: \n" +
                "He there : " + withoutString("Hello there", "llo") + "\n" +
                "Hllo thr : " + withoutString("Hello there", "e") + "\n" +
                "Hello there : " + withoutString("Hello there", "x") + "\n" +
                "x : " + withoutString("xxx", "xx") + "\n" +
                " : " + withoutString("xxx", "x") + "\n");

        // equalIsNot:
        print();
        print(" equalIsNot: \n" +
                "False : " + equalIsNot("This is not") + "\n" +
                "True : " + equalIsNot("This is notnot") + "\n" +
                "True : " + equalIsNot("noisxxnotyynotxisi") + "\n");

        // gHappy:
        print();
        print(" gHappy: \n" +
                "True : " + gHappy("xxggxx") + "\n" +
                "False : " + gHappy("xxgxx") + "\n" +
                "False : " + gHappy("xxggyygxx") + "\n" +
                "False : " + gHappy("g") + "\n" +
                "True : " + gHappy("") + "\n");

        // countTriple:
        print();
        print(" countTriple: \n" +
                "1 : " + countTriple("abcXXXabc") + "\n" +
                "3 : " + countTriple("xxxabyyyycd") + "\n" +
                "0 : " + countTriple("a") + "\n");

        // sumDigits:
        print();
        print(" sumDigits: \n" +
                "6 : " + sumDigits("aa1bc2d3") + "\n" +
                "8 : " + sumDigits("aa11b33") + "\n" +
                "0 : " + sumDigits("Chocolate") + "\n");

        // sameEnds:
        print();
        print(" sameEnds: \n" +
                "ab : " + sameEnds("abXYab") + "\n" +
                "x : " + sameEnds("xx") + "\n" +
                "x : " + sameEnds("xxx") + "\n");

        // mirrorEnds:
        print();
        print(" mirrorEnds: \n" +
                "ab : " + mirrorEnds("abXYZba") + "\n" +
                "a : " + mirrorEnds("abca") + "\n" +
                "aba : " + mirrorEnds("aba") + "\n");

        // maxBlock:
        print();
        print(" maxBlock: \n" +
                "2 : " + maxBlock("hoopla") + "\n" +
                "3 : " + maxBlock("abbCCCddBBBxx") + "\n" +
                "0 : " + maxBlock("") + "\n");

        // sumNumbers:
        print();
        print(" sumNumbers: \n" +
                "123 : " + sumNumbers("abc123xyz") + "\n" +
                "44 : " + sumNumbers("aa11b33") + "\n" +
                "18 : " + sumNumbers("7 11") + "\n");

        // notReplace:
        print();
        print(" notReplace: \n" +
                "is not test : " + notReplace("is test") + "\n" +
                "is not-is not : " + notReplace("is-is") + "\n" +
                "This is not right : " + notReplace("This is right") + "\n");

    }
}
