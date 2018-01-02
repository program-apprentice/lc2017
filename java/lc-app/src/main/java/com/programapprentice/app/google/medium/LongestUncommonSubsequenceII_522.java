package com.programapprentice.app.google.medium;

public class LongestUncommonSubsequenceII_522 {
    /**
     https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/
     Given a list of strings, you need to find the longest uncommon subsequence
     among them. The longest uncommon subsequence is defined as the longest subsequence
     of one of these strings and this subsequence should not be any subsequence of the
     other strings.

     A subsequence is a sequence that can be derived from one sequence by deleting some
     characters without changing the order of the remaining elements. Trivially, any string
     is a subsequence of itself and an empty string is a subsequence of any string.

     The input will be a list of strings, and the output needs to be the length of the longest
     uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

     Example 1:
     Input: "aba", "cdc", "eae"
     Output: 3
     Note:

     All the given strings' lengths will not exceed 10.
     The length of the given list will be in the range of [2, 50].

     Solution:
     http://www.cnblogs.com/grandyang/p/6680548.html
     * */

    private boolean checkSubs(String subs, String str) {
        int i = 0;
        for(char c : str.toCharArray()) {
            if (c == subs.charAt(i)) {
                i++;
            }
            if (i == subs.length()) {
                break;
            }
        }
        return i == subs.length();

    }

    public int findLUSlength(String[] strs) {
        int res = -1;
        int n = strs.length;
        int j = 0;
        for(int i = 0; i < n; i++) {
            for(j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (checkSubs(strs[i], strs[j])) {
                    break;
                }
            }
            if (j == n) {
                res = Math.max(res, strs[i].length());
            }
        }

        return res;
    }
}