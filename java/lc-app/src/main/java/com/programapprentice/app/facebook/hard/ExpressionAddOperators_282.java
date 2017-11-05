package com.programapprentice.app.facebook.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators_282 {

    public int evaludateString(String str) {
        Stack<Character> stack = new Stack<Character>();

        int sum = 0;
        for(Character c : str.toCharArray()) {
            if (c == '*') {

            } else if (c >= '0') {
                if (stack.peek() == '*') {
                    stack.pop();
                    char pre = stack.pop();
                    char res = (char)((pre - '0') * (c - '0') + '0');
                    stack.push(res);
                }
            } else {
                stack.push(c);
            }

        }

        return 0;
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        List<String> candidates = new ArrayList<String>();
        List<String> operators = new ArrayList<String>();
        operators.add("+");
        operators.add("-");
        operators.add("*");

        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                result.add(num);
            }
            return result;
        }

        for(int i = 0; i < num.length(); i++) {
            List<String> newCandidates = new ArrayList<String>();
            if (i == num.length()) {
                for(String candidate : candidates) {
                    newCandidates.add(candidate + num.charAt(i));
                }
                continue;
            } else if (i == 0) {
                for(String operator : operators) {
                    newCandidates.add(new String(num.charAt(i) + operator));
                }
            } else {
                for(String operator : operators) {
                    for(String candidate : candidates) {
                        newCandidates.add(candidate + num.charAt(i) + operator);
                    }
                }
            }
            candidates = newCandidates;
        }

        for (String candidate : candidates) {
            if (evaludateString(candidate) == target) {
                result.add(candidate);
            }
        }

        return result;
    }
}
