package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.List;

public class BurstBallons_312 {
    /**
     http://www.cnblogs.com/grandyang/p/5006441.html
     Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

     Find the maximum coins you can collect by bursting the balloons wisely.

     Note:
     (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

     Example:

     Given [3, 1, 5, 8]

     Return 167

     nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

     Solution:
     http://www.cnblogs.com/grandyang/p/5006441.html
     dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]) ( i ≤ k ≤ j )
     * */

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for(int num : nums) {
            list.add(num);
        }
        list.add(1);

        int n = nums.length;
        int[][] opts = new int[n+2][n+2];

        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    opts[left][right] = Math.max(opts[left][right], list.get(left-1) * list.get(k) * list.get(right+1) + opts[left][ k-1] + opts[k+1][right]);
                }
            }
        }
        return opts[0][n-1];
    }
}
