package com.programapprentice.app.google.easy;

public class AddStrings_415 {
    /**
     https://leetcode.com/problems/add-strings/description/
    */
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "";
        }
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        if (num1.length() > num2.length()) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int n = Math.min(n1, n2);
        char[] chars = new char[Math.max(n1, n2) + 1];
        int carry = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = num1.charAt(n1-i-1) - '0' + num2.charAt(n2-i-1) - '0' + carry;
            carry = sum / 10;
            sum = sum % 10;
            chars[chars.length-i-1] = (char)(sum + '0');
        }
        for(int i = 0; i < (n2 - n); i++) {
            sum = num2.charAt(n2-n-i-1) - '0' + carry;
            carry = sum / 10;
            sum = sum % 10;
            chars[chars.length-n-i-1] = (char)(sum + '0');
        }
        if (carry == 1) {
            chars[0] = '1';
        } else {
            chars[0] = '0';
        }
        String result = new String(chars);
        return carry == 1 ? result : result.substring(1);
    }

}
