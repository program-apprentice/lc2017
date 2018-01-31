package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.List;

public class TwentyFourGame_679 {
    /**
     https://leetcode.com/problems/24-game/description/
     You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

     Example 1:
     Input: [4, 1, 8, 7]
     Output: True
     Explanation: (8-4) * (7-1) = 24
     Example 2:
     Input: [1, 2, 1, 2]
     Output: False
     Note:
     The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
     Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
     You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
     * */

    final double esp = 1e-4;

    public boolean isNonZero(double num) {
        return Math.abs(num) > esp;
    }

    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length != 4) {
            return false;
        }
        List<Double> numList = new ArrayList<Double>();
        for(int num : nums) {
            numList.add((double)num);
        }
        return solve(numList);
    }

    public boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            if (Math.abs(nums.get(0) - 24.0) <= esp) {
                return true;
            }
            return false;
        }
        for(int i = 0; i < nums.size(); i++) {
            double num1 = nums.get(i);
            for(int j = 0; j < nums.size(); j++) {
                if (j == i) {
                    continue;
                }
                double num2 = nums.get(j);
                List<Double> newNums = new ArrayList<Double>();
                newNums.add(num1+num2);
                newNums.add(num1-num2);
                newNums.add(num2-num1);
                newNums.add(num1*num2);
                if (isNonZero(num1)) {
                    newNums.add(num2/num1);
                }
                if (isNonZero(num2)) {
                    newNums.add(num1/num2);
                }
                List<Double> oldNums = new ArrayList<Double>(nums);
                oldNums.remove(num1);
                oldNums.remove(num2);
                for(double newNum : newNums) {
                    oldNums.add(newNum);
                    if (solve(oldNums)) {
                        return true;
                    }
                    oldNums.remove(newNum);
                }
            }
        }
        return false;
    }
}
