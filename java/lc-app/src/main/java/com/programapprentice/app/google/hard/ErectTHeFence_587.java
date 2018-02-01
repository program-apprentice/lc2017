package com.programapprentice.app.google.hard;

import com.programapprentice.app.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ErectTHeFence_587 {
    /**
     https://leetcode.com/problems/erect-the-fence/description/
     There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.

     Example 1:
     Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
     Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
     Explanation:

     Example 2:
     Input: [[1,2],[2,2],[4,2]]
     Output: [[1,2],[2,2],[4,2]]
     Explanation:

     Even you only have trees in a line, you need to use rope to enclose them.
     Note:

     All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
     All input integers will range from 0 to 100.
     The garden has at least one tree.
     All coordinates are distinct.
     Input points have NO order. No order required for output.

     Solution:
     http://www.cnblogs.com/weedboy/p/6896478.html
     http://www.7zhang.com/index/cms/read/id/327304.html (凸包的解决办法)
     * */

    //convex hull graham scan
    public List<Point> outerTrees(Point[] points) {
        int n = points.length;
        if (n <= 2) {
            return Arrays.asList(points);
        }
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o1.y != o2.y ? o1.y - o2.y : o1.x - o2.x;
            }
        });

        int[] stack = new int[n+2];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while(p >= 2 && cross(points[i], points[stack[p-2]], points[stack[p-1]]) < 0) {
                p--;
            }
            stack[p] = i;
            p++;
        }

        int inf = p + 1;
        for(int i = n-2; i >= 0; i--) {
            if (equal(points[stack[p-2]], points[i])) {
                continue;
            }
            while( p >= inf && cross(points[i], points[stack[p-2]], points[stack[p-1]]) < 0) {
                p--;
            }
            stack[p] = i;
            p++;
        }

        int len = Math.max(p-1, 1);
        List<Point> ret = new ArrayList<Point>();
        for(int i = 0; i < len; i++) {
            ret.add(points[stack[i]]);
        }
        return ret;
    }

    private int cross(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    private boolean equal(Point a, Point b) {
        return a.x == b.x && a.y == b.y;
    }

}
