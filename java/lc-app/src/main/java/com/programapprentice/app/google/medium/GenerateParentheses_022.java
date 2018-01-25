package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_022 {
    /**
     https://leetcode.com/problems/generate-parentheses/description/
     Given n pairs of parentheses, write a function to generate all
     combinations of well-formed parentheses.

     For example, given n = 3, a solution set is:

     [
     "((()))",
     "(()())",Î
     "(())()",
     "()(())",
     "()()()"
     ]
     * */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String str = "";
        findParenthesis(n, 0, 0, str, result);
        return result;
    }
    void findParenthesis(int n, int left, int right, String str, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            str += "(";
            findParenthesis(n, left+1, right, str, result);
            str = str.substring(0, str.length()-1);
        }
        if (right < left) {
            str += ")";
            findParenthesis(n, left, right+1, str, result);
            str = str.substring(0, str.length()-1);
        }
    }
}
