package com.programapprentice.app.google.easy;

public class DetectCapital_520 {
    /**
     https://leetcode.com/problems/detect-capital/description/
     * */
    public boolean isUpperLetter(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0 || word.equals("")) {
            return true;
        }
        if (isUpperLetter(word.charAt(0))) {
            if (word.length() == 1) {
                return true;
            }
            if (isUpperLetter(word.charAt(1))) {
                for(int i = 2; i < word.length(); i++) {
                    if (!isUpperLetter(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            } else {
                for(int i = 2; i < word.length(); i++) {
                    if (!isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            for(int i = 1; i < word.length(); i++) {
                if (!isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
