package com.programapprentice.app.medium;

public class MaximalSquare_211 {
    /**
     [221] Maximal Square

     https://leetcode.com/problems/maximal-square

     Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

     For example, given the following matrix:

     1 0 1 0 0
     1 0 1 1 1
     1 1 1 1 1
     1 0 0 1 0

     Return 4.
     * */
    private int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;

        int[][] opts = new int[height][width];
        int max = 0;
        for(int i = 0; i < width; i++) {
            opts[0][i] = matrix[0][i] - '0';
            max = Math.max(opts[0][i], max);
        }
        for(int i = 0; i < height; i++) {
            opts[i][0] = matrix[i][0] - '0';
            max = Math.max(opts[i][0], max);
        }

        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if (matrix[i][j] == '0') {
                    opts[i][j] = 0;
                } else {
                    opts[i][j] = min3(opts[i][j-1], opts[i-1][j], opts[i-1][j-1]) + 1;
                    max = Math.max(max, opts[i][j]);
                }
            }
        }
        return max * max;
    }

}
