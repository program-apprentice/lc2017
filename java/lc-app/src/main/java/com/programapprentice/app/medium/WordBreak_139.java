package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    /**
     [139] Word Break

     https://leetcode.com/problems/word-break

     Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     You may assume the dictionary does not contain duplicate words.

     For example, given
     s = "leetcode",
     dict = ["leet", "code"].

     Return true because "leetcode" can be segmented as "leet code".

     UPDATE (2017/1/4):
     The wordDict parameter had been changed to a list of strings (instead of a set of strings).
     Please reload the code definition to get the latest changes.
     * */

    public List<Integer> findNextTrue(boolean[] rec, int startIdx) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = startIdx+1; i < rec.length; i++) {
            if(rec[i]) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        Set<String> dict = new HashSet<String>();
        for(String str : wordDict) {
            dict.add(str);
        }
        int n = s.length();
        boolean[][] rec = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dict.contains(s.substring(i, j+1))) {
                    rec[i][j] = true;
                }
            }
        }
        List<Integer> nextTrues = findNextTrue(rec[0], -1);
        while(!nextTrues.isEmpty()) {
            List<Integer> futureTrues = new ArrayList<Integer>();
            for(Integer trueIdx : nextTrues) {
                if (trueIdx == s.length()-1) {
                    return true;
                }
                futureTrues.addAll(findNextTrue(rec[trueIdx+1], trueIdx));
            }
            nextTrues = futureTrues;
        }
        return false;
    }

}
