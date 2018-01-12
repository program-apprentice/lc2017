package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class LineReflection_356_T {
    LineReflection_356 solution = new LineReflection_356();

    @Test
    public void test1() {
        int[][] nums = {{1, 1}, {-1, 1}};
        Assert.assertTrue(solution.isReflected(nums));
    }

    @Test
    public void test2() {
        int[][] nums = {{1, 1}, {-1, -1}};
        Assert.assertFalse(solution.isReflected(nums));
    }

    @Test
    public void test3() {
        int[][] nums = {{0, 0}, {0, 0}};
        Assert.assertTrue(solution.isReflected(nums));
    }

    @Test
    public void test4() {
        int[][] nums = {{1,2},{2,2},{1,4},{2,4}};
        Assert.assertTrue(solution.isReflected(nums));
    }
}
