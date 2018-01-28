package com.programapprentice.app.google.medium;

public class MaximumSumOf3NonOverlappingSubarrays_689 {
    /**
     In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

     Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

     Return the result as a list of indices representing the starting position of each interval
     (0-indexed). If there are multiple answers, return the lexicographically smallest one.

     Example:
     Input: [1,2,1,2,6,7,5,1], 2
     Output: [0, 3, 5]
     Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     Note:
     nums.length will be between 1 and 20000.
     nums[i] will be between 1 and 65535.
     k will be between 1 and floor(nums.length / 3).
     * */

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < 3*k) {
            return null;
        }
        int n = nums.length;
        int[] sums = new int[n];
        int sum= 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k-1) {
                sums[i-k] = sum;
            }
            sum -= nums[i-k+1];
        }
        int[] sums2 = new int[n];
        int[] sums1Idx = new int[n];
        for(int i = k; i < n-k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < i-k; j++) {
                if (max < sums[j] + nums[i]) {
                    max = sums[j] + nums[i];
                    sums1Idx[i] = j;
                    sums2[i] = max;
                }
            }
        }
        int[] sums3 = new int[n];
        int[] sums2Idx = new int[n];
        int globalMax = Integer.MIN_VALUE;
        int globalIdx = -1;
        for(int i = 2*k; i < n-k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = k; j < i-k; j++) {
                if (max < sums2[j] + nums[i]) {
                    max = sums2[j] + nums[i];
                    sums2Idx[i] = j;
                    sums3[i] = max;
                    if (globalMax < max) {
                        globalMax = max;
                        globalIdx = i;
                    }
                }
            }
        }
        int[] result = new int[3];
        result[2] = globalIdx;
        result[1] = sums2Idx[result[2]];
        result[0] = sums1Idx[result[1]];

        return result;
    }
}
