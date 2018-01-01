package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class DiagonalTraverse_498_T {
    DiagonalTraverse_498 solution = new DiagonalTraverse_498();

    @Test
    public void test1() {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] result = solution.findDiagonalOrder(matrix);
        TestUtil.printArray(result);
    }
}
