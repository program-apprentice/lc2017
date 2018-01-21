package com.programapprentice.app.google.medium;

public class FlipGameII_294 {
    /**
     https://leetcode.com/problems/flip-game-ii/description/

     You are playing the following Flip Game with your friend: Given a string that
     contains only these two characters: + and -, you and your friend take turns to
     flip two consecutive "++" into "--". The game ends when a person can no longer
     make a move and therefore the other person will be the winner.

     Write a function to determine if the starting player can guarantee a win.

     For example, given s = "++++", return true. The starting player can guarantee a
     win by flipping the middle "++" to become "+--+".

     Follow up:
     Derive your algorithm's runtime complexity.


     * */
    public boolean canWin(String s) {
        int start = -1;
        int nextIndex = 0;
        nextIndex = s.indexOf("++", start+1);
        while (nextIndex >= 0) {
            String newString = s.substring(0, nextIndex) + "--" + s.substring(nextIndex+2);
            if (!canWin(newString)) {
                return true;
            }
            start = nextIndex;
            nextIndex = s.indexOf("++", start+1);
        }
        return false;
    }
}
