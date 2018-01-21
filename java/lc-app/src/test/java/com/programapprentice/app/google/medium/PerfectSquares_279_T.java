package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class PerfectSquares_279_T {
    PerfectSquares_279 solution = new PerfectSquares_279();

    @Test
    public void test1() {
        int actual = solution.numSquares(13);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int actual = solution.numSquares(12);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test3() {
        int actual = solution.numSquares(2);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test4() {
        int actual = solution.numSquares(3);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test5() {
        int actual = solution.numSquares(4);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test6() {
        int actual = solution.numSquares(47);
        Assert.assertEquals(4, actual);
    }
}
