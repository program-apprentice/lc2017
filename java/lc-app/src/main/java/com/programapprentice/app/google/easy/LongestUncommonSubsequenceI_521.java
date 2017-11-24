package com.programapprentice.app.google.easy;

public class LongestUncommonSubsequenceI_521 {
    /**
     https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
     * */
    public int findLUSlength(String a, String b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return b.length();
        }
        if (b == null) {
            return a.length();
        }
        return a.equals(b) ? -1 :  Math.max(a.length(), b.length());
    }
}
