package com.programapprentice.app.google.medium;

public class CountNumbersWithUniqueDigits_357 {
    /**
     https://leetcode.com/problems/count-numbers-with-unique-digits/description/

     Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

     Example:
     Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
     excluding [11,22,33,44,55,66,77,88,99])

     * */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 10;
        int count = 9;
        for(int i = 2; i <= n; i++) {
            count *= (11 - i);
            result += count;
        }
        return result;
    }
}
