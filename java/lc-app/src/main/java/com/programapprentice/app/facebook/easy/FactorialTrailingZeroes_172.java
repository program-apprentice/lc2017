package com.programapprentice.app.facebook.easy;

public class FactorialTrailingZeroes_172 {
    /**
     [172] Factorial Trailing Zeroes

     https://leetcode.com/problems/factorial-trailing-zeroes

     Given an integer n, return the number of trailing zeroes in n!.

     Note: Your solution should be in logarithmic time complexity.
     * */

    public int trailingZeroes(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n/5;
            n = n/5;
        }
        return sum;
    }

}
