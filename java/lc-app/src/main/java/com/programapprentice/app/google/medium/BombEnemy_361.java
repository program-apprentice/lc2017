package com.programapprentice.app.google.medium;

public class BombEnemy_361 {
    /**
     https://leetcode.com/problems/bomb-enemy/description/
     Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero),
     return the maximum enemies you can kill using one bomb.
     The bomb kills all the enemies in the same row and column from the planted point until it hits
     the wall since the wall is too strong to be destroyed.
     Note that you can only put the bomb at an empty cell.

     Example:
     For the given grid

     0 E 0 0
     E 0 W E
     0 E 0 0

     return 3. (Placing a bomb at (1,1) kills 3 enemies)
     Credits:
     Special thanks to @memoryless for adding this problem and creating all test cases.
     * */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        int height = grid.length;
        int width = grid[0].length;
        int[][] left = new int[height][width];
        int[][] right = new int[height][width];
        int[][] up = new int[height][width];
        int[][] down = new int[height][width];
        int t = 0;
        for(int i = 0; i < height; i++) {
            t = 0;
            for(int j = 0; j < width; j++) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                    t = 0;
                } else if (grid[i][j] == 'E') {
                    t++;
                    left[i][j] = 0;
                } else {
                    left[i][j] = t;
                }
            }
            t = 0;
            for(int j = width-1; j >= 0; j--) {

                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                    t = 0;
                } else if (grid[i][j] == 'E') {
                    t++;
                    right[i][j] = 0;
                } else {
                    right[i][j] = t;
                }
            }
        }
        for(int j = 0; j < width; j++) {
            t = 0;
            for(int i = 0; i < height; i++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    t = 0;
                } else if (grid[i][j] == 'E') {
                    t++;
                    up[i][j] = 0;
                } else {
                    up[i][j] = t;
                }
            }
            t = 0;
            for(int i = height-1; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    t = 0;
                } else if (grid[i][j] == 'E') {
                    t++;
                    down[i][j] = 0;
                } else {
                    down[i][j] = t;
                }
            }
        }

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (grid[i][j] == '0') {
                    result = Math.max(result, left[i][j] + right[i][j] + up[i][j] + down[i][j]);
                }
            }
        }
        return result;
    }
}
