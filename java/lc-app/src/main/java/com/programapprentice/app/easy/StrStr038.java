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


    public int[] getDiffTable(String needle) {
        int n = needle.length();
        int pos = 1;
        int cnd = 0;
        int[] table = new int[n];
        table[0] = -1;
        while(pos < n) {
            if (needle.charAt(pos) == needle.charAt(cnd)) {
                table[pos] = table[cnd];
                pos += 1;
                cnd += 1;
            } else {
                table[pos] = cnd;
                cnd = table[cnd];
                while (cnd >= 0 && needle.charAt(pos) != needle.charAt(cnd)) {
                    cnd = table[cnd];
                }
                pos += 1;
                cnd += 1;
            }
        }
        if (pos < n) {
            table[pos] = cnd;
        }
        return table;
    }

    /**
     * KMP algorithm in WIKI page
     * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
     * */
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            return -1;
        }
        if (needle.equals("") && haystack.equals("")) {
            return 0;
        } else if (needle.equals("") || haystack.equals("")) {
            return -1;
        }

        int m = 0;
        int i = 0;
        int stackLength = haystack.length();
        int needleLength = needle.length();
        int[] table = getDiffTable(needle);

        while (m + i < stackLength) {
            if(needle.charAt(i) == haystack.charAt(m+i)) {
                i +=1;
                if (i == needleLength) { // find it.
                    return m;
                }
                m += i - table[i];
                i = table[i];
            } else {
                if (table[i] > -1) {
                    m += i - table[i];
                    i = table[i];
                } else {
                    m = m + i + 1;
                    i = 0;
                }
            }
        }
        return -1;
    }

}

