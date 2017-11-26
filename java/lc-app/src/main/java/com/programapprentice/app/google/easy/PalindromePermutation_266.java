package com.programapprentice.app.google.easy;

import java.util.HashMap;

public class PalindromePermutation_266 {
    /**
     https://leetcode.com/problems/palindrome-permutation/description/
     * */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : s.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) + 1 : 1;
            map.put(c, count);
        }
        boolean hasOdd = false;
        for(Character key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 == 1) {
                if (hasOdd) {
                    return false;
                }
                hasOdd = true;
            }
        }
        return true;
    }
}
