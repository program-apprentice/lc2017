package com.programapprentice.app.easy;

public class PowerOfTwo_231 {
    /**
     [231] Power of Two

     https://leetcode.com/problems/power-of-two

     Given an integer, write a function to determine if it is a power of two.
     * */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        while (n != 0) {
            if ((n & 1) == 1) {
                if ((n >> 1) == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            n = n >> 1;
        }
        return  true;
    }
}
