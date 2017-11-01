package com.programapprentice.app.facebook.easy;

import org.junit.Assert;
import org.junit.Test;

public class HammingDistance_461_T {
    HammingDistance_461 solution = new HammingDistance_461();

    @Test
    public void test1() {
        int x = 1;
        int y = 4;
        int actual = solution.hammingDistance(x, y);
        Assert.assertEquals(2, actual);
    }
}
