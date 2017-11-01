package com.programapprentice.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings_043 {
    /**
     [43] Multiply Strings

     https://leetcode.com/problems/multiply-strings

     Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

     Note:

     The length of both num1 and num2 is < 110.
     Both num1 and num2 contains only digits 0-9.
     Both num1 and num2 does not contain any leading zero.
     You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * */

    public String convertToString(List<Character> input) {
        StringBuilder sb = new StringBuilder();
        for(Character c : input) {
            sb.append(c);
        }
        String str = sb.toString();
        Boolean isZero = true;
        for(char c : str.toCharArray()) {
            if (c != '0') {
                isZero = false;
                break;
            }
        }
        return isZero ? "0" : str;
    }

    public String add2Strings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "";
        }
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        List<Character> result = new ArrayList<Character>();
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        int sum = 0;
        while(p1 >= 0 || p2 >= 0) {
            char c1 = p1 >= 0 ? num1.charAt(p1) : '0';
            char c2 = p2 >= 0 ? num2.charAt(p2) : '0';
            sum = c1 + c2 - '0' - '0' + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.add(0, (char)('0' + sum));
            p1--;
            p2--;
        }
        if (carry != 0) {
            result.add(0, (char)('0' + carry));
        }
        return convertToString(result);
    }

    public String multiplyOneDigit(String num1, char c) {
        List<Character> result = new ArrayList<Character>();
        int carry = 0;
        for(int i = num1.length()-1; i >= 0; i--) {
            char cur = num1.charAt(i);
            int sum = (cur - '0') * (c - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            result.add(0, (char)('0' + sum));
        }
        if (carry != 0) {
            result.add(0, (char)('0' + carry));
        }
        return convertToString(result);
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        String result = "";
        String trailingZeros = "";
        for(int i = num2.length()-1; i >= 0; i--) {
            char c = num2.charAt(i);
            String tmp = multiplyOneDigit(num1, c);
            tmp += trailingZeros;
            result = add2Strings(result, tmp);
            trailingZeros += "0";
        }

        return result;
    }

}
