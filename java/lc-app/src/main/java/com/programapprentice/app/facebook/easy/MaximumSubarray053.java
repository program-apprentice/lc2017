package com.programapprentice.app.facebook.easy;

public class MaximumSubarray053 {
    /**
     [53] Maximum Subarray

     https://leetcode.com/problems/maximum-subarray


     Find the contiguous subarray within an array (containing at least one number) which has the largest sum.


     For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     the contiguous subarray [4,-1,2,1] has the largest sum = 6.


     click to show more practice.

     More practice:

     If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int maxSum = nums[0];
        int sum = maxSum;
        for(int i = 1; i < nums.length; i++) {
            if(sum < 0) {
                sum = 0;
            }
            sum = sum + nums[i];
            maxSum = maxSum > sum ? maxSum : sum;
            maxSum = maxSum > nums[i] ? maxSum : nums[i];

        }
        return maxSum;
    }
}
