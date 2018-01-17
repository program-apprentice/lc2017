package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfConnectedCompnentsInAnUndirectedGraph_323_T {
    NumberOfConnectedCompnentsInAnUndirectedGraph_323 solution = new NumberOfConnectedCompnentsInAnUndirectedGraph_323();

    @Test
    public void test1() {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int actual = solution.countComponents(5, edges);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int actual = solution.countComponents(5, edges);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test3() {
        int[][] edges = {};
        int actual = solution.countComponents(1,  edges);
        Assert.assertEquals(1, actual);
    }
}
