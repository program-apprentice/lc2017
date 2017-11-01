package com.programapprentice.app.facebook.easy;

public class ValidAnagram_242 {
    /**
     [242] Valid Anagram

     https://leetcode.com/problems/valid-anagram

     Given two strings s and t, write a function to determine if t is an anagram of s.

     For example,
     s = "anagram", t = "nagaram", return true.
     s = "rat", t = "car", return false.

     Note:
     You may assume the string contains only lowercase alphabets.

     Follow up:
     What if the inputs contain unicode characters? How would you adapt your solution to such case?
    * */

    public int[] getDict(String s) {
        int[] sdict = new int[26];
        for(char c : s.toCharArray()) {
            if (c != ' ') {
                sdict[c - 'a'] ++;
            }
        }
        return sdict;
    }

    public boolean isAnagram(String s, String t) {
        int[] sdict = getDict(s);
        int[] tdict = getDict(t);
        for(int i = 0; i < 26; i++) {
            if (sdict[i] != tdict[i]) {
                return  false;
            }
        }
        return true;
    }
}
