package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnesII_487_T {
    MaxConsecutiveOnesII_487 solution = new MaxConsecutiveOnesII_487();

    @Test
    public void test1() {
        int[] nums = {1,0,1,1,0,1};
        int actual = solution.findMaxConsecutiveOnes(nums);
        Assert.assertEquals(4, actual);
    }

    @Test
    public void test2() {
        int[] nums = {0,0};
        int actual = solution.findMaxConsecutiveOnes(nums);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        int actual = solution.findMaxConsecutiveOnes(nums);
        Assert.assertEquals(8, actual);
    }

    @Test
    public void test4() {
        int[] nums = {1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1};
        int actual = solution.findMaxConsecutiveOnes(nums);
        Assert.assertEquals(7, actual);
    }
}
