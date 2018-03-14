package com.programapprentice.app.google.hard;

public class EncodeStringWithShortestLength_471 {
    /**
     Given a non-empty string, encode the string such that its encoded length is the shortest.

     The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.

     Note:
     k will be a positive integer and encoded string will not be empty or have extra space.
     You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
     If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.

     Example 1:
     Input: "aaa"
     Output: "aaa"
     Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.

     Example 2:
     Input: "aaaaa"
     Output: "5[a]"
     Explanation: "5[a]" is shorter than "aaaaa" by 1 character.

     Example 3:
     Input: "aaaaaaaaaa"
     Output: "10[a]"
     Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".

     Example 4:
     Input: "aabcaabcd"
     Output: "2[aabc]d"
     Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".

     Example 5:
     Input: "abbbabbbcabbbabbbc"
     Output: "2[2[abbb]c]"
     Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".

     Solution:
     http://www.cnblogs.com/grandyang/p/6194403.html
     http://bookshadow.com/weblog/2016/12/11/leetcode-encode-string-with-shortest-length/
     https://segmentfault.com/a/1190000008341304
     * */
    public String encode(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        String[][] opts = new String[n][n];
        for(int i = 0; i < n; i++) {
            opts[i][i] = "" + s.charAt(i);
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                // enumrate seperate k
                for (int k = i; k < j; k++) {
                    String left = opts[i][k];
                    String right = opts[k+1][j];
                    if (opts[i][j] == null|| left.length() + right.length() < opts[i][j].length()) {
                        opts[i][j] = left + right;
                    }
                }
                String sub = s.substring(i, j+1);
                int index = (sub + sub).indexOf(sub, 1);
                if (index < sub.length()) {
                    sub = String.format("%d[%s]", sub.length()/index, opts[i][i+index-1]);
                }
                if (opts[i][j] == null || opts[i][j].length() > sub.length()) {
                    opts[i][j] = sub;
                }
            }
        }
        return opts[0][n-1];
    }
}
