package com.programapprentice.app.easy;

public class RomanToInteger013 {

    /**
     *
     https://leetcode.com/problems/roman-to-integer

     Given a roman numeral, convert it to an integer.

     Input is guaranteed to be within the range from 1 to 3999.

     Roman Numbers
     Symbol	I	V	X	L	C	D	M
     Value	1	5	10	50	100	500	1,000
     * */

    private int getRomanNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        if(s.length() == 1) {
            return getRomanNumber(s.charAt(0));
        }
        int result = 0;

        int preNumber = 0;
        int curNumber = 0;


        for (int i = s.length()-1; i >= 0; i--) {
            curNumber = getRomanNumber(s.charAt(i));
            if (curNumber < preNumber) {
                result -= curNumber;
            } else {
                result += curNumber;
            }
            preNumber = curNumber;
        }

        return result;
    }

}
