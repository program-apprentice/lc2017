package com.programapprentice.app.facebook.medium;

public class HIndexII_275 {
    /**
     [275] H-Index II

     https://leetcode.com/problems/h-index-ii

     Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
     * */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            if (citations[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }


        int n = citations.length;
        for(int i = 0; i < n; i++) {
            int numOfPapers = n - i;
            if (citations[i] > numOfPapers) {
                return numOfPapers;
            }
        }

        return 0;
    }

}
