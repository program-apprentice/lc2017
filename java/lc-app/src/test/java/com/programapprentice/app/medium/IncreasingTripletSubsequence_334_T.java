package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class IncreasingTripletSubsequence_334_T {
    IncreasingTripletSubsequence_334 solution = new IncreasingTripletSubsequence_334();

    @Test
    public void test1() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        Assert.assertTrue(solution.increasingTriplet(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, -10, -8, -7};
        Assert.assertTrue(solution.increasingTriplet(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3, 4, 5};
        Assert.assertTrue(solution.increasingTriplet(nums));
    }
}
