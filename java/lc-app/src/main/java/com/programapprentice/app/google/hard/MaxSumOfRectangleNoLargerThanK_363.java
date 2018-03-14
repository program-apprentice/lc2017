package com.programapprentice.app.google.hard;

public class MaxSumOfRectangleNoLargerThanK_363 {
    /**
     https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
     Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

     Example:
     Given matrix = [
     [1,  0, 1],
     [0, -2, 3]
     ]
     k = 2
     The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

     Note:
     The rectangle inside the matrix must have an area > 0.
     What if the number of rows is much larger than the number of columns?
     * */

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int result = Integer.MIN_VALUE;
        int[][] sum  = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int t = matrix[i][j];
                if (i > 0) {
                    t += sum[i-1][j];
                }
                if (j > 0) {
                    t += sum[i][j-1];
                }
                if (i >0 && j > 0) {
                    t -= sum[i-1][j-1];
                }
                sum[i][j] = t;
                for (int row = 0; row <= i; row++) {
                    for (int col = 0; col <= j; col++) {
                        int d = sum[i][j];
                        if (row > 0) {
                            d -= sum[row-1][j];
                        }
                        if (col > 0) {
                            d -= sum[i][col-1];
                        }
                        if (row > 0 && col > 0) {
                            d += sum[row-1][col-1];
                        }
                        if (d <=k) {
                            result = Math.max(result, d);
                        }
                    }
                }
            }
        }
        return result;
    }

}
