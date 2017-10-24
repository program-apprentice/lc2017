package com.programapprentice.app.medium;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates_286 {
    /**
     https://leetcode.com/problems/walls-and-gates/description/

     You are given a m row n 2D grid initialized with these three possible values.

     -1 - A wall or an obstacle.
     0 - A gate.
     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
     Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

     For example, given the 2D grid:
     INF  -1  0  INF
     INF INF INF  -1
     INF  -1 INF  -1
     0    -1 INF INF

     After running your function, the 2D grid should be:
     3  -1   0   1
     2   2   1  -1
     1  -1   2  -1
     0  -1   3   4
     * */

    // The key is do it from door, so you can cut branch quickly
    public void dfs(int[][] rooms, int i, int j, int height, int width, int depth) {
        if (i < 0 || i >= height || j < 0 || j >= width || rooms[i][j] < depth || rooms[i][j] == -1) {
            return;
        }
        rooms[i][j] = depth;
        dfs(rooms, i-1, j, height, width, depth+1);
        dfs(rooms, i+1, j, height, width, depth+1);
        dfs(rooms, i, j+1, height, width, depth+1);
        dfs(rooms, i, j+1, height, width, depth+1);
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        int height = rooms.length;
        int width = rooms[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, height, width, 0);
                }
            }
        }
    }

}
