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

    class Point{
        int row;
        int col;
        Point(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }

    private boolean isRoomOrGate(int row, int col, int[][] rooms) {
        return rooms[row][col] != -1;
    }

    private void fillOneRoom(int row, int col, int[][] rooms) {
        if (rooms[row][col] == 0 || rooms[row][col] == -1) {
            return;// wall or gate, no need to change
        }
        Queue<Point> queue = new LinkedList<Point>();
        Queue<Integer> lengths = new LinkedList<Integer>();
        queue.add(new Point(row, col));
        lengths.add(0);
        int height = rooms.length;
        int width = rooms[0].length;
        boolean[][] rec = new boolean[height][width];
        while(!queue.isEmpty()) {
            Point cur = queue.remove();
            int length = lengths.remove();
            rec[cur.row][cur.col] = true;
            if (rooms[cur.row][cur.col] == 0) {
                // is gate
                rooms[row][col] = length;
                return;
            }

            // left
            if (cur.col-1 >= 0 && isRoomOrGate(cur.row, cur.col-1, rooms) && !rec[cur.row][cur.col-1]) {
                queue.add(new Point(cur.row, cur.col-1));
                lengths.add(length+1);
            }

            // right
            if (cur.col+1 < width && isRoomOrGate(cur.row, cur.col+1, rooms)  && !rec[cur.row][cur.col+1]) {
                queue.add(new Point(cur.row, cur.col+1));
                lengths.add(length+1);
            }

            // down
            if (cur.row+1 < height && isRoomOrGate(cur.row+1, cur.col, rooms)  && !rec[cur.row+1][cur.col]) {
                queue.add(new Point(cur.row+1, cur.col));
                lengths.add(length+1);
            }

            // up
            if (cur.row-1 >= 0 && isRoomOrGate(cur.row-1, cur.col, rooms) && !rec[cur.row-1][cur.col]) {
                queue.add(new Point(cur.row-1, cur.col));
                lengths.add(length+1);
            }
        }
    }


    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        int height = rooms.length;
        int width = rooms[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                fillOneRoom(i, j, rooms);
            }
        }
    }
}
