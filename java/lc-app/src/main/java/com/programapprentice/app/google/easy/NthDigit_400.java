package com.programapprentice.app.google.easy;

import com.programapprentice.app.model.Interval;

import java.util.HashMap;

public class NthDigit_400 {
    /**
     https://leetcode.com/problems/nth-digit/description/
     Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

     Note:
     n is positive and will fit within the range of a 32-bit signed integer (n < 231).

     Example 1:

     Input:
     3

     Output:
     3
     Example 2:

     Input:
     11

     Output:
     0

     Explanation:
     The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
     Solution: http://www.cnblogs.com/grandyang/p/5891871.html
     * */
    public int findNthDigit(int n) {
        HashMap<Integer, Integer> digit = new HashMap<Integer, Integer>();
        long base = 9;
        long start = 1;
        long numberOfDigits = 1;
        while(n > numberOfDigits * base) {
            n -= numberOfDigits * base;
            numberOfDigits++;
            base *= 10;
            start *= 10;
        }
        start += (n-1)/numberOfDigits;
        String s = Long.toString(start);
        return s.charAt((int)((n-1) % numberOfDigits)) - '0';
    }
}
