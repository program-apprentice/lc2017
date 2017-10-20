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

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<String> dict = new HashSet<String>();
        for(String str : wordDict) {
            dict.add(str);
        }
        boolean[] opts = new boolean[s.length()+1];
        opts[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i-1; j >= 0; j--) {
                if (dict.contains(s.substring(j, i))) {
                    if (opts[j]) {
                        opts[i] = true;
                        break;
                    }
                }
            }
        }
        return opts[s.length()];
    }

}
