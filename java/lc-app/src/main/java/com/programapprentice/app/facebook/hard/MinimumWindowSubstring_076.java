package com.programapprentice.app.facebook.hard;

import java.util.*;

public class MinimumWindowSubstring_076 {
    /**
     https://leetcode.com/problems/minimum-window-substring/description/
     Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

     For example,
     S = "ADOBECODEBANC"
     T = "ABC"
     Minimum window is "BANC".

     Note:
     If there is no such window in S that covers all characters in T, return the empty string "".

     If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     * */
    private int findNextStart(Map<Character, List<Integer>> map) {
        int result = Integer.MAX_VALUE;
        for(Character key : map.keySet()) {
            for(Integer i : map.get(key)) {
                result = Math.min(result, i);
            }
        }
        return result;
    }

    public boolean isValid(Map<Character, List<Integer>> charToIndex, Map<Character, Integer> destination) {
        for(Character c : destination.keySet()) {
            if (charToIndex.get(c) == null) {
                return false;
            }
            if (!destination.get(c).equals(charToIndex.get(c).size())) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        Map<Character, List<Integer>> charToIndex = new HashMap<Character, List<Integer>>();
        Map<Character, Integer> destination = new HashMap<Character, Integer>();
        for(Character c : t.toCharArray()) {
            int count = destination.get(c) == null ? 1 : destination.get(c) + 1;
            destination.put(c, count);
        }
        int start = 0;
        int end = 0;
        String result = "";
        int minLength = Integer.MAX_VALUE;
        int counter = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = i;
            if (destination.containsKey(c)) {
                if (charToIndex.containsKey(c)) {
                    List<Integer> indexes = charToIndex.get(c);
                    int targetedCount = destination.get(c);
                    if (targetedCount == indexes.size()) {
                        indexes.remove(0);
                    }
                    indexes.add(i);
                    charToIndex.put(c, indexes);
                    if (isValid(charToIndex, destination)) {
                        start = findNextStart(charToIndex);
                        if (end - start + 1 < minLength) {
                            result = s.substring(start, end + 1);
                            minLength = result.length();
                        }
                    }
                } else {
                    List<Integer> indexes = new ArrayList<Integer>();
                    indexes.add(i);
                    charToIndex.put(c, indexes);
                    if (isValid(charToIndex, destination)) {
                        start = findNextStart(charToIndex);
                        result = s.substring(start, end+1);
                        minLength = result.length();
                    }
                }
            }
        }
        return result;
    }
}
