package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.List;

public class MinimumUniqueWordAbbreviation_411 {
    /**
     https://leetcode.com/problems/minimum-unique-word-abbreviation/description/
     A string such as "word" contains the following abbreviations:

     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the
     smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

     Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

     Note:
     In the case of multiple answers as shown in the second example below, you may return any one of them.
     Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
     Examples:
     "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

     "apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
     * */

    public String minAbbreviation(String target, String[] dictionary) {
        List<String> allAbbreviation = generateAbbreviations(target);
        List<String>[] abbreviations = new List[target.length()+1];
        for(String abbr : allAbbreviation) {
            List<String> record = abbreviations[abbr.length()] == null ? new ArrayList<String>() : abbreviations[abbr.length()];
            record.add(abbr);
            abbreviations[abbr.length()] = record;
        }

        for(List<String> abbrSet : abbreviations) {
            if (abbrSet == null) {
                continue;
            }
            for(String abbr : abbrSet) {
                boolean conflict = false;
                for(String word : dictionary){
                    if (validWordAbbreviation(word, abbr)) {
                        conflict = true;
                        break;
                    }
                }
                if (!conflict) {
                    return abbr;
                }
            }
        }

        return "";
    }

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
