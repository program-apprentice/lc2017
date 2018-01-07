package com.programapprentice.app.google.medium;

import java.util.Stack;

public class DecodeString_394 {
    /**
     https://leetcode.com/problems/decode-string/description/
     Given an encoded string, return it's decoded string.

     The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
     exactly k times. Note that k is guaranteed to be a positive integer.

     You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

     Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
     repeat numbers, k. For example, there won't be input like 3a or 2[4].

     Examples:

     s = "3[a]2[bc]", return "aaabcbc".
     s = "3[a2[c]]", return "accaccacc".
     s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

     Solution:
     http://www.cnblogs.com/grandyang/p/5849037.html
     * */
    private Boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private Boolean isDigit(String s) {
        return s.length ()== 1 && s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(Character.toString(c));
            } else if (c == ']') {
                String curStr = stack.pop();
                StringBuilder subSb = new StringBuilder();
                stack.pop(); // pop '['
                int count = Integer.parseInt(stack.pop());
                for(int j = 0; j < count; j++) {
                    subSb.append(curStr);
                }
                if (stack.isEmpty()) {
                    sb.append(subSb);
                } else {
                    String top = stack.peek();
                    if (!top.equals("[")) {
                        top = stack.pop();
                        stack.push(top + subSb.toString());
                    } else {
                        stack.push(subSb.toString());
                    }
                }
            } else if (isDigit(c)) {
                if (stack.isEmpty()) {
                    stack.push(Character.toString(c));
                } else {
                    String top = stack.peek();
                    if (isDigit(top.charAt(top.length()-1))) {
                        top = stack.pop();
                        stack.push(top + c);
                    } else {
                        stack.push(Character.toString(c));
                    }
                }
            } else { // letter
                if (stack.isEmpty()) {
                    sb.append(c);
                } else {
                    if (stack.peek().equals("[")) {
                        stack.push(Character.toString(c));
                    } else {
                        String t = stack.pop();
                        stack.push(t + c);
                    }
                }
            }
            i++;
        }

        return sb.toString();
    }
}
