package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class TotalHammingDistance_477_T {
    TotalHammingDistance_477 solution = new TotalHammingDistance_477();

    @Test
    public void test1() {
        int[] nums = {4, 14, 2};
        Assert.assertEquals(6, solution.totalHammingDistance(nums));
    }
}
