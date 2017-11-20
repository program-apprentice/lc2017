package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleInHistogram_084_T {
    LargestRectangleInHistogram_084 solution = new LargestRectangleInHistogram_084();

    @Test
    public void test1() {
        int[] nums = {2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1};
        int actual = solution.largestRectangleArea(nums);
        Assert.assertEquals(11, actual);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 4};
        int actual = solution.largestRectangleArea(nums);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 4, 1, 4, 3};
        int actual = solution.largestRectangleArea(nums);
        Assert.assertEquals(6, actual);
    }
}
