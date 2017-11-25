package com.programapprentice.app.google.easy;

import java.util.HashMap;

public class LongestPalindrome_409 {
    /**
     https://leetcode.com/problems/longest-palindrome/description/
     * */
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(Character c : s.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) + 1 : 1;
            map.put(c, count);
        }

        boolean hasOdd = false;
        int max = 0;
        for(Character key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 == 1) {
                hasOdd = true;
            }
            max += (count / 2) * 2;
        }
        if (hasOdd) {
            return max + 1;
        }
        return max;
    }
}
