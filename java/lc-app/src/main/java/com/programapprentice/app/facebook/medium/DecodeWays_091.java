package com.programapprentice.app.facebook.medium;

public class DecodeWays_091 {
    /**
     [91] Decode Ways

     https://leetcode.com/problems/decode-ways

     A message containing letters from A-Z is being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26

     Given an encoded message containing digits, determine the total number of ways to decode it.
     For example,
     Given encoded message "12",
     it could be decoded as "AB" (1 2) or "L" (12).

     The number of ways decoding "12" is 2.
     * */
    public boolean isValidTwoChars(char one, char two) {
        if (one == '0') {
            return false;
        }
        int sum = (one - '0') * 10 + (two - '0');
        if (sum >= 10 && sum <= 26) {
            return true;
        }
        return false;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            if (s.charAt(0) == '0') {
                return 0;
            }
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] opts = new int[s.length()];
        opts[0] = 1;
        if (isValidTwoChars(s.charAt(0), s.charAt(1))) {
            if (s.charAt(1) == '0') {
                opts[1] = 1;
            } else {
                opts[1] = 2;
            }
        } else {
            if (s.charAt(1) == '0') {
                return 0;
            }
            opts[1] = 1;
        }

        for(int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '0' || s.charAt(i-1) > '2') { // Invalid case
                    return 0;
                }
                opts[i] = opts[i-2];
            } else {
                if (isValidTwoChars(s.charAt(i-1), s.charAt(i))) {
                    opts[i] = opts[i-1] + opts[i-2];
                } else {
                    opts[i] = opts[i-1];
                }
            }
        }

        return opts[s.length()-1];
    }

}
