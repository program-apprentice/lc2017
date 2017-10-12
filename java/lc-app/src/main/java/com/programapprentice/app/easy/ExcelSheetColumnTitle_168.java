package com.programapprentice.app.easy;

import java.util.ArrayList;
import java.util.List;

public class ExcelSheetColumnTitle_168 {
    /**
     [168] Excel Sheet Column Title
     https://leetcode.com/problems/excel-sheet-column-title

     Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:

     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB

     Credits:Special thanks to @ifanchu for adding this problem and creating all test cases.
     * */
    public char convertToChar(int x) {
        return (char)('A' + x - 1);
    }

    public String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        List<Integer> result = new ArrayList<Integer>();
        while(n != 0) {
            int t = n % 26;
            if(t == 0) {
                result.add(0, 26);
                n -= 26;
            } else {
                result.add(0, t);
            }
            n /= 26;
        }
        StringBuilder sb = new StringBuilder();
        for(Integer i : result) {
            sb.append(convertToChar(i));
        }
        return sb.toString();
    }

}
