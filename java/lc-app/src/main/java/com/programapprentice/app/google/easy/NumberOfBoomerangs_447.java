package com.programapprentice.app.google.easy;

import java.util.HashMap;

public class NumberOfBoomerangs_447 {
    /**
     https://leetcode.com/problems/number-of-boomerangs/description/
     * */
    public long calDistanceSquare(int[] a, int[] b) {
        long xDist = a[0] - b[0];
        long yDist = a[1] - b[1];
        return xDist * xDist + yDist * yDist;
    }

    public int findCombination(long[] distances) {
        HashMap<Long, Integer> distanceCounter = new HashMap<Long, Integer>();
        for(long dist : distances) {
            int count = distanceCounter.containsKey(dist) ? distanceCounter.get(dist) : 0;
            count++;
            distanceCounter.put(dist, count);
        }
        int result = 0;
        for(long dist : distanceCounter.keySet()) {
            int count = distanceCounter.get(dist);
            if (count > 1) {
                result += count * (count-1);
            }
        }
        return result;
    }

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        long[][] distances = new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                long dist = calDistanceSquare(points[i], points[j]);
                distances[i][j] = dist;
                distances[j][i] = dist;
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            result += findCombination(distances[i]);
        }
        return result;
    }
}
