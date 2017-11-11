package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class PaintHouseII_265_T {
    PaintHouseII_265 solution = new PaintHouseII_265();

    @Test
    public void test1() {
        int[][] costs = {{1,5,3},{2,9,4}};
        int result = solution.minCostII(costs);
        Assert.assertEquals(5, result);
    }

    @Test
    public void test2() {
        int[][] costs = {
                {19, 3,18, 4,13, 1,12, 6, 3,12, 3, 3, 9},
                {11, 5, 9,16, 2,19,15,10,13,20,15, 2,13},
                {19, 6,18, 7, 6,10,11,13, 8,19, 4,14,18},
                {3, 18,18, 9, 3, 6,18,11, 7, 4,13, 3,12}};
        int result = solution.minCostII(costs);
        Assert.assertEquals(10, result);
    }

    @Test
    public void test3() {
        int[][] costs = {
                { 8,16,12,18, 9},
                {19,18, 8, 2, 8},
                { 8, 5, 5,13, 4},
                {15, 9, 3,19, 2},
                { 8, 7, 1, 8,17},
                { 8, 2, 8,15, 5},
                { 8,17, 1,15, 3},
                { 8, 8, 5, 5,16},
                { 2, 2,18, 2, 9}};
        int result = solution.minCostII(costs);
        Assert.assertEquals(28, result);
    }
}
