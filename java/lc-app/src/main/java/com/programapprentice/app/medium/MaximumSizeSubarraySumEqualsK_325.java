package com.programapprentice.app.medium;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK_325 {
    /**
     https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/description/

     Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

     Note:
     The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

     Example 1:
     Given nums = [1, -1, 5, -2, 3], k = 3,
     return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

     Example 2:
     Given nums = [-2, -1, 2, 1], k = 1,
     return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

     Follow Up:
     Can you do it in O(n) time?
     * */

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int n = nums.length;
        int[] sums = new int[n];// the to ends with idx

        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> sumToIdx = new HashMap<Integer, Integer>();
        int tmp = 0;
        for(int i = 0; i < n; i++) {
            tmp += nums[i];
            if (tmp == k) {
                max = Math.max(max, i + 1);
            }
            sums[i] = tmp;
            if (sumToIdx.get(tmp) == null) {
                sumToIdx.put(tmp, i);
            }
            int remain = tmp - k;
            if (sumToIdx.get(remain) != null) {
                int leftIdx = sumToIdx.get(remain);
                max = Math.max(max, i - leftIdx);
            }
        }

        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }
}
