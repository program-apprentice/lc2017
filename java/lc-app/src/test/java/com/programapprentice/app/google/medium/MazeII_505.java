package com.programapprentice.app.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MazeII_505 {
    /**
     https://leetcode.com/problems/the-maze-ii/description/

     Solution:
     http://www.cnblogs.com/grandyang/p/6725380.html
     * */

    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return 0;
        }
        int height = maze.length;
        int width = maze[0].length;
        boolean[][] visited = new boolean[height][width];
        int[][] dists = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                dists[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(start[1], start[0]));
        visited[start[0]][start[1]] = true;
        dists[start[0]][start[1]] = 0;

        int x, y, curDist;

        while(!queue.isEmpty()) {
            Pair node = queue.remove();
            // up
            x = node.x;
            y = node.y;
            curDist = dists[y][x];
            while(y >= 0 && maze[y][x] == 0) {
                y--;
                curDist++;
            }
            y++;
            curDist--;
            if (dists[y][x] > curDist) {
                dists[y][x] = curDist;
                if (x != destination[1] || y != destination[0]) {
                    queue.add(new Pair(x, y));
                }
            }

            // down
            x = node.x;
            y = node.y;
            curDist = dists[y][x];
            while(y < height && maze[y][x] == 0) {
                y++;
                curDist++;
            }
            y--;
            curDist--;
            if (dists[y][x] > curDist) {
                dists[y][x] = curDist;
                if (x != destination[1] || y != destination[0]) {
                    queue.add(new Pair(x, y));
                }
            }

            // left
            x = node.x;
            y = node.y;
            curDist = dists[y][x];
            while(x >= 0 && maze[y][x] == 0) {
                x--;
                curDist++;
            }
            x++;
            curDist--;
            if (dists[y][x] > curDist) {
                dists[y][x] = curDist;
                if (x != destination[1] || y != destination[0]) {
                    queue.add(new Pair(x, y));
                }
            }

            // right
            x = node.x;
            y = node.y;
            curDist = dists[y][x];
            while(x < width && maze[y][x] == 0) {
                x++;
                curDist++;
            }
            x--;
            curDist--;
            if (dists[y][x] > curDist) {
                dists[y][x] = curDist;
                if (x != destination[1] || y != destination[0]) {
                    queue.add(new Pair(x, y));
                }
            }
        }
        int res = dists[destination[0]][destination[1]];
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

}
