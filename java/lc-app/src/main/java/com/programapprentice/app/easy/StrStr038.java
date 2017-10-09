package com.programapprentice.app.easy;

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
        int startIdx = 0;
        int lengthMatched = 0;
        while(i < haystack.length() && j < needle.length()) {
            while(j < needle.length() && i < haystack.length()) {
                if (needle.charAt(j) == haystack.charAt(i)) {
                    i++;
                    j++;
                    lengthMatched ++;
                    if (lengthMatched == needle.length()) {
                        return startIdx;
                    }
                } else {
                    lengthMatched = 0;
                    i = startIdx + 1;
                    startIdx += 1;
                    j = 0;
                    break;
                }
            }
        }
        return -1;
    }

}

