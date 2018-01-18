package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_320 {
    /**
     https://leetcode.com/problems/generalized-abbreviation/description/

     Write a function to generate the generalized abbreviations of a word.

     Example:
     Given word = "word", return the following list (order does not matter):
     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     * */

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        if (word == null) {
            return result;
        }
        if (word.length() == 0) {
            result.add(word);
            return result;
        }
        for(int i = 0; i < word.length(); i++) {
            List<String> newTmp = new ArrayList<String>();
            if (result.isEmpty()) {
                newTmp.add(word.substring(0, 1));
                newTmp.add("1");
            } else {
                int length = result.size();
                for(String s : result) {
                    newTmp.add(s + word.charAt(i));
                }
                for(int j = 0; j < length/2; j++) {
                    String s = result.get(j);
                    newTmp.add(s + "1");
                }
                for(int j = length/2; j < length; j++) {
                    String s = result.get(j);
                    newTmp.add(plusOne(s));
                }
            }
            result = newTmp;
        }
        return result;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    // s end with digit
    public String plusOne(String s) {
        int n = s.length();
        int index = n-1;
        while (index >= 0 && isDigit(s.charAt(index))) {
            index--;
        }
        int end = Integer.parseInt(s.substring(index+1));
        end++;
        return s.substring(0, index+1) + Integer.toString(end);
    }

}
