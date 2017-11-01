package com.programapprentice.app.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_200 {
    /**
     [200] Number of Islands

     https://leetcode.com/problems/number-of-islands

     Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

     Example 1:
     11110
     11010
     11000
     00000

     Answer: 1

     Example 2:
     11000
     11000
     00100
     00011

     Answer: 3
     * */

    class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void markIslands(int i, int j, char[][] grid, boolean[][] rec, int height, int width) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(i, j));
        rec[i][j] = true;
        while(!queue.isEmpty()) {
            Point cur = queue.remove();
            i = cur.i;
            j = cur.j;
            // left
            if (j > 0 && grid[i][j-1] == '1' && !rec[i][j-1]) {
                queue.add(new Point(i, j-1));
                rec[i][j-1] = true;
            }
            // right
            if (j < width-1  && grid[i][j+1] == '1' && !rec[i][j+1]) {
                queue.add(new Point(i, j+1));
                rec[i][j+1] = true;
            }
            // down
            if(i < height-1 && grid[i+1][j] == '1' && !rec[i+1][j]) {
                queue.add(new Point(i+1, j));
                rec[i+1][j] = true;
            }
            // up
            if (i > 0 && grid[i-1][j] == '1' && !rec[i-1][j]) {
                queue.add(new Point(i-1, j));
                rec[i-1][j] = true;
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        boolean[][] rec = new boolean[height][width];
        int count = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if (grid[i][j] == '1' && !rec[i][j]) {
                    markIslands(i, j, grid, rec, height, width);
                    count++;
                }
            }
        }

        return count;
    }

}
