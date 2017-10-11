package com.programapprentice.app.easy;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStock121_T {
    BestTimeToBuyAndSellStock121 solution = new BestTimeToBuyAndSellStock121();

    @Test
    public void test1() {
        int[] input = {7,1,5,3,6,4};
        int actual = solution.maxProfit(input);
        Assert.assertEquals(actual, 5);
    }

    @Test
    public void test2() {
        int[] input = {2, 1};
        int actual = solution.maxProfit(input);
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void test3() {
        int[] input = {1, 4, 2};
        int actual = solution.maxProfit(input);
        Assert.assertEquals(actual, 3);
    }

    @Test
    public void test4() {
        int[] input = {2,1,2,1,0,1,2};
        int actual = solution.maxProfit(input);
        Assert.assertEquals(actual, 2);
    }
}
