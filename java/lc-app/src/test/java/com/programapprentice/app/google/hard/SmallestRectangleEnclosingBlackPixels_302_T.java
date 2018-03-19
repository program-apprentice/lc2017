package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestRectangleEnclosingBlackPixels_302_T {
    SmallestRectangleEnclosingBlackPixels_302 solution = new SmallestRectangleEnclosingBlackPixels_302();

    @Test
    public void test1() {
        char[][] grid = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        int x = 0;
        int y = 2;
        int result = solution.minArea(grid, x, y);
        Assert.assertEquals(6, result);
    }
}
