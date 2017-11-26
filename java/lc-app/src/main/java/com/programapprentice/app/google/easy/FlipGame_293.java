package com.programapprentice.app.google.easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_293 {
    /**
     https://leetcode.com/problems/flip-game/description/
     You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
     + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

     Write a function to compute all possible states of the string after one valid move.

     For example, given s = "++++", after one move, it may become one of the following states:

     [
     "--++",
     "+--+",
     "++--"
     ]
     If there is no valid move, return an empty list [].

     * */
    public boolean isFlippable(char a, char b) {
        if (a == '+' && b == '+') {
            return true;
        }
        return false;
    }

    public char flip(char c) {
        if (c == '+') {
            return '-';
        } else {
            return c;
        }
    }

    public List<String> generatePossibleNextMoves(String s) {
         List<String> result = new ArrayList<String>();
         if (s.length() < 2) {
             return result;
         }
         char[] cs = s.toCharArray();
         for(int i = 1; i < s.length(); i++) {
             char pre = cs[i-1];
             char cur = cs[i];
             boolean isValid = isFlippable(pre, cur);
             if (isValid) {
                 cs[i-1] = flip(cs[i-1]);
                 cs[i] = flip(cs[i]);
                 result.add(new String(cs));
                 cs[i-1] = pre;
                 cs[i] = cur;
             }
         }
         return result;
    }
}
