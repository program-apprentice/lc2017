package com.programapprentice.app.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Maze_490 {
    /**
     https://leetcode.com/problems/the-maze/description/

     Solution:
     http://www.cnblogs.com/grandyang/p/6381458.html
     * */
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return true;
        }
        int height = maze.length;
        int width = maze[0].length;
        boolean[][] visited = new boolean[height][width];
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(start[1], start[0]));
        visited[start[0]][start[1]] = true;
        int x, y;

        while(!queue.isEmpty()) {
            Pair node = queue.remove();
            if (node.x == destination[1] && node.y == destination[0]) {
                return true;
            }
            // up
            x = node.x;
            y = node.y;
            while(y >= 0 && maze[y][x] == 0) {
                y--;
            }
            y++;
            if (!visited[y][x]) {
                visited[y][x] = true;
                queue.add(new Pair(x, y));
            }

            // down
            x = node.x;
            y = node.y;
            while(y < height && maze[y][x] == 0) {
                y++;
            }
            y--;
            if (!visited[y][x]) {
                visited[y][x] = true;
                queue.add(new Pair(x, y));
            }

            // left
            x = node.x;
            y = node.y;
            while(x >= 0 && maze[y][x] == 0) {
                x--;
            }
            x++;
            if (!visited[y][x]) {
                visited[y][x] = true;
                queue.add(new Pair(x, y));
            }

            // right
            x = node.x;
            y = node.y;
            while(x < width && maze[y][x] == 0) {
                x++;
            }
            x--;
            if (!visited[y][x]) {
                visited[y][x] = true;
                queue.add(new Pair(x, y));
            }
        }
        return false;
    }

}
