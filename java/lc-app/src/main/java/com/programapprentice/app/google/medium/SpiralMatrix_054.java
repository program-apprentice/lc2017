package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_054 {
    /**
     https://leetcode.com/problems/spiral-matrix/description/
     Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     For example,
     Given the following matrix:

     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     You should return [1,2,3,6,9,8,7,4,5].
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = 0;

        while(true) {
            for(int n = 0; n < col; n++) {
                list.add(matrix[i][j]);
                j++;
            }
            j--;
            row --;
            if(row == 0) {
                break;
            }

            i++;
            for(int n = 0; n < row; n++) {
                list.add(matrix[i][j]);
                i++;
            }
            i--;

            col--;
            if(col == 0) {
                break;
            }

            j--;
            for(int n = 0; n < col; n++ ) {
                list.add(matrix[i][j]);
                j--;
            }
            j++;

            row--;
            if(row == 0) {
                break;
            }

            i--;
            for(int n = 0; n < row; n++) {
                list.add(matrix[i][j]);
                i--;
            }
            i++;
            j = i;
            col--;
            if(col == 0) {
                break;
            }
        }

        return list;
    }
}
