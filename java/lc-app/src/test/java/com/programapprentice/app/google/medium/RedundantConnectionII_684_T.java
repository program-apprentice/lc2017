package com.programapprentice.app.google.medium;

import org.junit.Test;

public class RedundantConnectionII_684_T {
    RedundantConnectionII_684 solution = new RedundantConnectionII_684();

    @Test
    public void test1() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] result = solution.findRedundantConnection(edges);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
