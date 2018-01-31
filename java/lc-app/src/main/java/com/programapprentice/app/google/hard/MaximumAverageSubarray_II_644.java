package com.programapprentice.app.google.hard;

public class MaximumAverageSubarray_II_644 {
    /**
     https://leetcode.com/problems/maximum-average-subarray-ii/description/
     Given an array consisting of n integers, find the contiguous subarray
     whose length is greater than or equal to k that has the maximum average value. And you need to output the maximum average value.

     Example 1:
     Input: [1,12,-5,-6,50,3], k = 4
     Output: 12.75
     Explanation:
     when length is 5, maximum average value is 10.8,
     when length is 6, maximum average value is 9.16667.
     Thus return 12.75.
     Note:
     1 <= k <= n <= 10,000.
     Elements of the given array will be in range [-10,000, 10,000].
     The answer with the calculation error less than 10-5 will be accepted.

     * */
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        double mid = 0;
        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        while(max - min > 0.00001) {
            mid = (max + min) / 2.0;
            if (isPossible(nums, k, mid)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return max;
    }

    public boolean isPossible(int[] nums, int k, double mid) {
        double sum = 0;
        double presum = 0;
        double minSum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        for(int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            presum += nums[i-k] - mid;
            minSum = Math.min(presum, minSum);
            if (sum >= minSum) {
                return true;
            }
        }
        return false;
    }
}
