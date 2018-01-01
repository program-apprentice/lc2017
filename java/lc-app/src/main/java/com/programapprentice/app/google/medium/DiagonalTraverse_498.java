package com.programapprentice.app.google.medium;

public class DiagonalTraverse_498 {
    /**
     https://leetcode.com/problems/diagonal-traverse/description/
     Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

     Example:
     Input:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     Output:  [1,2,4,7,5,3,6,8,9]
     Solution:
     http://www.cnblogs.com/grandyang/p/6414461.html
     * */

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }

        int height = matrix.length;
        int width = matrix[0].length;
        int[] result = new int[height * width];
        int[][] directions = { {-1, 1}, {1, -1}};
        int row = 0;
        int col = 0;
        int k = 0; // 0 move up, 1 move down;
        for(int i = 0; i < height * width; i++) {
            result[i] = matrix[row][col];
            row += directions[k][0];
            col += directions[k][1];
            if (row >= height) {
                k = 1 - k;
                row = height - 1;
                col += 2;
            }
            if (col >= width) {
                k = 1 - k;
                col = width - 1;
                row += 2;
            }
            if (row < 0) {
                k = 1 - k;
                row = 0;
            }
            if (col < 0) {
                k = 1 - k;
                col = 0;
            }
        }
        return result;
    }
}

/*

            if (r >= m) {r = m - 1; c += 2; k = 1 - k;}
            if (c >= n) {c = n - 1; r += 2; k = 1 - k;}
            if (r < 0) {r = 0; k = 1 - k;}
            if (c < 0) {c = 0; k = 1 - k;}
        }
        return res;
    }
};
* */