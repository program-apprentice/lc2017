package com.programapprentice.app.google.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII_407 {
    /**
     https://leetcode.com/problems/trapping-rain-water-ii/description/

     Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

     Note:
     Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

     Example:

     Given the following 3x6 height map:
     [
       [1,4,3,1,3,2],
       [3,2,1,3,2,4],
       [2,3,3,2,3,1]
     ]

     Return 4.


     Solution:
     http://www.cnblogs.com/grandyang/p/5928987.html
     https://aaronice.gitbooks.io/lintcode/content/heap/trapping_rain_water_ii.html
     * */
    class Cell {
        public int x, y, height;

        public Cell() {
        }

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }

        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<Cell> minheap = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                if (c1.height > c2.height) {
                    return 1;
                } else if (c1.height < c2.height) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int[][] visited = new int[m][n];

        // put the border in the heap
        for(int i = 0; i < m; i++) {
            minheap.offer(new Cell(i, 0, heights[i][0]));
            minheap.offer(new Cell(i, n-1, heights[i][n-1]));
            visited[i][0] = 1;
            visited[i][n-1] = 1;
        }

        for (int j = 0; j < n; j++) {
            minheap.offer(new Cell(0, j, heights[0][j]));
            minheap.offer(new Cell(m-1, j, heights[m-1][j]));
            visited[0][j] = 1;
            visited[m-1][j] = 1;
        }

        int[] dirX = new int[] {0, 0, -1, 1};
        int[] dirY = new int[] {-1, 1, 0, 0};

        int result = 0;

        while (!minheap.isEmpty()) {
            Cell now = minheap.poll();

            // Check all four directions
            for (int k = 0; k < 4; k++) {
                int x = now.x + dirX[k];
                int y = now.y + dirY[k];

                if (x < m && x >= 0 && y < n && y >= 0 && visited[x][y] != 1) {
                    minheap.offer(new Cell(x, y, Math.max(now.height, heights[x][y])));
                    visited[x][y] = 1;

                    result += Math.max(0, now.height - heights[x][y]);
                }

            }
        }

        return result;
    }


}
