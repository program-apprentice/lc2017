package com.programapprentice.app.google.hard;

public class LongestIncreasingPathInAMatrix_329 {
    /**
     https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
     Given an integer matrix, find the length of the longest increasing path.

     From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

     Example 1:

     nums = [
     [9,9,4],
     [6,6,8],
     [2,1,1]
     ]
     Return 4
     The longest increasing path is [1, 2, 6, 9].

     Example 2:

     nums = [
     [3,4,5],
     [3,2,6],
     [2,2,1]
     ]
     Return 4
     The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
     * */

    int[][] directions  = { {0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int result = 0;
        int[][] opts = new int[height][width];
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result = Math.max(result, dfs(matrix, opts, i, j));
            }
        }
        return result;
    }

    public int dfs(int[][] matrix, int[][] opts, int i, int j) {
        if (opts[i][j] != 0) {
            return opts[i][j];
        }

        int mx = 1;
        int height = matrix.length;
        int width = matrix[0].length;

        for(int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (ni >= 0 && ni < height && nj >= 0 && nj < width) {
                if (matrix[ni][nj] >= matrix[i][j]) {
                    continue;
                } else {
                    int len = 1 + dfs(matrix, opts, ni, nj);
                    mx = Math.max(mx, len);
                }
            }
        }
        opts[i][j] = mx;
        return mx;
    }
}
