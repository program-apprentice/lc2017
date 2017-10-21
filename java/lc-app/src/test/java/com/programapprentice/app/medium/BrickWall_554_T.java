package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BrickWall_554_T {
    BrickWall_554 solution = new BrickWall_554();

    @Test
    public void test1() {
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        level.add(100000000);
        input.add(level);
        input.add(level);
        input.add(level);
        int actual = solution.leastBricks(input);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test2() {
        int[][] nums = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        for(int[] item : nums) {
            List<Integer> level = new ArrayList<Integer>();
            for(int n : item) {
                level.add(n);
            }
            input.add(level);
        }
        int actual = solution.leastBricks(input);
        Assert.assertEquals(2, actual);
    }
}
