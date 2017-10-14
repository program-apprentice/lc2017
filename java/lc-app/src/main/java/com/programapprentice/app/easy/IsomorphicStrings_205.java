package com.programapprentice.app.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
    /**
     [205] Isomorphic Strings

     https://leetcode.com/problems/isomorphic-strings

     Given two strings s and t, determine if they are isomorphic.

     Two strings are isomorphic if the characters in s can be replaced to get t.

     All occurrences of a character must be replaced with another character while preserving the order of characters.
     No two characters may map to the same character but a character may map to itself.

     For example,
     Given "egg", "add", return true.

     Given "foo", "bar", return false.

     Given "paper", "title", return true.

     Note:
     You may assume both s and t have the same length.

     * */
    public boolean isIsoMorphicStep(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();

        Map<Character, Character> dictionary = new HashMap<Character, Character>();
        int len = s.length();

        for(int i = 0; i < len; i++) {
            Character dest = t.charAt(i);
            Character value = dictionary.get(s.charAt(i));
            if (value == null) {
                dictionary.put(s.charAt(i), dest);
            } else if (!value.equals(dest)) {
                return false;
            }
        }

        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        return isIsoMorphicStep(s, t) && isIsoMorphicStep(t, s);
    }

}
