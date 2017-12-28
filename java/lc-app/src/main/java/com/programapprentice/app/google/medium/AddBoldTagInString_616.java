package com.programapprentice.app.google.medium;

public class AddBoldTagInString_616 {
    /**
     https://leetcode.com/problems/add-bold-tag-in-string/description/
     Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b>
     to wrap the substrings in s that exist in dict. If two such substrings overlap,
     you need to wrap them together by only one pair of closed bold tag.
     Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
     Example 1:
     Input:
     s = "abcxyz123"
     dict = ["abc","123"]
     Output:
     "<b>abc</b>xyz<b>123</b>"
     Example 2:
     Input:
     s = "aaabbcc"
     dict = ["aaa","aab","bc"]
     Output:
     "<b>aaabbc</b>c"
     Note:
     The given dict won't contain duplicates, and its length won't exceed 100.
     All the strings in input have length in range [1, 1000].

     Two solution:
     http://www.cnblogs.com/grandyang/p/7043394.html
     Solution 1: Treated as interval merge
     Solution 2: Brute force (This is enough to pass OJ)
     * */
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean[] tags = new boolean[s.length()];
        int end = -1;
        for(int i = 0; i < s.length(); i++) {
            for(String word : dict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    end = Math.max(end, i + word.length()-1);
                }
            }
            tags[i] = i <= end;
        }

        // add tags
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (tags[i]) {
                if (i == 0) {
                    sb.append("<b>");
                } else if (!tags[i-1]) {
                    sb.append("<b>");
                }
            } else {
                if (i > 0 && tags[i-1]) {
                    sb.append("</b>");
                }
            }
            sb.append(s.charAt(i));
            if (tags[i] && i == s.length()-1) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

}
