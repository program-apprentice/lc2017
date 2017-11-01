package com.programapprentice.app.facebook.medium;

public class TargetSum_494 {
    /**
     You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

     Find out how many ways to assign symbols to make sum of integers equal to target S.

     Example 1:
     Input: nums is [1, 1, 1, 1, 1], S is 3.
     Output: 5
     Explanation:

     -1+1+1+1+1 = 3
     +1-1+1+1+1 = 3
     +1+1-1+1+1 = 3
     +1+1+1-1+1 = 3
     +1+1+1+1-1 = 3

     There are 5 ways to assign symbols to make the sum of nums be target 3.
     Note:
     The length of the given array is positive and will not exceed 20.
     The sum of elements in the given array will not exceed 1000.
     Your output answer is guaranteed to be fitted in a 32-bit integer.

     * */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findTargetSumWays(0, nums, S);
    }

    public int findTargetSumWays(int startIdx, int[] nums, int S) {
        int count = 0;
        if (startIdx == nums.length-1) {
            count += nums[startIdx] == S ? 1 : 0;
            count += (0 - nums[startIdx]) == S ? 1 : 0;
            return count;
        }
        count += findTargetSumWays(startIdx+1, nums, S - nums[startIdx]);
        count += findTargetSumWays(startIdx+1, nums, S + nums[startIdx]);
        return count;
    }
}
