package com.programapprentice.app.easy;

public class ExcelSheetColumnNumber_171 {
    /**
     [171] Excel Sheet Column Number

     https://leetcode.com/problems/excel-sheet-column-number

     Related to question Excel Sheet Column Title
     Given a column title as appear in an Excel sheet, return its corresponding column number.

     For example:
     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28

     Credits:Special thanks to @ts for adding this problem and creating all test cases.
     * */
    public int getNumber(char x) {
        return x - 'A' + 1;
    }

    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        int base = 1;
        for(int i = s.length()-1; i >= 0; i--) {
            int digit = getNumber(s.charAt(i));
            sum += digit * base;
            base *= 26;
        }
        return sum;
    }
}
