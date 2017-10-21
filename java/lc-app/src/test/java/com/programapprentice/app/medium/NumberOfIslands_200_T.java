package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslands_200_T {
    NumberOfIslands_200 solution = new NumberOfIslands_200();

    @Test
    public void test1() {
        char[][] input = { {'1', '1', '1'}, {'1', '0', '1'}};
        int actual = solution.numIslands(input);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test2() {
        char[][] input = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int actual = solution.numIslands(input);
        Assert.assertEquals(1, actual);

    }
}
