package com.programapprentice.app.google.medium;

import org.junit.Test;

public class ZeroOneMatrix_542_T {
    ZeroOneMatrix_542 solution = new ZeroOneMatrix_542();

    @Test
    public void test1() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] result = solution.updateMatrix(matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] result = solution.updateMatrix(matrix);
    }

}
