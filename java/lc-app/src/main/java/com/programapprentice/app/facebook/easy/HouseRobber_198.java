package com.programapprentice.app.facebook.easy;

public class HouseRobber_198 {
    /**
     [198] House Robber

     https://leetcode.com/problems/house-robber

     You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

     Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     * */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] opts = new int[nums.length];
        opts[0] = nums[0];
        opts[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            opts[i] = Math.max(opts[i-1], opts[i-2] + nums[i]);
        }
        return opts[nums.length-1];
    }
}
