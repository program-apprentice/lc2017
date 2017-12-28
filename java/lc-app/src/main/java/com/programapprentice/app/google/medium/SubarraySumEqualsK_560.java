package com.programapprentice.app.google.medium;

public class SubarraySumEqualsK_560 {
    /**
     https://leetcode.com/problems/subarray-sum-equals-k/description/
     Given an array of integers and an integer k, you need to find the total number of continuous subarrays
     whose sum equals to k.

     Example 1:
     Input:nums = [1,1,1], k = 2
     Output: 2
     Note:
     The length of the array is in range [1, 20,000].
     The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
     */

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] sums = new int[len];

        int counter = 0;
        int sum = 0;
        for(int i = 0; i < len; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        for(int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if ((sums[j] - sums[i] + nums[i])== k) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
