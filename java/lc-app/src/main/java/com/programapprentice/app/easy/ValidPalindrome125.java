package com.programapprentice.app.easy;

public class ValidPalindrome125 {
    /**
     [125] Valid Palindrome

     https://leetcode.com/problems/valid-palindrome

     Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     For example,
     "A man, a plan, a canal: Panama" is a palindrome.
     "race a car" is not a palindrome.

     Note:
     Have you consider that the string might be empty? This is a good question to ask during an interview.

     For the purpose of this problem, we define empty string as valid palindrome.
     * */

    public boolean isAlphaNumeric(char c) {
        if(c >= '0' && c <= '9') {
            return true;
        }
        if(c >= 'a' && c <= 'z') {
            return true;
        }
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
    public int removeUnAlphaneric(char[] cs) {
        int j = 0;
        int i = -1;
        while(j < cs.length) {
            if(isAlphaNumeric(cs[j])) {
                cs[i+1] = cs[j];
                i++;
            }
            j++;
        }
        return i+1;
    }

    public boolean isPalindrome(String s) {
        if(s == null && s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        char[] cs = s.toCharArray();
        int realLength = removeUnAlphaneric(cs);
        if(realLength == 0) {
            return true;
        }
        int start = 0;
        int end = realLength - 1;


        while(start < end) {
            if(cs[start] != cs[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
