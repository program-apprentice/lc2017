package com.programapprentice.app.reverseinteger007;

public class Solution {
    /**
     *
     https://leetcode.com/problems/reverse-integer

     * algorithms
     * Easy (24.45%)
     * Total Accepted:    299.8K
     * Total Submissions: 1.2M
     * Testcase Example:  '0'

     Reverse digits of an integer.


     Example1: x =  123, return  321
     Example2: x = -123, return -321


     click to show spoilers.

     Have you thought about this?

     Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

     If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

     Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

     For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


     Note:
     The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
     * */
    /**
     * 1. what's edge cases? Integer.MAX_VALUE, Integer.MIN_VALUE
     * 2. How to handle negative number
     * 3. For Integer.MIN_VALUE
     * 4. How to know the reversed one is overflowed?
     * 5. What are special case: such as 5, -6 which are single digits
     *
     * Integer.MAX_VALUE: 2147483647
     * Integer.MIN_VALUE: -2147483648
     *
     * Compare 214748364
     * */
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        Boolean isNegative = x < 0 ? true : false;
        if (isNegative) {
           x = 0 - x;
        }

        int threshhold = Integer.MAX_VALUE / 10;
        int LAST_DIGIT = Integer.MAX_VALUE % 10;


        int newNumber = 0;
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;

            // check over flow, this has been changed twice
            if (newNumber > threshhold) {
                return 0;
            } else if (newNumber == threshhold) { // it's already last digit
                if (digit > LAST_DIGIT) {
                    return 0;
                }
            }

            newNumber = newNumber * 10 + digit;
        }
        return isNegative ? 0 - newNumber : newNumber;
    }
}
