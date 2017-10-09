package com.programapprentice.app.easy;

import java.util.Stack;

/**
 * Created by ruijiang on 10/8/17.
 */
public class ValidParentheses020 {
    /**
     https://leetcode.com/problems/valid-parentheses

     Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public boolean isValid(String s) {
        if(s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        Character p = null;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch(c) {
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    p = stack.pop();
                    if( p != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    p = stack.pop();
                    if( p != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    p = stack.pop();
                    if( p != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();
    }
}
