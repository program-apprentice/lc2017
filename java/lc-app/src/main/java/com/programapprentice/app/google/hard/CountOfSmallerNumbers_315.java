package com.programapprentice.app.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbers_315 {
    /**
     https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/

     You are given an integer array nums and you have to return a new counts array.
     The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

     Example:

     Given nums = [5, 2, 6, 1]

     To the right of 5 there are 2 smaller elements (2 and 1).
     To the right of 2 there is only 1 smaller element (1).
     To the right of 6 there is 1 smaller element (1).
     To the right of 1 there is 0 smaller element.
     Return the array [2, 1, 1, 0].
     * */
    public List<Integer> countSmaller(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int n = nums.length;
        Integer[] output = new Integer[n];
        List<Integer> tmp = new ArrayList<Integer>();
        for (int i = n-1; i >= 0; i--) {
            int num = nums[i];
            int low = 0;
            int high = tmp.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tmp.get(mid) >= num) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            output[i] = high;
            tmp.add(high, num);
        }
        return Arrays.asList(output);
    }

}
