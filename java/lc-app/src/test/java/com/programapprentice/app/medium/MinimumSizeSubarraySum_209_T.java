package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSizeSubarraySum_209_T {
    MinimumSizeSubarraySum_209 solution = new MinimumSizeSubarraySum_209();

    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int actual = solution.minSubArrayLen(7, nums);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int[] nums = {1, 4, 4};
        int actual = solution.minSubArrayLen(4, nums);
        Assert.assertEquals(1, actual);
    }
}
