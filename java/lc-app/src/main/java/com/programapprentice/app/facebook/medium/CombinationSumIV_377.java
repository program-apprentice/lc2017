package com.programapprentice.app.facebook.medium;

public class CombinationSumIV_377 {
    /**
     https://leetcode.com/problems/combination-sum-iv/description/
     Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

     Example:

     nums = [1, 2, 3]
     target = 4

     The possible combination ways are:
     (1, 1, 1, 1)
     (1, 1, 2)
     (1, 2, 1)
     (1, 3)
     (2, 1, 1)
     (2, 2)
     (3, 1)

     Note that different sequences are counted as different combinations.

     Therefore the output is 7.
     Follow up:
     What if negative numbers are allowed in the given array?
     How does it change the problem?
     What limitation we need to add to the question to allow negative numbers?
     * */
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] opts = new int[target+1];
        opts[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int num : nums) {
                if (num <= i) {
                    opts[i] += opts[i-num];
                }
            }
        }
        return opts[target];
    }

}
