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

    public String minWindow(String s, String t) {
        Map<Character, List<Integer>> charToIndex = new HashMap<Character, List<Integer>>();
        Map<Character, Integer> destination = new HashMap<Character, Integer>();
        PriorityQueue<Integer> indexHeap = new PriorityQueue<Integer>();
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
                        indexHeap.remove(indexes.get(0));
                        indexes.remove(0);
                        counter--;
                    }
                    counter++;
                    indexes.add(i);
                    indexHeap.add(i);
                    charToIndex.put(c, indexes);
                    if (counter == t.length()) {
                        start = indexHeap.peek();
                        if (end - start + 1 < minLength) {
                            result = s.substring(start, end + 1);
                            minLength = result.length();
                        }
                    }
                } else {
                    List<Integer> indexes = new ArrayList<Integer>();
                    indexes.add(i);
                    charToIndex.put(c, indexes);
                    counter++;
                    indexHeap.add(i);
                    if (counter == t.length()) {
                        start = indexHeap.peek();
                        result = s.substring(start, end+1);
                        minLength = result.length();
                    }
                }
            }
        }
        return result;
    }
}
