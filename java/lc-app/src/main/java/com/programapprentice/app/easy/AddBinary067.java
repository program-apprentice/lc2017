package com.programapprentice.app.easy;

import java.util.Arrays;

public class AddBinary067 {
    /**
     [67] Add Binary

     https://leetcode.com/problems/add-binary
     Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100".
     * */

    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }
        String shortStr = a.length() > b.length() ? b : a;
        String longStr = a.length() > b.length() ? a : b;
        int longLength = longStr.length();
        int shortLength = shortStr.length();
        char[] result = new char[longStr.length() + 1];

        int carry = 0;
        int i = 1;
        for(; i <= shortLength; i++) {
            int s = shortStr.charAt(shortLength - i);
            int l = longStr.charAt(longLength - i);
            int bit = (s - '0' + l - '0' + carry) % 2;
            carry = (s - '0' + l - '0' + carry) / 2;
            result[result.length - i] = (char)(bit + '0');
        }

        for(; i <= longLength; i++) {
            int l = longStr.charAt(longLength - i);
            int bit = (l - '0' + carry) % 2;
            carry = (l - '0' + carry) / 2;
            result[result.length - i] = (char)(bit + '0');
        }
        result[0] = (char)(carry + '0');
        if(result[0] == '0') {
            return new String(Arrays.copyOfRange(result, 1,result.length));
        } else {
            return new String(result);
        }
    }

}
