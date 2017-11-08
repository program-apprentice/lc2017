package com.programapprentice.app.google.easy;

public class RepeatedStringMatch_686 {
    /**
     https://leetcode.com/problems/repeated-string-match/description/
     Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

     For example, with A = "abcd" and B = "cdabcdab".

     Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

     Note:
     The length of A and B will be between 1 and 10000.
     * */
    public int repeatedStringMatch(String A, String B) {
        String string = A;
        int maxRepeatTimes = B.length() / A.length() + 2;
        for(int rep = 1; rep <= maxRepeatTimes; rep++) {
            if (string.indexOf(B) != -1) {
                return rep;
            }
            string += A;
        }
        return -1;
    }
}
