package com.programapprentice.app.facebook.easy;

public class StrStr038 {
    /**
     * [28] Implement strStr()

     https://leetcode.com/problems/implement-strstr

     * algorithms
     * Easy (28.37%)
     * Source Code:       28.implement-strstr.0.java
     * Total Accepted:    212K
     * Total Submissions: 747.2K
     * Testcase Example:  '""\n""'


     Implement strStr().


     Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * */

    public int[] generateNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
                if (needle.charAt(j) != needle.charAt(k)) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }

        return  next;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.equals("") && haystack.equals("")) {
            return 0;
        } else if (needle.equals("")) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int[] next = generateNext(needle);
        while(i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length())
            return i - j;
        else
            return -1;
    }

}

