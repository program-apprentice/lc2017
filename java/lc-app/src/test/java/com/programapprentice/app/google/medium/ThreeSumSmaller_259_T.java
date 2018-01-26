package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSumSmaller_259_T {
    ThreeSumSmaller_259 solution = new ThreeSumSmaller_259();

    @Test
    public void test1() {
        int[] nums = {1, -1, 0};
        int actual = solution.threeSumSmaller(nums, 0);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void test2() {
        int[] nums = {-1, 0, 1};
        int actual = solution.threeSumSmaller(nums, 0);
        Assert.assertEquals(0, actual);
    }

}
