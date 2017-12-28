package com.programapprentice.app.google.medium;

public class DeleteOperationForTwoStrings_583 {
    /**
     https://leetcode.com/problems/delete-operation-for-two-strings/description/
     Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
     where in each step you can delete one character in either string.

     Example 1:
     Input: "sea", "eat"
     Output: 2
     Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
     Note:
     The length of given words won't exceed 500.
     Characters in given words can only be lower-case letters.

     Solution:
     http://www.cnblogs.com/grandyang/p/7144045.html
     * */

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] opts = new int[l1 + 1][l2 + 1];
        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    opts[i][j] = opts[i - 1][j - 1] + 1;
                } else {
                    opts[i][j] = Math.max(opts[i - 1][j], opts[i][j - 1]);
                }
            }
        }
        return l1 + l2 - 2 * opts[l1][l2];
    }
}
