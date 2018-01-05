package com.programapprentice.app.google.medium;

import java.util.List;

public class ConvexPolygon_469 {
    /**
     https://leetcode.com/problems/convex-polygon/description/

     Solution:
     http://www.cnblogs.com/grandyang/p/6146986.html
     * */
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long pre = 0;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            int first = (i + 1) % n;
            int second = (i + 2) % n;
            long dx1 = points.get(first).get(0) - points.get(i).get(0);
            long dy1 = points.get(first).get(1) - points.get(i).get(1);

            long dx2 = points.get(second).get(0) - points.get(i).get(0);
            long dy2 = points.get(second).get(1) - points.get(i).get(1);

            cur = (dx1 * dy2) - (dx2 * dy1);
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                } else {
                    pre = cur;
                }
            }
        }
        return true;
    }
}
