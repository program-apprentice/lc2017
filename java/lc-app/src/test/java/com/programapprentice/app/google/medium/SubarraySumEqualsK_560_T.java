package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class SubarraySumEqualsK_560_T {
    SubarraySumEqualsK_560 solution = new SubarraySumEqualsK_560();

    @Test
    public void test1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int actual = solution.subarraySum(nums, k);
        Assert.assertEquals(2, actual);

    }
}
