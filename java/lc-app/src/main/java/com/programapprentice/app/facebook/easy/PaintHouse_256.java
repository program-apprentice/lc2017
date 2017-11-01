package com.programapprentice.app.facebook.easy;

public class PaintHouse_256 {
    /**
     [256] Paint House

     https://leetcode.com/problems/paint-house

     There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
     The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

     The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
     For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
     Find the minimum cost to paint all houses.

     Note:
     All costs are positive integers.
     * */

    private int min4(int a, int b, int c, int d) {
        return Math.min(Math.min(a, Math.min(b, c)), d);
    }

    private int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int numOfHouses = costs.length;
        final int R = 0;
        final int B = 1;
        final int G = 2;
        if (costs.length == 1) {
            return min3(costs[numOfHouses-1][R], costs[numOfHouses-1][B], costs[numOfHouses-1][G]);
        }

        int[][] opts = new int[numOfHouses][3];
        opts[0][R] = costs[0][R];
        opts[0][B] = costs[0][B];
        opts[0][G] = costs[0][G];

        opts[1][R] = costs[1][R] + Math.min(costs[0][B], costs[0][G]);
        opts[1][B] = costs[1][B] + Math.min(costs[0][R], costs[0][G]);
        opts[1][G] = costs[1][G] + Math.min(costs[0][B], costs[0][R]);

        for (int i = 2; i < numOfHouses; i++) {
            opts[i][R] = costs[i][R] + min4(costs[i-1][B]+opts[i-2][G], costs[i-1][B]+opts[i-2][R], costs[i-1][G]+opts[i-2][B], costs[i-1][G]+opts[i-2][R]);
            opts[i][B] = costs[i][B] + min4(costs[i-1][R]+opts[i-2][G], costs[i-1][R]+opts[i-2][B], costs[i-1][G]+opts[i-2][B], costs[i-1][G]+opts[i-2][R]);
            opts[i][G] = costs[i][G] + min4(costs[i-1][B]+opts[i-2][R], costs[i-1][B]+opts[i-2][G], costs[i-1][R]+opts[i-2][B], costs[i-1][R]+opts[i-2][G]);
        }

        return min3(opts[numOfHouses-1][R], opts[numOfHouses-1][B], opts[numOfHouses-1][G]);
    }
}
