package com.programapprentice.app.google.easy;

import java.util.HashMap;
import java.util.HashSet;

public class JudgeRouteCircle_657 {
    /**
     https://leetcode.com/problems/judge-route-circle/description/

     Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

     The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

     Example 1:
     Input: "UD"
     Output: true
     Example 2:
     Input: "LL"
     Output: false
     * */
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point step(Point cur, Character move) {
        switch(move) {
            case 'U':
                return new Point(cur.x, cur.y+1);
            case 'D':
                return new Point(cur.x, cur.y-1);
            case 'L':
                return new Point(cur.x-1, cur.y);
            case 'R':
                return new Point(cur.x+1, cur.y);
        }
        return null;
    }

    public boolean judgeCircle(String moves) {
        Point cur = new Point(0, 0);
        for(Character c : moves.toCharArray()) {
            cur = step(cur, c);
        }
        return cur.x == 0 &&  cur.y == 0;
    }
}
