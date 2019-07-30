package com.company;

/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.



Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings.
 The character sequence represented by this String object is compared lexicographically to the character sequence
  represented by the argument string. The result is a negative integer if this String object lexicographically precedes
   the argument string. The result is a positive integer if this String object lexicographically follows the argument
    string. The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method
     would return true.

    KEY THING:
    ----This is the definition of lexicographic ordering. If two strings are different,
     then either they have different characters at some index that is a valid index for both strings, or
      their lengths are different, or both. If they have different characters at one or more index positions,
       let k be the smallest such index; then the string whose character at position k has the smaller value,
        as determined by using the < operator, lexicographically precedes the other string. In this case, compareTo
         returns the difference of the two character values at position k in the two string -- that is, the value.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String min = strs[0];
        String max = strs[0];
        for (String current : strs) {
            if (current.compareTo(max) > 0) {
                max = current;
            } else if (current.compareTo(min) < 0) {
                min = current;
            }
        }

        int num = 0;
        for (int i = 0; i < min.length() && i < max.length(); i++) {
            if (min.charAt(i) != max.charAt(i)) {
                break;
            }
            num++;
        }
        return min.substring(0, num);
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length < 1) {
            return("");
        } else if (strs.length == 1) {
            return(strs[0]);
        }
        int sho = strs[0].length();
        for(String a: strs) {
            if(a.length() < sho) {
                sho = a.length();
            }
        }
        String res = "";
        for(int i = 0; i < sho; i++) {
            char a = strs[0].charAt(i);
            for(String k : strs) {
                if(k.charAt(i) != a) {
                    return res;
                }
            }
            res += a;
        }
        return res;
    }
}
