package com.programapprentice.app.facebook.easy;

import java.util.HashMap;

public class ContainsDuplicate_217 {
    /**
     [217] Contains Duplicate

     https://leetcode.com/problems/contains-duplicate

     Given an array of integers, find if the array contains any duplicates.
     Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
     * */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, true);
            } else {
                return true;
            }
        }
        return false;
    }

}
