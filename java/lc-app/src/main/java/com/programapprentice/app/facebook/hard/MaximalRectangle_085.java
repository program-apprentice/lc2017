package com.programapprentice.app.facebook.hard;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle_085 {
    /**
     https://leetcode.com/problems/maximal-rectangle/description/
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

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] vertical = new int[height][width];
        for(int i = 0; i < width; i++) {
            vertical[height-1][i] = matrix[height-1][i] - '0';
        }
        for(int j = height-2; j >= 0; j--) {
            for(int i = 0; i < width; i++) {
                int cur = matrix[j][i] - '0';
                if (cur == 0) {
                    vertical[j][i] = 0;
                } else {
                    vertical[j][i] = vertical[j+1][i] + 1;
                }
            }
        }
        for(int i = 0; i < height; i++) {
            max = Math.max(max, largestRectangleArea(vertical[i]));
        }


        int[][] horizontal = new int[height][width];
        for(int i = 0; i < height; i++) {
            horizontal[i][width - 1] = matrix[i][width - 1] - '0';
        }

        for(int j = width-2; j >= 0; j--) {
            for(int i = 0; i < height; i++) {
                int cur = matrix[i][j] - '0';
                if (cur == 0) {
                    horizontal[i][j] = 0;
                } else {
                    horizontal[i][j] = horizontal[i][j+1] + 1;
                }
            }
        }
        for(int i = 0; i < width; i++) {
            int[] heights = new int[height];
            for(int j = 0; j < height; j++) {
                heights[j] = horizontal[j][i];
            }
            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;
    }
}
