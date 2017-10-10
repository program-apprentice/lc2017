package com.programapprentice.app.easy;

public class CountAndSay038 {
    /**
     https://leetcode.com/problems/count-and-say

     The count-and-say sequence is the sequence of integers with the first five terms as following:
     1.     1
     2.     11
     3.     21
     4.     1211
     5.     111221

     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.

     Given an integer n, generate the nth term of the count-and-say sequence.

     Note: Each term of the sequence of integers will be represented as a string.
     Example 1:
     Input: 1
     Output: "1"

     Example 2:
     Input: 4
     Output: "1211"
    * */

    public String say(String s) {
        char pre = s.charAt(0);
        int times = 1;
        StringBuilder sb = new StringBuilder();
        char cur = 0;
        for(int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            if(pre == cur) {
                times++;
            } else {
                sb.append(times);
                sb.append(pre);
                pre = cur;
                times = 1;
            }
        }
        sb.append(times);
        sb.append(pre);
        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String s = "1";
        for(int i = 1; i < n; i++) {
            s = say(s);
        }
        return s;
    }

}