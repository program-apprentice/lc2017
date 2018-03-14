package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class PatchingArray_330_T {
    PatchingArray_330 solution = new PatchingArray_330();

    @Test
    public void test1() {
        int[] nums = {1, 2, 4, 11};
        int result = solution.minPatches(nums, 30);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 4, 13, 43};
        int result = solution.minPatches(nums, 100);
        Assert.assertEquals(2, result);
    }
}
