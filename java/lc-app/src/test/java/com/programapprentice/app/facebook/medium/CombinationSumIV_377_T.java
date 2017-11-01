package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class CombinationSumIV_377_T {
    CombinationSumIV_377 solution = new CombinationSumIV_377();

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int target = 4;
        Assert.assertEquals(7, solution.combinationSum4(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        int target = 32;
        Assert.assertEquals(181997601, solution.combinationSum4(nums, target));
    }

    @Test
    public void test3() {
        int[] nums = {1, 2, 3};
        int target = 35;
        Assert.assertEquals(1132436852, solution.combinationSum4(nums, target));
    }
}
