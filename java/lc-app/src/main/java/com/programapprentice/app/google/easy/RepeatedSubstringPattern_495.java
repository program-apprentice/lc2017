package com.programapprentice.app.google.easy;

public class RepeatedSubstringPattern_495 {
    /**
     https://leetcode.com/problems/repeated-substring-pattern/description/
     Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

     Example 1:
     Input: "abab"

     Output: True

     Explanation: It's the substring "ab" twice.
     Example 2:
     Input: "aba"

     Output: False
     Example 3:
     Input: "abcabcabcabc"

     Output: True

     Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     * */

    public boolean isValid(String s, String sub) {
        int n = s.length();
        int times = n/sub.length();
        int start = 0;
        for(int i = 0; i < times; i++) {
            for(int j = 0; j < sub.length(); j++) {
                if (s.charAt(start + j) != sub.charAt(j)) {
                    return false;
                }
            }
            start += sub.length();
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = 1; i < n; i++) {
            if (n % i == 0) {
                if (isValid(s, s.substring(0, i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
