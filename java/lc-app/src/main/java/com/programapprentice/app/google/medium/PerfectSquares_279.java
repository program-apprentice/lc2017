package com.programapprentice.app.google.medium;

import java.util.*;

public class PerfectSquares_279 {
    /**
     https://leetcode.com/problems/perfect-squares/description/
     Given a positive integer n, find the least number of perfect
     square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

     For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
     given n = 13, return 2 because 13 = 4 + 9.
     * */
    public List<Integer> getSquaresHitLTE(int n) {
        double x = Math.sqrt(n);
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i <= x; i++) {
            result.add(i*i);
        }
        return result;
    }

    private Map<Integer, Integer> records = new HashMap<Integer, Integer>();

    public int numSquaresHitLTE(int n) {
        List<Integer> squares = getSquaresHitLTE(n);
        return numSquaresHitLTE(n, squares);
    }

    public int numSquaresHitLTE(int n, List<Integer> squares) {
        int min = Integer.MAX_VALUE;

        for(int square : squares) {
            if (n > square) {
                min = Math.min(min, numSquaresHitLTE(n-square, squares) + 1);
            } else if (n == square) {
                min = 1;
            }
        }

        return min;
    }
    //////////// Above implementation hit LTE //////////////////
    public Set<Integer> getSquaresMap(int n) {
        double x = Math.sqrt(n);
        Set<Integer> result = new HashSet<Integer>();
        for(int i = 1; i <= x; i++) {
            result.add(i*i);
        }
        return result;
    }

    public int numSquares(int n) {
        int[] records = new int[n+1];
        for(int i = 0; i <= n; i++) {
            records[i] = Integer.MAX_VALUE;
        }
        Set<Integer> squares = getSquaresMap(n);
        records[1] = 1;
        for(int i = 2; i <= n; i++) {
            records[i] = numSquares(i, records, squares);
        }
        return numSquares(n, records, squares);
    }

    public int numSquares(int n, int[] records, Set<Integer> squares) {
        for(Integer square :squares) {
            if (n > square) {
                records[n] = Math.min(records[n-square] + 1, records[n]);
            } else if (n == square) {
                records[n] = 1;
            }
        }
        return records[n];
    }
}
