package com.programapprentice.app.google.easy;

public class ValidwordAbbreviation_408 {
    /**
     https://leetcode.com/problems/valid-word-abbreviation/description/
     Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

     A string such as "word" contains only the following valid abbreviations:

     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

     Note:
     Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

     Example 1:
     Given s = "internationalization", abbr = "i12iz4n":

     Return true.
     Example 2:
     Given s = "apple", abbr = "a2e":

     Return false.
     Solution: http://www.cnblogs.com/grandyang/p/5930369.html
     * */
    public boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
    public boolean validWordAbbreviation(String word, String abbr) {
        int wLen = word.length();
        int aLen = abbr.length();
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < aLen && j < wLen) {
            char c = abbr.charAt(i);
            if (count == 0 && c == '0') {
                return false;
            }
            if (isLetter(c)) {
                if (count != 0) {
                    j += count;
                    if (j >= wLen) {
                        return false;
                    }
                    count = 0;
                }
                char w = word.charAt(j);
                if (w != c) {
                    return false;
                }
                i++;
                j++;
            } else {
                count = count * 10 + c - '0';
                i++;
            }
        }
        if (count != 0) {
            j += count;
            return j == wLen;
        }
        if (i < aLen) {
            return false;
        }
        return j == wLen;
    }

}
