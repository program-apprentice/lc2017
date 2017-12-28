package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class LongestLineOfConsecutiveOneInMatrix_562_T {
    LongestLineOfConsecutiveOneInMatrix_562 solution = new LongestLineOfConsecutiveOneInMatrix_562();

    @Test
    public void test1() {
        int[][] matrix = {
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,1}};
        int acutal = solution.longestLine(matrix);
        Assert.assertEquals(3, acutal);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1,1,1,1},
                {0,1,1,0},
                {0,0,0,1}
        };
        int acutal = solution.longestLine(matrix);
        Assert.assertEquals(4, acutal);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {0,0,1,0,1,1,1,0,1,1},
                {1,1,1,1,0,1,1,1,1,1},
                {1,1,1,1,1,0,0,0,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {0,0,1,1,1,0,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1},
                {1,1,1,1,0,1,0,1,0,1},
                {0,1,0,0,0,1,0,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {1,0,1,1,1,0,1,1,1,0}
        };
        int acutal = solution.longestLine(matrix);
        Assert.assertEquals(9, acutal);
    }

    @Test
    public void test4() {
        int[][] matrix = {
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
        };
        int acutal = solution.longestLine(matrix);
        Assert.assertEquals(9, acutal);
    }
}
