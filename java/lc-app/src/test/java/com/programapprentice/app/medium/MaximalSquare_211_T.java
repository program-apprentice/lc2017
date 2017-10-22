package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class MaximalSquare_211_T {
    MaximalSquare_211 solution = new MaximalSquare_211();

    @Test
    public void test1() {
        char[][] input = {
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'}};
        int actual = solution.maximalSquare(input);
        Assert.assertEquals(16, actual);
    }
}
