package com.programapprentice.app.facebook.easy;

public class ClimbingStairs070 {
    /**
     [70] Climbing Stairs

     https://leetcode.com/problems/climbing-stairs

     * algorithms
     * Easy (40.27%)
     * Source Code:       70.climbing-stairs.0.java
     * Total Accepted:    199K
     * Total Submissions: 494.1K
     * Testcase Example:  '1'

     You are climbing a stair case. It takes n steps to reach to the top.

     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


     Note: Given n will be a positive integer.
     * */
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 0) {
            return n;
        }
        int[] opt = new int[n];
        opt[0] = 1;
        opt[1] = 2;
        for(int i = 2; i < n; i++) {
            opt[i] = opt[i-1] + opt[i-2];
        }

        return opt[n-1];
    }
}
