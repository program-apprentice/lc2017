package com.programapprentice.app.facebook.easy;

public class HammingDistance_461 {
    /**
     [461] Hamming Distance

     https://leetcode.com/problems/hamming-distance

     The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

     Given two integers x and y, calculate the Hamming distance.

     Note:
     0 ≤ x, y < 231.

     Example:

     Input: x = 1, y = 4

     Output: 2

     Explanation:
     1   (0 0 0 1)
     4   (0 1 0 0)
            ↑   ↑

     The above arrows point to positions where the corresponding bits are different.
     * */

    public int hammingDistance(int x, int y) {
        int xbit = 0;
        int ybit = 0;
        int result = 0;

        while(x != 0 || y != 0) {
            xbit = x & 1;
            ybit = y & 1;
            result += xbit == ybit ? 0 : 1;
            x = x >> 1;
            y = y >> 1;
        }

        return result;
    }

}
