package com.programapprentice.app.google.hard;

import org.junit.Test;

public class BurstBallons_312_T {
    BurstBallons_312 solution = new BurstBallons_312();

    @Test
    public void test1() {
        int[] nums = {3, 1, 5, 8};
        solution.maxCoins(nums);
    }
}
