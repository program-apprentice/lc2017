package com.programapprentice.app.google.medium;

public class RemoveKDigits_402 {
    /**
     https://leetcode.com/problems/remove-k-digits/description/
     Given a non-negative integer num represented as a string, remove k digits from the number so that the new number
     is the smallest possible.

     Note:
     The length of num is less than 10002 and will be ≥ k.
     The given num does not contain any leading zero.
     Example 1:

     Input: num = "1432219", k = 3
     Output: "1219"
     Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     Example 2:

     Input: num = "10200", k = 1
     Output: "200"
     Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     Example 3:

     Input: num = "10", k = 2
     Output: "0"
     Explanation: Remove all the digits from the number and it is left with nothing which is 0.

     Solution:
     http://www.cnblogs.com/grandyang/p/5883736.html
     * */
    public String removeKdigits(String num, int k) {
        String result = "";

        int n = num.length();
        int remains = n - k;
        char[] stk = new char[num.length()];
        int top = 0;
        for(int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top--;
                k--;
            }
            stk[top] = c;
            top++;
        }
        int idx = 0;
        while (idx < remains && stk[idx] == '0') {
            idx++;
        }

        return  idx == remains ? "0" : new String(stk, idx, remains - idx);
    }
}
