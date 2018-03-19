package com.programapprentice.app.google.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuilding_317 {
    /**
     You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

     Each 0 marks an empty land which you can pass by freely.
     Each 1 marks a building which you cannot pass through.
     Each 2 marks an obstacle which you cannot pass through.
     For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

     1 - 0 - 2 - 0 - 1
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0
     The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

     Note:
     There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

     Solution:
     https://www.programcreek.com/2014/05/leetcode-shortest-distance-from-all-buildings-java/
     http://www.cnblogs.com/grandyang/p/5297683.html
     * */
    int[][] directions = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] distance;
    int[][] numReach; // track how many building can be visited from this empty cell.

    // This one hit Time Limit Exceed
    public int shortestDistance(int[][] grid) {
        int result = Integer.MAX_VALUE;
        int height = grid.length;
        int width = grid[0].length;
        distance = new int[height][width];
        numReach = new int[height][width]; // track how many building can be visited from this empty cell.

        int numOfBuildings = 0;
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) { // 1 is building
                    boolean[][] visited = new boolean[height][width];
                    Queue<Pair> queue = new LinkedList<Pair>();
                    bfs(grid, i,j, i, j, 0, visited, queue);
                    numOfBuildings++;

                }
            }
        }
        for(int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 0 && numReach[row][col] == numOfBuildings) {
                    result = Math.min(result, distance[row][col]);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

    public void bfs(int[][] grid, int ox, int oy, int i, int j, int distanceSoFar, boolean[][] visited, Queue<Pair> queue) {
        visit(grid, i, j, i, j, distanceSoFar, visited, queue);

        while(!queue.isEmpty()){
            int size = queue.size();
            distanceSoFar++;

            for(int k=0; k < size; k++){
                Pair pair = queue.poll();
                i = pair.row;
                j = pair.col;

                visit(grid, ox, oy, i-1, j, distanceSoFar, visited, queue);
                visit(grid, ox, oy, i+1, j, distanceSoFar, visited, queue);
                visit(grid, ox, oy, i, j-1, distanceSoFar, visited, queue);
                visit(grid, ox, oy, i, j+1, distanceSoFar, visited, queue);
            }

        }
    }

    public void visit(int[][] grid, int ox, int oy,  int i, int j, int distanceSoFar, boolean[][] visited, Queue<Pair> queue){
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n)
            return;

        if (visited[i][j]) {
            return;
        }

        if((i!=ox || j!=oy) && grid[i][j]!=0){
            return;
        }


        visited[i][j]=true;
        numReach[i][j]++;
        distance[i][j]+= distanceSoFar;
        queue.offer(new Pair(i, j));
    }

}
