package com.programapprentice.app.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidPaentheses_301 {
    /**
     Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

     Note: The input string may contain letters other than the parentheses ( and ).

     Examples:
     "()())()" -> ["()()()", "(())()"]
     "(a)())()" -> ["(a)()()", "(a())()"]
     ")(" -> [""]
     Credits:
     Special thanks to @hpplayer for adding this problem and creating all test cases.

     All solutions: http://www.cnblogs.com/grandyang/p/4944875.html
     * */

    public List<String> removeInvalidParentheses(String s) {
        int leftCount = 0;
        int rightCount = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                leftCount++;
            }
            if (leftCount == 0) {
                if (c == ')') {
                    rightCount++;
                }
            } else {
                if (c == ')') {
                    leftCount--;
                }
            }
        }
        List<String> result = new ArrayList<String>();
        if (isValid(s)) {
            result.add(s);
            return result;
        }
        findValidParentheses(s, 0, leftCount, rightCount, result);
        return result;
    }

    public void findValidParentheses(String s, int startIdx, int leftCount, int rightCount, List<String> result) {
        if (leftCount == 0 && rightCount == 0) { // The number of left ( and right ) are the same.
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        for(int i = startIdx; i < s.length(); i++) {
            if (i != startIdx && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            if (leftCount > 0 && s.charAt(i) == '(') {
                findValidParentheses(s.substring(0, i) + s.substring(i+1), i, leftCount-1, rightCount, result);
            }
            if (rightCount > 0 && s.charAt(i) == ')') {
                findValidParentheses(s.substring(0, i) + s.substring(i+1), i, leftCount, rightCount-1, result);
            }
        }
    }

    public Boolean isValid(String str) {
        int counter = 0;

        for(char c : str.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter --;
                if (counter < 0) {
                    return false;
                }
            }
        }

        return counter == 0;
    }
}
