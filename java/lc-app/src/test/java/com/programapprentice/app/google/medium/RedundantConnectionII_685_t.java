package com.programapprentice.app.google.medium;

import org.junit.Test;

public class RedundantConnectionII_685_t {
    RedundantConnectionII_685 solution = new RedundantConnectionII_685();

    @Test
    public void test1() {
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] result = solution.findRedundantDirectedConnection(edges);
        System.out.println(String.format("%d->%d", result[0], result[1]));
    }

    @Test
    public void test2() {
        int[][] edges = {{1,2},{2,3},{3,1}};
        int[] result = solution.findRedundantDirectedConnection(edges);
        System.out.println(String.format("%d->%d", result[0], result[1]));
    }
}
