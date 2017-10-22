package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfArrayExceptSelf_238_T {
    ProductOfArrayExceptSelf_238 solution = new ProductOfArrayExceptSelf_238();

    @Test
    public void test1() {
        int[] nums = {1, 0};
        int[] actual = solution.productExceptSelf(nums);
        Assert.assertEquals(0, actual[0]);
        Assert.assertEquals(1, actual[1]);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        int[] actual = solution.productExceptSelf(nums);
        Assert.assertEquals(6, actual[0]);
        Assert.assertEquals(3, actual[1]);
        Assert.assertEquals(2, actual[2]);
    }
}
