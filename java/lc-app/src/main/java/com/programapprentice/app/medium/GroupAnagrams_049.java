package com.programapprentice.app.medium;

import java.util.*;

public class GroupAnagrams_049 {
    /**
     [49] Group Anagrams

     https://leetcode.com/problems/group-anagrams

     Given an array of strings, group anagrams together.

     For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     Return:

     [
     ["ate", "eat","tea"],
     ["nat","tan"],
     ["bat"]
     ]

     Note: All inputs will be in lower-case.
     * */

    public String getKey(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<String, List<String>>();

        for(String str : strs) {
            String key = getKey(str);
            List<String> list = resultMap.get(key) == null ? new ArrayList<String>() : resultMap.get(key);
            list.add(str);
            resultMap.put(key, list);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(String key : resultMap.keySet()) {
            result.add(resultMap.get(key));
        }

        return result;
    }

}
