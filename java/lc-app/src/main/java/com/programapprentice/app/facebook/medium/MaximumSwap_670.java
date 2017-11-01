package com.programapprentice.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class MaximumSwap_670 {
    /**
     [670] Maximum Swap

     https://leetcode.com/problems/maximum-swap

     Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

     Example 1:

     Input: 2736
     Output: 7236
     Explanation: Swap the number 2 and the number 7.

     Example 2:

     Input: 9973
     Output: 9973
     Explanation: No swap.

     Note:

     The given number is in the range [0, 108]
     * */

    public int convertToInt(List<Integer> digits) {
        int result = 0;
        int base = 1;
        for(int i = digits.size()-1; i >= 0; i--) {
            result += base * digits.get(i);
            base *= 10;
        }
        return result;
    }

    public int maximumSwap(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        int tmp = num;
        while(tmp != 0) {
            digits.add(0, tmp % 10);
            tmp /= 10;
        }
        if (digits.size() == 1) {
            return num;
        }
        int[] numberRightMostIdx = new int[10];
        for(int i = 0; i < 10; i++) {
            numberRightMostIdx[i] = -1;
        }
        for(int i = digits.size() - 1; i >= 0; i--) {
            int digit = digits.get(i);
            if (numberRightMostIdx[digit] == -1) {
                numberRightMostIdx[digit] = i;
            }
        }
        for(int i = 9; i >= 0; i--) {
            if (numberRightMostIdx[i] == -1) {
                continue;
            }
            for(int j = 0; j < digits.size(); j++) {
                if (digits.get(j) < i && numberRightMostIdx[i] > j) {
                    int curDigit = digits.get(j);
                    digits.set(j, i);
                    digits.set(numberRightMostIdx[i], curDigit);
                    int result = convertToInt(digits);
                    return result;
                }
            }
        }
        return num;
    }

}
