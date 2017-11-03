package com.programapprentice.app.facebook.hard;

public class MaximumSumOf3NonOverlappingSubarrays_689 {
    /**
     https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
     In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

     Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

     Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

     Example:
     Input: [1,2,1,2,6,7,5,1], 2
     Output: [0, 3, 5]
     Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
     We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
     Note:
     nums.length will be between 1 and 20000.
     nums[i] will be between 1 and 65535.
     k will be between 1 and floor(nums.length / 3).

     Good solution:
     http://blog.csdn.net/Yaokai_AssultMaster/article/details/78248711
     */

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < 3*k) {
            return null;
        }
        int n = nums.length;
        int[] opts = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i-k];
            }
            if (i >= k-1) {
                opts[i -k + 1]  = sum;
            }
        }

        // left[i] stores the start index for the first interval in range [0, i]
        // right[i] stores the start index for the third interval in range [i, n - 1]
        int[] leftIdx = new int[n];
        int[] rightIdx = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[3];
        for(int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = -1;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n-k+1; i++) {
            if (max < opts[i]) { // Need to use "<"
                max = opts[i];
                left[i] = max;
                leftIdx[i] = i;
            } else {
                leftIdx[i] = leftIdx[i-1];
                left[i] = left[i-1];
            }
        }

        max = Integer.MIN_VALUE;
        for(int i = n-k; i >= 0; i--) {
            if (max <= opts[i]) { // Need to use "<="
                max = opts[i];
                right[i] = max;
                rightIdx[i] = i;
            } else {
                right[i] = right[i+1];
                rightIdx[i] = rightIdx[i+1];
            }
        }

        int maxSum = 0;
        for(int i = k; i <= n - 2*k + 1; i++) {
            int leftStartIdx = leftIdx[i-k];
            if (i+k == n) {
                continue;
            }
            int rightStartIdx = rightIdx[i+k];
            sum = opts[i] + left[i-k] + right[i+k];
            if (sum > maxSum) {
                result[0] = leftStartIdx;
                result[1] = i;
                result[2] = rightStartIdx;
                maxSum = sum;
            }
        }

        return result;
    }


}
