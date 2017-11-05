package com.programapprentice.app.facebook.hard;

public class SplitArrayLargestSum_410 {
    /**
     https://leetcode.com/problems/split-array-largest-sum/description/
     Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

     Note:
     If n is the length of array, assume the following constraints are satisfied:

     1 ≤ n ≤ 1000
     1 ≤ m ≤ min(50, n)
     Examples:

     Input:
     nums = [7,2,5,10,8]
     m = 2

     Output:
     18

     Explanation:
     There are four ways to split nums into two subarrays.
     The best way is to split it into [7,2,5] and [10,8],
     where the largest sum among the two subarrays is only 18.

     http://www.cnblogs.com/grandyang/p/5933787.html
     * */
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] sums = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        int[][] opts = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                opts[i][j] = Integer.MAX_VALUE;
            }
        }
        opts[0][0] = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = i-1; k < j; k++) {
                    int val = Math.max(opts[i-1][k], sums[j] - sums[k]);
                    opts[i][j] = Math.min(opts[i][j], val);
                }
            }
        }
        return opts[m][n];
    }
}
