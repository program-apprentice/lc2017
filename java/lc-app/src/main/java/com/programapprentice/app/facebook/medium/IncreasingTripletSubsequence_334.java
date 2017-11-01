package com.programapprentice.app.facebook.medium;

public class IncreasingTripletSubsequence_334 {
    /**
     https://leetcode.com/problems/increasing-triplet-subsequence/description/

     Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

     Formally the function should:
     Return true if there exists i, j, k
     such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     Your algorithm should run in O(n) time complexity and O(1) space complexity.

     Examples:
     Given [1, 2, 3, 4, 5],
     return true.

     Given [5, 4, 3, 2, 1],
     return false.
     */

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if (m1 >= nums[i]) {
                m1 = nums[i];
            } else if (m2 > nums[i]) {
                m2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean dpSolutionincreasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int min = nums[0];
        for(int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            left[i] = min;
        }
        int max = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            right[i] = max;
        }
        for(int i = 1; i <n-1; i++) {
            if (left[i] < nums[i] && nums[i] < right[i]) {
                return true;
            }
        }
        return false;
    }
}
