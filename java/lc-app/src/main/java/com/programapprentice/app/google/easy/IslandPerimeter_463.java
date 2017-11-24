package com.programapprentice.app.google.easy;

public class IslandPerimeter_463 {
    /**
     https://leetcode.com/problems/island-perimeter/description/
     * */
    public int validEdgeNumber(int[][] grid, int i, int j) {
        int sum = 4;
        // left
        if (j > 0 && grid[i][j-1] == 1) {
            sum --;
        }
        // right
        if (j < grid[0].length-1 && grid[i][j+1] == 1) {
            sum--;
        }
        // up
        if (i > 0 && grid[i-1][j] == 1) {
            sum --;
        }
        // down
        if (i < grid.length-1 && grid[i+1][j] == 1) {
            sum --;
        }
        return sum;
    }

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum += validEdgeNumber(grid, i, j);
                }
            }
        }
        return sum;
    }
}
