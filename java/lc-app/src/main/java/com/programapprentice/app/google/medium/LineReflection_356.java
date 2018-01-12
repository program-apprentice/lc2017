package com.programapprentice.app.google.medium;

import java.util.*;

public class LineReflection_356 {
    /**
     https://leetcode.com/problems/line-reflection/description/
     Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

     Example 1:
     Given points = [[1,1],[-1,1]], return true.

     Example 2:
     Given points = [[1,1],[-1,-1]], return false.

     Follow up:
     Could you do better than O(n^2)?
     * */
    public boolean isReflected(int[][] points) {
        int n = points.length;
        int minx = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> xToIdxMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n; i++) {
            int[] p = points[i];
            minx = Math.min(minx, p[0]);
            maxx = Math.max(maxx, p[0]);
            List<Integer> set = xToIdxMap.get(p[0]) == null ? new ArrayList<Integer>() : xToIdxMap.get(p[0]);
            set.add(i);
            xToIdxMap.put(p[0], set);
        }
        double mid = ((double)minx + (double)maxx) / 2;
        for(int i = 0; i < n; i++) {
            int[] p = points[i];
            int opx = (int)(2 * mid - p[0]);
            if (xToIdxMap.get(opx) == null) {
                return false;
            }
            boolean isExist = false;
            for(int idx : xToIdxMap.get(opx)) {
                if (points[idx][1] == p[1]) {
                    isExist = true;
                }
            }
            if (!isExist) {
                return false;
            }
        }

        return true;
    }
}