package com.programapprentice.app.easy;

public class LongestContinuousIncreasingSubequence_674 {
    /**
     [674] Longest Continuous Increasing Subsequence

     https://leetcode.com/problems/longest-continuous-increasing-subsequence

     Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

     Example 1:

     Input: [1,3,5,4,7]
     Output: 3
     Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
     Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.

     Example 2:

     Input: [2,2,2,2,2]
     Output: 1
     Explanation: The longest continuous increasing subsequence is [2], its length is 1.

     Note:
     Length of the array will not exceed 10,000.
     * */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 0;
        int cur = 0;
        int pre = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if (cur > pre) {
                count ++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
            pre = cur;
        }

        return Math.max(count, max);
    }

}
