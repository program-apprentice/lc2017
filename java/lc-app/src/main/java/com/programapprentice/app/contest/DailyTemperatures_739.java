package com.programapprentice.app.contest;

import java.util.Stack;

public class DailyTemperatures_739 {
    /**
     https://leetcode.com/contest/weekly-contest-61/problems/daily-temperatures/
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexStack = new Stack<Integer>();
        if (temperatures == null) {
            return null;
        }
        if (temperatures.length == 0) {
            return new int[0];
        }
        indexStack.push(0);
        int[] result = new int[temperatures.length];
        for(int i = 1; i < temperatures.length; i++) {
            while(!indexStack.isEmpty()) {
                int temp = temperatures[indexStack.peek()];
                if (temp < temperatures[i]) {
                    result[indexStack.peek()] = i - indexStack.peek();
                } else {
                    break;
                }
                indexStack.pop();
            }
            indexStack.push(i);
        }
        return result;
    }
}
