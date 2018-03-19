package com.programapprentice.app.google.hard;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestRectangleEnclosingBlackPixels_302 {
    /**
     https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/description/
     An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
     The black pixels are connected, i.e., there is only one black region.
     Pixels are connected horizontally and vertically.
     Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

     For example, given the following image:

     [
     "0010",
     "0110",
     "0100"
     ]
     and x = 0, y = 2,
     Return 6.

     * */
    int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, { 0, -1}};
    public int minArea(char[][] image, int x, int y) {
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = 0;
        int minWidth = Integer.MAX_VALUE;
        int maxWidth = 0;
        int height = image.length;
        int width = image[0].length;
        boolean[][] visited = new boolean[height][width];
        Queue<Integer> rowQueue = new LinkedList<Integer>();
        Queue<Integer> colQueue = new LinkedList<Integer>();
        rowQueue.add(x);
        colQueue.add(y);
        while(!rowQueue.isEmpty()) {
            int row = rowQueue.remove();
            int col = colQueue.remove();
            minHeight = Math.min(row, minHeight);
            minWidth = Math.min(col, minWidth);
            maxHeight = Math.max(row, maxHeight);
            maxWidth = Math.max(col, maxWidth);
            for (int[] direction : directions) {
                int newRow = direction[0] + row;
                int newCol = direction[1] + col;
                if (newRow >= 0 && newRow < height && newCol < width && newCol >= 0) {
                    if (visited[newRow][newCol]) {
                        continue;
                    } else {
                        if (image[newRow][newCol] == '1') {
                            visited[newRow][newCol] = true;
                            rowQueue.add(newRow);
                            colQueue.add(newCol);
                        }
                    }
                }
            }
        }

        return (maxHeight - minHeight + 1) * (maxWidth - minWidth + 1);
    }
}
