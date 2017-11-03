package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumOf3NonOverlappingSubarrays_689_T {
    MaximumSumOf3NonOverlappingSubarrays_689 solution = new MaximumSumOf3NonOverlappingSubarrays_689();

    @Test
    public void test1() {
        int[] input = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        int[] actual = solution.maxSumOfThreeSubarrays(input, k);
        Assert.assertEquals(0, actual[0]);
        Assert.assertEquals(3, actual[1]);
        Assert.assertEquals(5, actual[2]);
    }

    @Test
    public void test2() {
        int[] input = {4, 5, 10, 6, 11, 17, 4, 11, 1, 3};
        int k = 1;
        int[] actual = solution.maxSumOfThreeSubarrays(input, k);
        Assert.assertEquals(4, actual[0]);
        Assert.assertEquals(5, actual[1]);
        Assert.assertEquals(7, actual[2]);
    }

    @Test
    public void test3() {
        int[] input = {17,8,14,11,13,9,4,19,20,6,1,20,6,5,19,8,5,16,20,17};
        int k = 5;
        int[] actual = solution.maxSumOfThreeSubarrays(input, k);
        Assert.assertEquals(0, actual[0]);
        Assert.assertEquals(7, actual[1]);
        Assert.assertEquals(14, actual[2]);
    }

}
