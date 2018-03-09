package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class ReversePairs_493_T {
    ReversePairs_493 solution = new ReversePairs_493();

    @Test
    public void test1() {
        int[] nums = {1,3,2,3,1};
        int actual = solution.reversePairs(nums);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int[] nums = {2,4,3,5,1};
        int actual = solution.reversePairs(nums);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test3() {
        int x = Integer.parseInt("1100", 2);
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x ^ (x - 1)));
        System.out.println(Integer.toBinaryString(x & (x ^ (x - 1))));
        System.out.println(x & (x ^ (x - 1)));
    }
}
