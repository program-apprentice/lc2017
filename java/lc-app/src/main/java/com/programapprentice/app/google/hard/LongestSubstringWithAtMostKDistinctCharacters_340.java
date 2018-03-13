package com.programapprentice.app.google.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    /**
     https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
     Given a string, find the length of the longest substring T that contains at most k distinct characters.

     For example, Given s = “eceba” and k = 2,

     T is "ece" which its length is 3.

     Solution:
     http://www.cnblogs.com/grandyang/p/5351347.html
     * */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charToIdx = new HashMap<Character, Integer>();
        int result = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            charToIdx.put(s.charAt(i), i);
            while (charToIdx.keySet().size() > k) {
                if (charToIdx.get(s.charAt(left)) == left) {
                    charToIdx.remove(s.charAt(left));
                }
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
