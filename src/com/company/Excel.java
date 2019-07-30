package com.company;
/*
168. Excel Sheet Column Title
        Easy
        Given a positive integer, return its corresponding column title as appear in an Excel sheet.

        For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
        ...
        Example 1:

        Input: 1
        Output: "A"
        Example 2:

        Input: 28
        Output: "AB"
        Example 3:

        Input: 701
        Output: "ZY"

*/
public class Excel {
    public String Excel(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int r = n % 26;
            n = n/26;
            if (r != 0){
                sb.append((char)(r - 1 + 'A'));
            } else {
                sb.append('Z');
                n--;
            }

        }
        return sb.reverse().toString();
    }
}
/*
Two key things. First, we need to understand how to use StringBuilder to save the memory.(use reverse to save runtime)
Second, we need to understand the best way to convert a integer to a character by UTF-8.
'A' -> 65
 */