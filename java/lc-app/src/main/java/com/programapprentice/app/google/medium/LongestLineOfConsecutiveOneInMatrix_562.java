package com.programapprentice.app.google.medium;

public class LongestLineOfConsecutiveOneInMatrix_562 {
    /**
     https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/description/

     Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal,
     vertical, diagonal or anti-diagonal.
     Example:
     Input:
     [[0,1,1,0],
     [0,1,1,0],
     [0,0,0,1]]
     Output: 3
     Hint: The number of elements in the given matrix will not exceed 10,000.
     * */
    public int longestLine(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int maxLine = 0;
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int y = i+1;
                    int x = j+1;

                    int count = 1;
                    // horizontol
                    while(x < width) {
                        if (matrix[i][x] == 1) {
                            count ++;
                        } else {
                            break;
                        }
                        x++;
                    }
                    maxLine = Math.max(maxLine, count);

                    count = 1;
                    // vertical
                    while(y < height) {
                        if (matrix[y][j] == 1) {
                            count ++;
                        } else {
                            break;
                        }
                        y++;
                    }
                    maxLine = Math.max(maxLine, count);

                    count = 1;
                    // diagonal
                    y = i+1;
                    x = j+1;
                    while(x < width && y < height) {
                        if (matrix[y][x] == 1) {
                            count ++;
                        } else {
                            break;
                        }
                        y++;
                        x++;
                    }
                    maxLine = Math.max(maxLine, count);

                    // anti diagonal
                    y = i+1;
                    x = j-1;
                    count = 1;
                    while(x >= 0 && y < height) {
                        if (matrix[y][x] == 1) {
                            count ++;
                        } else {
                            break;
                        }
                        y++;
                        x--;
                    }
                    maxLine = Math.max(maxLine, count);

                }
            }
        }
        return maxLine;
    }

}
