package com.programapprentice.app.google.hard;

import java.util.HashMap;
import java.util.Map;

public class PerfectRectangle391 {
    /**
     http://www.cnblogs.com/grandyang/p/5825619.html
     Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

     Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


     Example 1:

     rectangles = [
     [1,1,3,3],
     [3,1,4,2],
     [3,2,4,4],
     [1,3,2,4],
     [2,3,3,4]
     ]

     Return true. All 5 rectangles together form an exact cover of a rectangular region.

     Example 2:

     rectangles = [
     [1,1,2,3],
     [1,3,2,4],
     [3,1,4,2],
     [3,2,4,4]
     ]

     Return false. Because there is a gap between the two rectangular regions.

     Example 3:

     rectangles = [
     [1,1,3,3],
     [3,1,4,2],
     [1,3,2,4],
     [3,2,4,4]
     ]

     Return false. Because there is a gap in the top center.

     Example 4:

     rectangles = [
     [1,1,3,3],
     [3,1,4,2],
     [1,3,2,4],
     [2,2,4,4]
     ]

     Return false. Because two of the rectangles overlap with each other.

     Solution:
     http://www.cnblogs.com/grandyang/p/5825619.html
     * */

    public boolean isRectangleCover(int[][] rectangles) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int area = 0;
        int count = 0;

        for (int[] rectangle : rectangles) {
            minX = Math.min(minX, rectangle[0]);
            minY = Math.min(minY, rectangle[1]);
            maxX = Math.max(maxX, rectangle[2]);
            maxY = Math.max(maxY, rectangle[3]);

            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            if (!isValid(map, Integer.toString(rectangle[0]) + "_" + Integer.toString(rectangle[1]), 1)) {
                return false; // bottom left
            }
            if (!isValid(map, Integer.toString(rectangle[0]) + "_" + Integer.toString(rectangle[3]), 2)) {
                return false; // top left
            }
            if (!isValid(map, Integer.toString(rectangle[2]) + "_" + Integer.toString(rectangle[3]), 4)) {
                return false; // top right
            }
            if (!isValid(map, Integer.toString(rectangle[2]) + "_" + Integer.toString(rectangle[1]), 8)) {
                return false; // bottom right
            }
        }
        for (String key : map.keySet()) {
            int t = map.get(key);
            if (t != 15 && t != 12 && t != 10 && t != 9 && t != 6 && t != 5 && t!= 3) {
                ++count;
            }
        }

        return count == 4 && area == (maxX - minX) * (maxY - minY);
    }

    boolean isValid(Map<String, Integer> map, String corner, int type) {
        int val = map.get(corner) == null ? 0 : map.get(corner);
        if ((val & type) == 1) {
            return false;
        }
        val |= type;
        map.put(corner, val);
        return true;
    }

}
