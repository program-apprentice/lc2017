package com.programapprentice.app.google.easy;

public class MaximumAverageSubarrayI_643 {
    /**
     Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

     Example 1:
     Input: [1,12,-5,-6,50,3], k = 4
     Output: 12.75
     Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
     Note:
     1 <= k <= n <= 30,000.
     Elements of the given array will be in the range [-10,000, 10,000].

     Several solutions: http://www.cnblogs.com/grandyang/p/7294585.html
     * */
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        double sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double result = sum / (double)k;

        for(int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i-k];
            result = Math.max(result, sum / (double)k);
        }
        return result;
    }
}
