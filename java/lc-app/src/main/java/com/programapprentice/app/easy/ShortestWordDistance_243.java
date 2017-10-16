package com.programapprentice.app.easy;

import java.util.ArrayList;
import java.util.List;

public class ShortestWordDistance_243 {
    /**
     [243] Shortest Word Distance

     https://leetcode.com/problems/shortest-word-distance

     Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “coding”, word2 = “practice”, return 3.
     Given word1 = "makes", word2 = "coding", return 1.

     Note:
     You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

    * */

    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return -1;
        }
        List<Integer> idx1 = new ArrayList<Integer>();
        List<Integer> idx2 = new ArrayList<Integer>();

        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1.add(i);
            } else if (words[i].equals(word2)) {
                idx2.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer one : idx1) {
            for (Integer two : idx2) {
                min = Math.min(min, Math.abs(one - two));
            }
        }
        return min;
    }
}
