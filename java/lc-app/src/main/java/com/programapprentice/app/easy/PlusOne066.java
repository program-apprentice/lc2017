package com.programapprentice.app.easy;

import java.util.Arrays;
import java.util.List;

public class PlusOne066 {
    /**
     [66] Plus One

     https://leetcode.com/problems/plus-one

     Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

     You may assume the integer do not contain any leading zero, except the number 0 itself.

     The digits are stored such that the most significant digit is at the head of the list.
     * */

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        int newLength = newDigits.length;
        int length = digits.length;
        newDigits[newLength-1] = (digits[length-1] + 1) % 10;
        int carry = (digits[length-1] + 1) / 10;

        for(int i = 2; i <= digits.length; i++ ) {
            newDigits[newLength-i] = (carry + digits[length - i]) % 10;
            carry = (carry + digits[length - i]) / 10;
        }
        newDigits[0] = carry;
        if(newDigits[0] != 0) {
            return newDigits;
        }
        return Arrays.copyOfRange(newDigits, 1, newLength);
    }
}
