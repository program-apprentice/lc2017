package com.programapprentice.app.easy;

public class ReverseBits_190 {
    /**
     [190] Reverse Bits
     https://leetcode.com/problems/reverse-bits

     Reverse bits of a given 32 bits unsigned integer.

     For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

     Follow up:
     If this function is called many times, how would you optimize it?

     Related problem: Reverse Integer

     * */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int tmp = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            tmp = n & 1;
            result += tmp;
            n = n >> 1;
        }
        return result;
    }
}