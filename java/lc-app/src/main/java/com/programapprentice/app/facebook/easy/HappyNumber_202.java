package com.programapprentice.app.facebook.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    /**
     [202] Happy Number

     https://leetcode.com/problems/happy-number

     Write an algorithm to determine if a number is "happy".

     A happy number is a number defined by the following process:
     Starting with any positive integer, replace the number by the sum of the squares of its digits,
     and repeat the process until the number equals 1 (where it will stay),
     or it loops endlessly in a cycle which does not include 1.
     Those numbers for which this process ends in 1 are happy numbers.

     Example: 19 is a happy number

     1^2 + 9^2 = 82
     8^2 + 2^2 = 68
     6^2 + 8^2 = 100
     1^2 + 0^2 + 0^2 = 1

     * */

    public int process(int n) {
        int result = 0;
        while(n != 0) {
            int digit = n % 10;
            result += digit * digit;
            n = n / 10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        Set<Integer> history = new HashSet<Integer>();
        while(true) {
            history.add(n);
            n = process(n);
            if (history.contains(n)) {
                return false;
            }
            if (n == 1) {
                return true;
            }
        }
    }

}
