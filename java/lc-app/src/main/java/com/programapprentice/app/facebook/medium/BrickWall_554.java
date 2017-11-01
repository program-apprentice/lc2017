package com.programapprentice.app.facebook.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall_554 {
    /**
     [554] Brick Wall

     https://leetcode.com/problems/brick-wall

     There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
     The bricks have the same height but different width.
     You want to draw a vertical line from the top to the bottom and cross the least bricks.

     The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

     If your line go through the edge of a brick, then the brick is not considered as crossed.
     You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

     You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

     Example:

     Input:
     [[1,2,2,1],
      [3,1,2],
      [1,3,2],
      [2,4],
      [3,1,2],
      [1,3,1,1]]
     Output: 2
     Explanation:

     Note:

     The width sum of bricks in different rows are the same and won't exceed INT_MAX.
     The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
     * */
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0 || wall.get(0) == null || wall.get(0).size() == 0) {
            return 0;
        }

        Map<Integer, Integer> edgeToCount = new HashMap<Integer, Integer>();
        int totalLenth = 0;
        for(Integer level : wall.get(0)){
            totalLenth += level;
        }
        int numOfWalls = wall.size();

        for(List<Integer> level : wall) {
            int end = 0;
            for(Integer len : level) {
                end += len;
                Integer counter = edgeToCount.get(end);
                if (counter == null) {
                    counter = 1;
                } else {
                    counter += 1;
                }
                edgeToCount.put(end, counter);
            }
        }
        int min =Integer.MAX_VALUE;
        if (edgeToCount.size() == 1) {
            int val = 0;
            for(Integer key : edgeToCount.keySet()) {
                val = edgeToCount.get(key);
            }
            return val;
        }
        for(Integer key : edgeToCount.keySet()) {
            if(key == totalLenth) {
                continue;
            }
            min = Math.min(min, numOfWalls - edgeToCount.get(key));
        }
        return min;
    }

}
