package com.programapprentice.app.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SparseMatrixMultiplication_311 {
    /**
    https://leetcode.com/problems/sparse-matrix-multiplication/description/
    Given two sparse matrices A and B, return the result of AB.

    You may assume that A's column number is equal to B's row number.

            Example:

    A = [
            [ 1, 0, 0],
            [-1, 0, 3]
            ]

    B = [
            [ 7, 0, 0 ],
            [ 0, 0, 0 ],
            [ 0, 0, 1 ]
            ]


            |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
            | 0 0 1 |
    */

    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return new int[0][0];
        }
        if (B == null || B.length == 0 || B[0] == null || B[0].length == 0) {
            return new int[0][0];
        }
        int aHeight = A.length;
        int aWidth = A[0].length;
        int bHeight = B.length;
        int bWidth = B[0].length;
        int[][] C = new int[aHeight][aWidth];
        List<HashMap<Integer, Integer>> aIdxToValMaps = new ArrayList<HashMap<Integer, Integer>>();
        for(int i = 0; i < aHeight; i++) {
            aIdxToValMaps.add(new HashMap<Integer, Integer>());
        }
        for(int i = 0; i < aHeight; i++) {
            HashMap<Integer, Integer> aIdxToValMap = aIdxToValMaps.get(i);
            for(int j = 0; j < aWidth; j++) {
                if (A[i][j] != 0) {
                    aIdxToValMap.put(j, A[i][j]);
                }
            }
        }

        List<HashMap<Integer, Integer>> bIdxToValMaps = new ArrayList<HashMap<Integer, Integer>>();
        for(int i = 0; i < bWidth; i++) {
            bIdxToValMaps.add(new HashMap<Integer, Integer>());
        }
        for(int i = 0; i < bWidth; i++) {
            HashMap<Integer, Integer> bIdxToValMap = bIdxToValMaps.get(i);
            for(int j = 0; j < bHeight; j++) {
                if (B[j][i] != 0) {
                    bIdxToValMap.put(j, B[j][i]);
                }
            }
        }

        for(int i = 0; i < aHeight; i++) {
            HashMap<Integer, Integer> aIdxToVal = aIdxToValMaps.get(i);
            for(int j = 0; j < aWidth; j++) {
                int sum = 0;
                HashMap<Integer, Integer> bIdxToVal = bIdxToValMaps.get(j);
                for(Integer aKey : aIdxToVal.keySet()) {
                    if (bIdxToVal.get(aKey) != null) {
                        sum += aIdxToVal.get(aKey) * bIdxToVal.get(aKey);
                    }
                }
                C[i][j] = sum;
            }

        }
        return C;
    }
}
