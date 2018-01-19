package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class MinimumHeightTrees_310_T {
    MinimumHeightTrees_310 solution = new MinimumHeightTrees_310();

    @Test
    public void test1() {
        int[][] edges = {{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}};
        List<Integer> result = solution.findMinHeightTrees(7, edges);
        TestUtil.printArrayList(result);
    }

    @Test
    public void test2() {
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> result = solution.findMinHeightTrees(4, edges);
        TestUtil.printArrayList(result);
    }

    @Test
    public void test3() {
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> result = solution.findMinHeightTrees(6, edges);
        TestUtil.printArrayList(result);
    }
}
