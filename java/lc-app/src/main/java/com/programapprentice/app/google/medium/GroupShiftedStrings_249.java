package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupShiftedStrings_249 {
    /**
     https://leetcode.com/problems/group-shifted-strings/description/

     Given a string, we can "shift" each of its letter to its successive letter,
     for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

     "abc" -> "bcd" -> ... -> "xyz"
     Given a list of strings which contains only lowercase alphabets, group all
     strings that belong to the same shifting sequence.

     For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
     A solution is:

     [
     ["abc","bcd","xyz"],
     ["az","ba"],
     ["acef"],
     ["a","z"]
     ]
     * */

    public char shiftChar(char c) {
        if (c == 'z') {
            return 'a';
        }
        return (char)(c+1);
    }

    public String shiftString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            cs[i] = shiftChar(s.charAt(i));
        }
        return new String(cs);
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Arrays.sort(strings);
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String s : strings) {
            int count = dict.get(s) == null ? 0 : dict.get(s);
            count++;
            dict.put(s, count);
        }

        Set<String> visited = new HashSet<String>();
        for(String s : strings) {
            if (visited.contains(s)) {
                continue;
            }
            List<String> group = new ArrayList<String>();
            int c = dict.get(s);
            for(int j = 0; j < c; j++) {
                group.add(s);
            }
            visited.add(s);
            String shiftedS = s;
            for(int i = 0; i < 25; i++) {
                shiftedS = shiftString(shiftedS);
                if (!visited.contains(shiftedS) && dict.keySet().contains(shiftedS)) {
                    c = dict.get(shiftedS);
                    visited.add(shiftedS);
                    for(int j = 0; j < c; j++) {
                        group.add(shiftedS);
                    }
                }
            }
            result.add(group);
        }
        return result;
    }
}
