package com.programapprentice.app.facebook.hard;

public class DecodeWaysII_639 {
    /**
     https://leetcode.com/problems/decode-ways-ii/description/
     A message containing letters from A-Z is being encoded to numbers using the following mapping way:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

     Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

     Also, since the answer may be very large, you should return the output mod 109 + 7.

     Example 1:
     Input: "*"
     Output: 9
     Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
     Example 2:
     Input: "1*"
     Output: 9 + 9 = 18
     Note:
     The length of the input string will fit in range [1, 105].
     The input string will only contain the character '*' and digits '0' - '9'.

     Solution: http://www.cnblogs.com/grandyang/p/7279152.html
     * */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        long[] opts = new long[s.length()+1];
        int m = 1000000007;
        opts[0] = 1;
        opts[1] = s.charAt(0) == '*' ? 9 : 1;
        for(int i = 2; i <= s.length(); i++) {
            char cur = s.charAt(i-1);
            char pre = s.charAt(i-2);
            if (cur == '*') {
                opts[i] = 9 * opts[i-1];
                if (pre == '1') {
                    opts[i] += 9 * opts[i-2];
                } else if (pre == '2') {
                    opts[i] += 6 * opts[i-2];
                } else if (pre == '*') {
                    opts[i] += 15 * opts[i-2];
                }
            } else if (cur == '0') {
                if (pre == '1' || pre == '2') {
                    opts[i] = opts[i-2];
                } else if (pre == '*') {
                    opts[i] = 2 * opts[i-2];
                } else {
                    return 0; // invalid
                }
            } else if (cur <= '9' && cur >= '1') {
                opts[i] = opts[i-1];
                if (pre == '1' || (pre == '2' && cur <= '6')) {
                    opts[i] += opts[i-2];
                } else if (pre == '*') {
                    if (cur <= '6') {
                        opts[i] += 2 * opts[i-2];
                    } else {
                        opts[i] += opts[i-2];
                    }
                }
            }
            opts[i] %= m;

        }
        return (int)opts[s.length()];
    }

}
