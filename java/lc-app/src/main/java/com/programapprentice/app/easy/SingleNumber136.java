package com.programapprentice.app.easy;

public class SingleNumber136 {
    /**
     [136] Single Number

     https://leetcode.com/problems/single-number

     Given an array of integers, every element appears twice except for one. Find that single one.

     Note:
     Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * */
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
