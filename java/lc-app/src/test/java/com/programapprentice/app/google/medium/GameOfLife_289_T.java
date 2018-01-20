package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class GameOfLife_289_T {
    GameOfLife_289 solution = new GameOfLife_289();

    @Test
    public void test1() {
        int[][] input = { { 1, 1}};
        solution.gameOfLife(input);
        TestUtil.print2DArray(input);
    }

    @Test
    public void test2() {
        int[][] input = { { 1, 1}, {1, 0}};
        solution.gameOfLife(input);
        TestUtil.print2DArray(input);
    }
}
