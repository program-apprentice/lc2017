package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {
    /**
     https://leetcode.com/problems/pacific-atlantic-water-flow/description/
     Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
     the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right
     and bottom edges.

     Water can only flow in four directions (up, down, left, or right) from a cell to another one with height
     equal or lower.

     Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

     Note:
     The order of returned grid coordinates does not matter.
     Both m and n are less than 150.
     Example:

     Given the following 5x5 matrix:

     Pacific ~   ~   ~   ~   ~
     ~  1   2   2   3  (5) *
     ~  3   2   3  (4) (4) *
     ~  2   4  (5)  3   1  *
     ~ (6) (7)  1   4   5  *
     ~ (5)  1   1   2   4  *
     *   *   *   *   * Atlantic

     Return:

     [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

     Solution:
     http://blog.csdn.net/mebiuw/article/details/52766269
     * */

    private List<int[]> findIntersection(boolean[][] pacific, boolean[][] atlantic) {
        List<int[]> result = new ArrayList<int[]>();
        for(int row = 0; row < atlantic.length; row++) {
            for(int col = 0; col < atlantic[0].length; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    int[] item = new int[2];
                    item[0] = row;
                    item[1] = col;
                    result.add(item);
                }
            }
        }
        return result;
    }
    int dx[] = {0, 0, -1, 1};
    int dy[] = {1, -1, 0, 0};

    private void flow(boolean[][] visited, int[][] matrix, int x, int y, int height, int width) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) { // four directions
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < height && ny >= 0 && ny < width) {
                if (visited[nx][ny] == false && matrix[nx][ny] >= matrix[x][y]) {
                    flow(visited, matrix, nx, ny, height, width);
                }
            }
        }
    }


    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new ArrayList<int[]>();
        }
        int height = matrix.length;
        int width = matrix[0].length;
        boolean[][] pacific =  new boolean[height][width];
        boolean[][] atlantic =  new boolean[height][width];

        for (int i = 0; i < height; i++) {
            flow(pacific, matrix, i, 0, height, width);
            flow(atlantic, matrix, i, width - 1, height, width);
        }

        for (int j = 0; j < width; j++) {
            flow(pacific, matrix, 0, j, height, width);
            flow(atlantic, matrix, height-1, j, height, width);
        }

        return findIntersection(pacific, atlantic);
    }
}
