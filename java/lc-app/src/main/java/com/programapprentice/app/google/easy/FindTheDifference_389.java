package com.programapprentice.app.google.easy;

public class FindTheDifference_389 {
    /**
     https://leetcode.com/problems/find-the-difference/description/
     Given two strings s and t which consist of only lowercase letters.

     String t is generated by random shuffling string s and then add one more letter at a random position.

     Find the letter that was added in t.

     Example:

     Input:
     s = "abcd"
     t = "abcde"

     Output:
     e

     Explanation:
     'e' is the letter that was added.
     * */
    public char findTheDifference(String s, String t) {
        int[] sCounter = new int[26];
        int[] tCounter = new int[26];
        for(char c : s.toCharArray()) {
            sCounter[c - 'a'] ++;
        }
        for(char c : t.toCharArray()) {
            tCounter[c - 'a'] ++;
        }
        char c = ' ';
        for(int i = 0; i < 26; i++) {
            if (tCounter[i] != sCounter[i]) {
                c = (char)(i + 'a');
                break;
            }
        }
        return c;
    }
}
