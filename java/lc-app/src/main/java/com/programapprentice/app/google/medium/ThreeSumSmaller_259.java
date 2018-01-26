package com.programapprentice.app.google.medium;

import java.util.Arrays;

public class ThreeSumSmaller_259 {
    /**
     https://leetcode.com/problems/3sum-smaller/description/

     Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

     For example, given nums = [-2, 0, 1, 3], and target = 2.

     Return 2. Because there are two triplets which sums are less than 2:

     [-2, 0, 1]
     [-2, 0, 3]
     Follow up:
     Could you solve it in O(n^2) runtime?
     * */

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for(int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;
            while(left < right) {
                int val = nums[i] + nums[left] + nums[right];
                if (val < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
