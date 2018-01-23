package com.programapprentice.app.google.medium;

public class FindPeakElement_162 {
    /**
     https://leetcode.com/problems/find-peak-element/description/

     A peak element is an element that is greater than its neighbors.

     Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

     The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

     You may imagine that num[-1] = num[n] = -∞.

     For example, in array [1, 2, 3, 1], 3 is a peak element and your function
     should return the index number 2.

     * */

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        int pre = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n-1; i++) {
            int cur = nums[i];
            int next = nums[i+1];
            if (cur > pre && cur > next) {
                return i;
            }
            pre = cur;
        }
        return n-1;
    }

}
