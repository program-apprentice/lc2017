package com.programapprentice.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_078 {
    /**
     [78] Subsets

     https://leetcode.com/problems/subsets

     Given a set of distinct integers, nums, return all possible subsets.

     Note: The solution set must not contain duplicate subsets.

     For example,
     If nums = [1,2,3], a solution is:

     [
         [3],
         [1],
         [2],
         [1,2,3],
         [1,3],
         [2,3],
         [1,2],
         []
     ]
    * */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            int size = result.size();
            for(int j = 0; j < size; j++) {
                List<Integer> item = new ArrayList<Integer>(result.get(j));
                item.add(nums[i]);
                result.add(item);
            }
        }

        return result;
    }

}
