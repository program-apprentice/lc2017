package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class GraphValidTree_261_T {
    GraphValidTree_261 solution = new GraphValidTree_261();

    @Test
    public void test1() {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        int n = 5;
        boolean result = solution.validTree(n, edges);
        Assert.assertTrue(result);
    }
}
