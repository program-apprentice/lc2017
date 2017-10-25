package com.programapprentice.app.medium;

import java.util.Arrays;
import java.util.List;

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
        Arrays.sort(nums);
        return combinationSum4Sorted(nums, target);
    }

    public int combinationSum4Sorted(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                count += 1;
            } else if (target < nums[i]) {
                break;
            } else {
                count += combinationSum4Sorted(nums, target - nums[i]);
            }
        }
        return count;
    }
}
