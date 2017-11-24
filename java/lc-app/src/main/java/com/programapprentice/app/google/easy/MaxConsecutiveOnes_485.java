package com.programapprentice.app.google.easy;

public class MaxConsecutiveOnes_485 {
    /**
     https://leetcode.com/problems/max-consecutive-ones/description/
     * */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if (i > 0 && nums[i-1] == 1) {
                    max = Math.max(max, count);
                    count = 0;
                }
            } else {
                count++;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
