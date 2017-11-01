package com.programapprentice.app.facebook.easy;

public class MajorityElement_169 {
    /**
     [169] Majority Element

     https://leetcode.com/problems/majority-element

     Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

     You may assume that the array is non-empty and the majority element always exist in the array.
     * */
    public int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = -1;
        for (int num : nums) {
            if (counter == 0) {
                counter++;
                candidate = num;
            } else {
                if (candidate == num) {
                    counter ++;
                } else {
                    counter--;
                }
            }
        }
        return candidate;
    }
}
