package com.programapprentice.app.facebook.hard;

public class PaintHouseII_265 {
    /**
     There are a row of n houses, each house can be painted with one of the k colors.
     The cost of painting each house with a certain color is different.
     You have to paint all the houses such that no two adjacent houses have the same color.

     The cost of painting each house with a certain color is represented by a n x k cost matrix.
     For example, costs[0][0] is the cost of painting house 0 with color 0;
     costs[1][2] is the cost of painting house 1 with color 2, and so on...
     Find the minimum cost to paint all houses.

     Note:
     All costs are positive integers.

     Follow up:
     Could you solve it in O(nk) runtime?
     * */

    public int minCostII(int[][] costs) {
      if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] opts = new int[n][k];
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int minColorIdx = -1;

        for(int i = 0; i < k; i++) {
            opts[0][i] = costs[0][i];
            if (min >= opts[0][i]) {
                min2 = min;
                min = costs[0][i];
                minColorIdx = i;
            } else {
                if (min2 > opts[0][i]) {
                    min2 = costs[0][i];
                }
            }
        }
        if (k == 1) {
            return min;
        }

        int newMin = Integer.MAX_VALUE;
        int newMinColorIdx = -1;
        int newMin2 = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) { // i is house
            for(int j = 0; j < k; j++) { // j is color
                if(minColorIdx != j) {
                    opts[i][j] = min + costs[i][j];
                } else {
                    opts[i][j] = min2 + costs[i][j];
                }
                if (newMin >= opts[i][j]) {
                    newMin2 = newMin;
                    newMin = opts[i][j];
                    newMinColorIdx = j;
                } else {
                    if (newMin2 > opts[i][j]) {
                        newMin2 = opts[i][j];
                    }
                }
            }
            min = newMin;
            minColorIdx = newMinColorIdx;
            min2 = newMin2;
            newMin = Integer.MAX_VALUE;
            newMin2 = Integer.MAX_VALUE;
        }

        min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) {
            if (min > opts[n-1][i]) {
                min = opts[n-1][i];
            }
        }

        return min;
    }
}
