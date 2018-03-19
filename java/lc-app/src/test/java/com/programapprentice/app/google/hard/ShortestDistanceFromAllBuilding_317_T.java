package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceFromAllBuilding_317_T {
    ShortestDistanceFromAllBuilding_317 solution = new ShortestDistanceFromAllBuilding_317();

    @Test
    public void test1() {
        int[][] grid = {
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        int result = solution.shortestDistance(grid);
        Assert.assertEquals(7, result);
    }

    @Test
    public void test2() {
        int[][] grid = {
                {1},
                {0}
        };
        int result = solution.shortestDistance(grid);
        Assert.assertEquals(1, result);
    }

    @Test
    public void test3() {
        int[][] grid = {
                {1}
        };
        int result = solution.shortestDistance(grid);
        Assert.assertEquals(-1, result);
    }
}
