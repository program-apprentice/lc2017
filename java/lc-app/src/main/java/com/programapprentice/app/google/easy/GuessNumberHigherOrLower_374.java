package com.programapprentice.app.google.easy;

public class GuessNumberHigherOrLower_374 {
    /**
     https://leetcode.com/problems/guess-number-higher-or-lower/description/
     We are playing the Guess Game. The game is as follows:

     I pick a number from 1 to n. You have to guess which number I picked.

     Every time you guess wrong, I'll tell you whether the number is higher or lower.

     You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

     -1 : My number is lower
     1 : My number is higher
     0 : Congrats! You got it!
     Example:
     n = 10, I pick 6.

     Return 6.
     * */
    private int guess(int num) {
        return 1;
    }

    public int guessNumber(int n) {
        int guessFeedBack = guess(n);
        if (guessFeedBack == 0) {
            return n;
        }
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            guessFeedBack = guess(mid);
            if (guessFeedBack == 0) {
                return mid;
            }
            if (guessFeedBack == 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
