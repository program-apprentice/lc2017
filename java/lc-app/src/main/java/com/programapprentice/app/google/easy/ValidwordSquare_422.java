package com.programapprentice.app.google.easy;

import java.util.ArrayList;
import java.util.List;

public class ValidwordSquare_422 {
    /**
     https://leetcode.com/problems/valid-word-square/description/
     * */
    public int getMaxLength(List<String> words) {
        int max = 0;
        for(String word : words) {
            max = Math.max(max, word.length());
        }
        return max;
    }

    public boolean validWordSquare(List<String> words) {
        List<String> colStrings = new ArrayList<String>();
        int maxLength = getMaxLength(words);
        if (maxLength != words.size()) {
            return false;
        }

        for(int i = 1; i <= maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for(String word : words) {
                if (i <= word.length()) {
                    sb.append(word.charAt(i-1));
                }
            }
            colStrings.add(sb.toString());
        }

        for(int i = 0; i < maxLength; i ++) {
            String word = words.get(i);
            if (!word.equals(colStrings.get(i))) {
                return false;
            }
        }
        return true;
    }
}
