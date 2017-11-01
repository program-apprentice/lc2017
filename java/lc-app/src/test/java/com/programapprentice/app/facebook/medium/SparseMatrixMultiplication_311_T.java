package com.programapprentice.app.facebook.medium;

import org.junit.Test;

public class SparseMatrixMultiplication_311_T {
    SparseMatrixMultiplication_311 solution = new SparseMatrixMultiplication_311();

    @Test
    public void test1() {
        int[][] A = {{1, -5}};
        int[][] B = {{12}, {-5}};
        int[][] C = solution.multiply(A, B);
        System.out.println(C[0][0]);
    }
}
