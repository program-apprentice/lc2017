package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class MaximumVacationDays_568_T {
    MaximumVacationDays_568 solution = new MaximumVacationDays_568();

    @Test
    public void test1() {
        int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] days = {{1,3,1},{6,0,3},{3,3,3}};

        int result = solution.maxVacationDays(flights, days);
        Assert.assertEquals(result, 12);
    }

    @Test
    public void test2() {
        int[][] flights = {{0,0,0},{0,0,0}, {0,0,0}};
        int[][] days = {{1,1,1},{7, 7, 7}, {7, 7, 7}};

        int result = solution.maxVacationDays(flights, days);
        Assert.assertEquals(result, 3);
    }

    @Test
    public void test3() {
        int[][] flights = {{0,1,1},{1,0,1},{1,1,0}};
        int[][] days = {{7, 0, 0},{0, 7, 0}, {0, 0, 7}};

        int result = solution.maxVacationDays(flights, days);
        Assert.assertEquals(result, 21);
    }
}
