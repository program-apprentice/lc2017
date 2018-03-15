package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingPathInAMatrix_329_T {
    LongestIncreasingPathInAMatrix_329 solution = new LongestIncreasingPathInAMatrix_329();

    @Test
    public void test1() {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        int result = solution.longestIncreasingPath(matrix);
        Assert.assertEquals(4, result);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {0},
                {1},
                {5},
                {5}
        };
        int result = solution.longestIncreasingPath(matrix);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test3() {
        int[][] matrix = {
        };
        int result = solution.longestIncreasingPath(matrix);
        Assert.assertEquals(0, result);
    }
}
