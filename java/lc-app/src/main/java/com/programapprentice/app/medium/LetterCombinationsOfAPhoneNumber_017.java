package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_017 {
    /**
     [17] Letter Combinations of a Phone Number

     https://leetcode.com/problems/letter-combinations-of-a-phone-number

     * algorithms
     * Medium (35.07%)
     * Source Code:       17.letter-combinations-of-a-phone-number.java
     * Total Accepted:    181.5K
     * Total Submissions: 517.5K
     * Testcase Example:  '""'

     Given a digit string, return all possible letter combinations that the number could represent.



     A mapping of digit to letters (just like on the telephone buttons) is given below.



     Input:Digit string "23"
     Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].



     Note:
     Although the above answer is in lexicographical order, your answer could be in any order you want.
     * */

    public List<String> getLetters(char digit) {
        List<String> result = new ArrayList<String>();
        switch(digit) {
            case '1':
                result.add(" ");
                break;
            case '2':
                result.add("a");
                result.add("b");
                result.add("c");
                break;
            case '3':
                result.add("d");
                result.add("e");
                result.add("f");
                break;
            case '4':
                result.add("g");
                result.add("h");
                result.add("i");
                break;
            case '5':
                result.add("j");
                result.add("k");
                result.add("l");
                break;
            case '6':
                result.add("m");
                result.add("n");
                result.add("o");
                break;
            case '7':
                result.add("p");
                result.add("q");
                result.add("r");
                result.add("s");
                break;
            case '8':
                result.add("t");
                result.add("u");
                result.add("v");
                break;
            case '9':
                result.add("w");
                result.add("x");
                result.add("y");
                result.add("z");
                break;
            case '0':
                result.add(" ");
                break;
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result = getLetters(digits.charAt(0));
        for(int i = 1; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            List<String> newList = new ArrayList<String>();
            List<String> letters = getLetters(digit);
            for(String str : result) {
                for(String newLetter : letters) {
                    newList.add(str + newLetter);
                }
            }
            result = newList;
        }
        return result;
    }

}
