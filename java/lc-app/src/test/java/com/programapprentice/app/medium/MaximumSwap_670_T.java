package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSwap_670_T {
    MaximumSwap_670 solution = new MaximumSwap_670();

    @Test
    public void test1() {
        int input = 2736;
        int actual = solution.maximumSwap(input);
        Assert.assertEquals(7236, actual);
    }
}
