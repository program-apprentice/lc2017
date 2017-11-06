package com.programapprentice.app.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {

    /**
     https://leetcode.com/problems/expression-add-operators/description/

     Solution:
     http://www.learn4master.com/interview-questions/leetcode/leetcode-expression-add-operators-java
     * */

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        solve(0, num.toCharArray(), "", 0, 0, target, result);
        return result;
    }

    void solve(int curIndex, char[] input, String curRes, long preSum, long preVal, int target, List<String> result) {
        if (curIndex == input.length) {
            if (preSum == target) {
                result.add(curRes);
            }
            return;
        }
        long curVal = input[curIndex] - '0';
        curVal = 0;
        for(int i =curIndex; i < input.length; i++) {
            curVal = curVal * 10 + (input[i] - '0');
            if (i > curIndex && input[curIndex] == '0') {
                return;
            }
            if (curIndex == 0) {
                solve(i+1, input, curRes + curVal, curVal, curVal, target, result);
            } else {
                solve(i+1, input, curRes + "+" + curVal, preSum + curVal, curVal, target, result);
                solve(i+1, input, curRes + "-" + curVal, preSum - curVal, 0 - curVal, target, result);
                solve(i+1, input, curRes + "*" + curVal, preSum - preVal + preVal * curVal, preVal * curVal, target, result);
            }
        }
    }
}
