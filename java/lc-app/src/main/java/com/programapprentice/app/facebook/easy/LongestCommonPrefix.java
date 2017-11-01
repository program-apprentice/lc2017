package com.programapprentice.app.facebook.easy;

public class LongestCommonPrefix {
    /**
     https://leetcode.com/problems/longest-common-prefix

     * algorithms
     * Easy (31.48%)
     * Source Code:       14.longest-common-prefix.java
     * Total Accepted:    208.7K
     * Total Submissions: 662.7K
     * Testcase Example:  '[]'

     Write a function to find the longest common prefix string amongst an array of strings.
     * */

    private int getMinLength(String[] strs) {
        if(strs == null) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        for(String str : strs) {
            if(str == null) {
                return 0;
            }
            minLength = minLength < str.length() ? minLength : str.length();
        }
        return minLength;
    }

    private Boolean isSame(char[] chars) {
        char c = chars[0];
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] != c) {
                return false;
            }
        }

        return true;
    }

    /**
     * How to scale: m boxes, figure out the longest common prefix for each box. Then continue to merge.
     * */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        int minLength = getMinLength(strs);
        for (int i = 0; i < minLength; i++) {
            char[] chars = new char[n];
            for (int j = 0; j < n; j++) {
                chars[j] = strs[j].charAt(i);
            }
            if(isSame(chars)) {
                sb.append(chars[0]);
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
