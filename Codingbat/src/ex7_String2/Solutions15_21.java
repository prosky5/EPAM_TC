package ex7_String2;

import static utils.Print.*;

@SuppressWarnings("WeakerAccess")
public class Solutions15_21 {

    /*
    A sandwich is two pieces of bread with something in between.
    Return the string that is between the first and last appearance of "bread"
    in the given string, or return the empty string ""
    if there are not two pieces of bread.

    getSandwich("breadjambread") → "jam"
    getSandwich("xxbreadjambreadyy") → "jam"
    getSandwich("xxbreadyy") → ""
     */
    static String getSandwich(String str) {
        StringBuilder res = new StringBuilder();
        int firstBread = -1;
        int lastBread = -1;
        for (int i = 0; i < str.length() - 4; i++) {
            if (str.substring(i, i + 5).equals("bread")) {
                lastBread = i;
                if (firstBread == -1) {
                    firstBread = i;
                    i += 5;
                }
            }
        }
        if (firstBread == lastBread) {
            return "";
        }
        return res.append(str.substring(firstBread+5, lastBread)).toString();
    }

    /*
    Returns true if for every '*' (star) in the string,
    if there are chars both immediately before and after the star,
    they are the same.

    sameStarChar("xy*yzz") → true
    sameStarChar("xy*zzz") → false
    sameStarChar("*xa*az") → true
     */
    static boolean sameStarChar(String str) {
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i-1) != str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    /*
    Given a string,
    compute a new string by moving the first char to come
    after the next two chars, so "abc" yields "bca".
    Repeat this process for each subsequent group of 3 chars,
    so "abcdef" yields "bcaefd".
    Ignore any group of fewer than 3 chars at the end.

    oneTwo("abc") → "bca"
    oneTwo("tca") → "cat"
    oneTwo("tcagdo") → "catdog"
     */
    static String oneTwo(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i +=3) {
            if (i+3 > str.length()) {
//                res.append(str.substring(i));
                return res.toString();
            }
            res.append(str.charAt(i+1)).
                    append(str.charAt(i+2)).
                    append(str.charAt(i));
        }
        return res.toString();
    }

    /*
    Look for patterns like "zip" and "zap" in the string -- length-3,
    starting with 'z' and ending with 'p'.
    Return a string where for all such words, the middle letter is gone,
    so "zipXzap" yields "zpXzp".

    zipZap("zipXzap") → "zpXzp"
    zipZap("zopzop") → "zpzp"
    zipZap("zzzopzop") → "zzzpzp"
     */
    static String zipZap(String str) {
        if (str.length() < 3) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        res.append(str);

        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == 'z' && res.charAt(i+2) == 'p') {
                res.deleteCharAt(i+1);
            }
        }
        return res.toString();
    }

    /*
    Return a version of the given string,
    where for every star (*) in the string the star
    and the chars immediately to its left and right are gone.
    So "ab*cd" yields "ad" and "ab**cd" also yields "ad".

    starOut("ab*cd") → "ad"
    starOut("ab**cd") → "ad"
    starOut("sm*eilly") → "silly"
     */
    static String starOut(String str) {
        StringBuilder res = new StringBuilder();
        res.append(str);

        int startDel = -1;
        int endDel = -1;
        for (int i = 0; i < res.length(); i++) {
//            print(res.toString());
            if (res.charAt(i) == '*') {
                startDel = i-1 < 0 ? i : i-1;
                endDel = i+1;
                while (i+1 < res.length() && res.charAt(i+1) == '*') {
                    endDel++;
                    i++;
                }
                res.delete(startDel, endDel+1);
                i -= endDel - startDel;
            }
        }
        return res.toString();
    }

    /*
    Given a string and a non-empty word string,
    return a version of the original String
    where all chars have been replaced by pluses ("+"),
    except for appearances of the word string which are preserved unchanged.

    plusOut("12xy34", "xy") → "++xy++"
    plusOut("12xy34", "1") → "1+++++"
    plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
     */
    static String plusOut(String str, String word) {
        if (str.equals(word)) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (; i < str.length() - word.length(); i++) {
//            print(str.substring(i, i + word.length()));
            if (str.substring(i, i + word.length()).equals(word)) {
                res.append(str.substring(i, i + word.length()));
                i += word.length()-1;
            } else {
                res.append('+');
            }
        }
        if (str.substring(i, str.length()).equals(word)) {
            res.append(word);
        } else {
            while (i < str.length()) {
                res.append('+');
                i++;
            }
        }
        return res.toString();
    }

    /*
    Given a string and a non-empty word string,
    return a string made of each char just before
    and just after every appearance of the word in the string.
    Ignore cases where there is no char before or after the word,
    and a char may be included twice if it is between two words.

    wordEnds("abcXY123XYijk", "XY") → "c13i"
    wordEnds("XY123XY", "XY") → "13"
    wordEnds("XY1XY", "XY") → "11"
     */
    static String wordEnds(String str, String word) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length() - word.length()+1; i++) {
            if (str.substring(i, i + word.length()).equals(word)) {
                if (i-1 >= 0) {
                    res.append(str.charAt(i-1));
                }
                if (i + word.length() < str.length()) {
                    res.append(str.charAt(i + word.length()));
                }
            }
        }
        return res.toString();
    }




    public static void main(String[] args) {

        // GetSandwich:
        print(" GetSandwich:");
        print("jam : " + getSandwich("breadjambread"));
        print("jam : " + getSandwich("breadjambread"));
        print(" : " + getSandwich("xxbreadyy"));
        print("breadbreadbread : " + getSandwich("breadbreadbreadbreadbread"));

        print();
        // SameStarChar:
        print(" SameStarChar:");
        print("True : " + sameStarChar("xy*yzz"));
        print("False : " + sameStarChar("xy*zzz"));
        print("True : " + sameStarChar("*xa*az"));

        print();
        // OneTwo:
        print(" OneTwo:");
        print("bca : " + oneTwo("abc"));
        print("cat : " + oneTwo("tca"));
        print("catdog : " + oneTwo("tcagdo"));

        print();
        // ZipZap:
        print(" ZipZap:");
        print("zpXzp : " + zipZap("zipXzap"));
        print("zpzp : " + zipZap("zopzop"));
        print("zzzpzp : " + zipZap("zzzopzop"));
        print("azbcpzp : " + zipZap("azbcpzpp"));

        print();
        // StarOut:
        print(" StarOut:");
        print("ad : " + starOut("ab*cd"));
        print("ad : " + starOut("ab**cd"));
        print("silly : " + starOut("sm*eilly"));
        print("abc : " + starOut("*cabca*"));
        print("siy : " + starOut("sm***eil*ly"));

        print();
        // PlusOut:
        print(" PlusOut:");
        print("++xy++ : " + plusOut("12xy34", "xy"));
        print("1+++++ : " + plusOut("12xy34", "1"));
        print("++xy++xy+++xy : " + plusOut("12xy34xyabcxy", "xy"));

        print();
        // WordEnds:
        print(" WordEnds:");
        print("c13i : " + wordEnds("abcXY123XYijk", "XY"));
        print("13 : " + wordEnds("XY123XY", "XY"));
        print("11 : " + wordEnds("XY1XY", "XY"));
        print("XY : " + wordEnds("XYXY", "XY"));
    }
}
