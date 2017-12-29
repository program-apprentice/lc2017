package com.programapprentice.app.contest.costest63;

import com.programapprentice.app.contest63.MinCostClimbingStairs_746;
import org.junit.Test;

public class MinCostClimbingStairs_746_T {
    MinCostClimbingStairs_746 solution = new MinCostClimbingStairs_746();

    @Test
    public void test1() {
        int[] input = {10, 15, 20};
        int result = solution.minCostClimbingStairs(input);
    }
}
