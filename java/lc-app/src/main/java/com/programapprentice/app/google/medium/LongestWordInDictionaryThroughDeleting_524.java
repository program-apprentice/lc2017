package com.programapprentice.app.google.medium;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting_524 {
    /**
     https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
     Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
     some characters of the given string. If there are more than one possible results, return the longest word with the
     smallest lexicographical order. If there is no possible result, return the empty string.

     Example 1:
     Input:
     s = "abpcplea", d = ["ale","apple","monkey","plea"]

     Output:
     "apple"
     Example 2:
     Input:
     s = "abpcplea", d = ["a","b","c"]

     Output:
     "a"
     Note:
     All the strings in the input will only contain lower-case letters.
     The size of the dictionary won't exceed 1,000.
     The length of all the strings in the input won't exceed 1,000.
     * */

    // str and result are equal length
    public boolean isSmaller(String str, String result) {
        int n = str.length();
        for(int i = 0; i < n; i++) {
            if (str.charAt(i) < result.charAt(i)) {
                return true;
            } else if (str.charAt(i) > result.charAt(i)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String str : d) {
            int i = 0;
            for(char c : s.toCharArray()) {
                if (i < str.length() && c == str.charAt(i)) {
                    i++;
                }
                if (i == str.length() && str.length() >= result.length()) {
                    if (str.length() > result.length() || isSmaller(str, result)) {
                        result = str;
                    }
                }
            }
        }

        return result;
    }
}
