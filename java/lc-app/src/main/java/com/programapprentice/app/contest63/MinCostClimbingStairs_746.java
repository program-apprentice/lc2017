package com.programapprentice.app.contest63;

public class MinCostClimbingStairs_746 {
    /**
     https://leetcode.com/contest/weekly-contest-63/problems/min-cost-climbing-stairs/
     On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

     Once you pay the cost, you can either climb one or two steps. You need to find minimum cost
     to reach the top of the floor, and you can either start from the step with index 0,
     or the step with index 1.

     Example 1:
     Input: cost = [10, 15, 20]
     Output: 15
     Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     Example 2:
     Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     Output: 6
     Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     Note:
     cost will have a length in the range [2, 1000].
     Every cost[i] will be an integer in the range [0, 999].
     * */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        int[] opts = new int[cost.length+1];
        opts[1] = cost[0];
        int i = 2;
        for(; i < cost.length; i++) {
            opts[i] = Math.min(opts[i-2] + cost[i-2], opts[i-1] + cost[i-1]);
        }
        int start0 = Math.min(opts[i-2] + cost[i-2], opts[i-1] + cost[i-1]);

        opts = new int[cost.length];
        opts[1] = cost[1];
        i = 2;
        for(; i < cost.length-1; i++) {
            opts[i] = Math.min(opts[i-2] + cost[i-1], opts[i-1] + cost[i]);
        }
        int start1 = Math.min(opts[i-2] + cost[i-1], opts[i-1] + cost[i]);
        return Math.min(start0, start1);
    }
}
