package com.programapprentice.app.easy;

public class ValidPalindromeII_680 {
    /**
     [680] Valid Palindrome II

     https://leetcode.com/problems/valid-palindrome-ii

     Given a non-empty string s, you may delete at most one character.  Judge whether you can make it a palindrome.

     Example 1:

     Input: "aba"
     Output: True

     Example 2:

     Input: "abca"
     Output: True
     Explanation: You could delete the character 'c'.

     Note:

     The string will only contain lowercase characters a-z.
     The maximum length of the string is 50000.
     * */

    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        boolean res = isPalindrom(s);
        if (res) {
            return true;
        }

        char[] cs = s.toCharArray();
        boolean skipped = false;
        int beg = 0;
        int end = cs.length-1;
        while(beg < end) {
            if (cs[beg] != cs[end]) {
                if (skipped) {
                    break;
                }
                skipped = true;
                beg++;
                continue;
            }
            beg++;
            end--;
        }
        if(beg >= end) {
            return true;
        }

        beg = 0;
        end = cs.length-1;
        skipped = false;
        while(beg < end) {
            if (cs[beg] != cs[end]) {
                if (skipped) {
                    return false;
                }
                skipped = true;
                end--;
                continue;
            }
            beg++;
            end--;
        }

        if(beg >= end) {
            return true;
        }
        return false;
    }

    public boolean isPalindrom(String s) {
        char[] cs = s.toCharArray();
        int beg = 0;
        int end = s.length()-1;
        while(beg < end) {
            if (cs[beg] != cs[end]) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }

}
