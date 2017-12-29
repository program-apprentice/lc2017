package com.programapprentice.app.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {
    /**
     https://leetcode.com/problems/01-matrix/description/
     Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

     The distance between two adjacent cells is 1.

     Example 1:
     Input:
     0 0 0
     0 1 0
     0 0 0
     Output:
     0 0 0
     0 1 0
     0 0 0

     Example 2:
     Input:
     0 0 0
     0 1 0
     1 1 1
     Output:
     0 0 0
     0 1 0
     1 2 1
     Note:
     The number of elements of the given matrix will not exceed 10,000.
     There are at least one 0 in the given matrix.
     The cells are adjacent in only four directions: up, down, left and right.

     Solution: BFS
     http://www.cnblogs.com/grandyang/p/6602288.html
     * */
    class Point {
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] newMatrix = new int [height][width];
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            // up
            if (p.x > 0 && matrix[p.x-1][p.y] > matrix[p.x][p.y])  {
                matrix[p.x-1][p.y] = matrix[p.x][p.y] + 1;
                queue.add(new Point(p.x-1, p.y));
            }
            // down
            if (p.x < height-1 && matrix[p.x+1][p.y] > matrix[p.x][p.y])  {
                matrix[p.x+1][p.y] = matrix[p.x][p.y] + 1;
                queue.add(new Point(p.x+1, p.y));
            }
            // left
            if (p.y > 0 && matrix[p.x][p.y-1] > matrix[p.x][p.y])  {
                matrix[p.x][p.y-1] = matrix[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y-1));
            }
            // right
            if (p.y < width-1 && matrix[p.x][p.y+1] > matrix[p.x][p.y])  {
                matrix[p.x][p.y+1] = matrix[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y+1));
            }
        }
        return matrix;
    }
}