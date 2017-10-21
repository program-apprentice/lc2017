package com.programapprentice.app.medium;

public class OneEditDistance_161 {
    /**
     * https://leetcode.com/problems/one-edit-distance/description/
     * Given two strings S and T, determine if they are both one edit distance apart.
     * */

    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || s.length() == 0) {
            return t.length() == 1;
        }
        if (t == null || t.length() == 0) {
            return s.length() == 1;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int count = 0;
        if (Math.abs(s.length() - t.length()) ==  1) {
            int sIdx = 0; // short
            int tIdx = 0; // long
            if (s.length() > t.length()) {
                String tmp = s;
                s = t;
                t = tmp;
            }
            while(sIdx < s.length() && tIdx < t.length()) {
                if (s.charAt(sIdx) != t.charAt(tIdx)) {
                    if (count == 1) {
                        return false;
                    }
                    tIdx++;
                    count++;
                } else {
                    sIdx++;
                    tIdx++;
                }
            }
            if (tIdx < t.length()) {
                count = 1;
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (count == 1) {
                        return false;
                    }
                    count++;
                }
            }
        }
        return count == 1;
   }
}
