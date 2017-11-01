package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSizeSubarraySumEqualsK_325_T {
    MaximumSizeSubarraySumEqualsK_325 solution = new MaximumSizeSubarraySumEqualsK_325();

    @Test
    public void test1() {
        int[] input = {-2, -1, 2, 1};
        int actual = solution.maxSubArrayLen(input, 1);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int[] input = {1, -1, 5, -2, 3};
        int actual = solution.maxSubArrayLen(input, 3);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void test3() {
        int[] input = {-5,8,2,-1,6,-3,7,1,8,-2,7};
        int actual = solution.maxSubArrayLen(input, -4);
        Assert.assertEquals(4, actual);
    }
}
