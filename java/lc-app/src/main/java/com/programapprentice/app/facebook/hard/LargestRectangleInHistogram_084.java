package com.programapprentice.app.facebook.hard;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram_084 {
    /**
     https://leetcode.com/problems/largest-rectangle-in-histogram/description/

     Very detailed explanation for solution:

     http://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-set-1/ ( divide conquer solution, segment tree)

     http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
     http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/

     http://www.geeksforgeeks.org/largest-rectangle-under-histogram/ (O(n) solution)
     * */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int current = (i == height.length) ? -1 : height[i];
            while (!stack.empty() && current <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }
        return max;
    }
}
