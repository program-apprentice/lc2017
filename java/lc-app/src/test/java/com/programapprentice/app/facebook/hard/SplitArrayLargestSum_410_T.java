package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class SplitArrayLargestSum_410_T {
    SplitArrayLargestSum_410 solution = new SplitArrayLargestSum_410();

    @Test
    public void test1() {
        int[] nums = {7, 2, 5, 10, 8};
        int result = solution.splitArray(nums, 3);
        Assert.assertEquals(14, result);
    }
}
