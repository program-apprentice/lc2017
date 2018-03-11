package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class OptimalAccountBalancing_465_T {
    OptimalAccountBalancing_465 solution = new OptimalAccountBalancing_465();

    @Test
    public void test1() {
        int[][] transactions = {{0,1,10}, {2,0,5}};
        int result = solution.minTransfers(transactions);
        Assert.assertEquals(2, result);
    }
}
