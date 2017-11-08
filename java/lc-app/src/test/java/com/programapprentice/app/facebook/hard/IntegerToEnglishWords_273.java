package com.programapprentice.app.facebook.hard;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords_273 {
    /**
     https://leetcode.com/problems/integer-to-english-words/description/

     Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

     For example,
     123 -> "One Hundred Twenty Three"
     12345 -> "Twelve Thousand Three Hundred Forty Five"
     1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * */

    static Map<Integer, String> dictonary = new HashMap<Integer, String>();
    static {
        dictonary.put(1, "One");
        dictonary.put(2, "Two");
        dictonary.put(3, "Three");
        dictonary.put(4, "Four");
        dictonary.put(5, "Five");
        dictonary.put(6, "Six");
        dictonary.put(7, "Seven");
        dictonary.put(8, "Eight");
        dictonary.put(9, "Nine");
        dictonary.put(10, "Ten");
        dictonary.put(11, "Eleven");
        dictonary.put(12, "Twelve");
        dictonary.put(13, "Thirteen");
        dictonary.put(14, "Fourteen");
        dictonary.put(15, "Fifteen");
        dictonary.put(16, "Sixteen");
        dictonary.put(17, "Seventeen");
        dictonary.put(18, "Eighteen");
        dictonary.put(19, "Nineteen");
        dictonary.put(20, "Twenty");
        dictonary.put(30, "Thirty");
        dictonary.put(40, "Forty");
        dictonary.put(50, "Fifty");
        dictonary.put(60, "Sixty");
        dictonary.put(70, "Seventy");
        dictonary.put(80, "Eighty");
        dictonary.put(90, "Ninety");
        dictonary.put(100, "Hundred");
        dictonary.put(1000, "Thousand");
        dictonary.put(1000000, "Million");
        dictonary.put(1000000000, "Billion");

    }


    public String getUnit(int num) {
        return dictonary.get(num);
    }

    public String getSegment(int num) {
        String result = null;
        int left = num % 100;
        num = num / 100;
        if (left <= 20) {
            result = getUnit(left);
        } else {
            int tens = (left/10) * 10;
            int ones = left % 10;
            if (ones != 0) {
                result = String.format("%s %s", getUnit(tens), getUnit(ones));
            } else {
                result = getUnit(tens);
            }
        }
        int hundred = num * 100;
        if (hundred != 0) {
            if (result != null) {
                result = getUnit(num) + " Hundred " + result;
            } else {
                result = getUnit(num) + " Hundred";
            }
        }

        return result;
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int base = 1;
        String result = null;
        while(num != 0) {
            int left = num % 1000;
            num = num / 1000;
            if (left == 0) {
                base = 1000 * base;
                continue;
            }
            switch (base) {
                case 1:
                    break;
                case 1000:
                    if(result == null) {
                        result = "Thousand";
                    } else {
                        result = "Thousand " + result;
                    }
                    break;
                case 1000000:
                    if(result == null) {
                        result = "Million";
                    } else {
                        result = "Million " + result;
                    }
                    break;
                case 1000000000:
                    if(result == null) {
                        result = "Billion";
                    } else {
                        result = "Billion " + result;
                    }
                    break;
            }
            String segment = getSegment(left);
            if (result == null) {
                result = segment;
            } else {
                result = segment + " " + result;
            }
            base = base * 1000;
        }
        return result;
    }
}
