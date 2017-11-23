package com.programapprentice.app.google.easy;

public class ReverseStringII_541 {
    /**
     https://leetcode.com/problems/reverse-string-ii/description/
     Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
     the start of the string. If there are less than k characters left, reverse all of them.
     If there are less than 2k but greater than or equal to k characters,
     then reverse the first k characters and left the other as original.

     Example:
     Input: s = "abcdefg", k = 2
     Output: "bacdfeg"
     Restrictions:
     The string consists of lower English letters only.
     Length of the given string and k will in the range [1, 10000]

     * */
    public void reverse(char[] input, int start, int end) {
        while(start < end) {
            char t = input[start];
            input[start] = input[end];
            input[end] = t;
            end--;
            start++;
        }
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start = 0;
        int n = s.length();
        while(start < n) {
            if (start+k-1 < n) {
                reverse(chars, start, start + k - 1);
            } else {
                reverse(chars, start, n-1);
            }
            start += 2*k;
        }
        return new String(chars);
    }
}
