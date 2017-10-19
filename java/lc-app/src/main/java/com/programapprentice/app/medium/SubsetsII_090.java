package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_090 {
    /**
     [90] Subsets II

     https://leetcode.com/problems/subsets-ii

     Given a collection of integers that might contain duplicates, nums, return all possible subsets.

     Note: The solution set must not contain duplicate subsets.


     For example,
     If nums = [1,2,2], a solution is:

     [
         [2],
         [1],
         [1,2,2],
         [2,2],
         [1,2],
         []
     ]
     * */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int preSize = 0;
        for(int i = 0; i < nums.length; i++) {
            int size = result.size();
            if (i != 0 && nums[i] == nums[i-1]) {
                int startIdx = result.size() - preSize;
                for(int j = 0; j < preSize; j++) {
                    List<Integer> item = new ArrayList<Integer>(result.get(startIdx + j));
                    item.add(nums[i]);
                    result.add(item);
                }
            } else {
                preSize = 0;
                for (int j = 0; j < size; j++) {
                    List<Integer> item = new ArrayList<Integer>(result.get(j));
                    item.add(nums[i]);
                    preSize ++;
                    result.add(item);
                }
            }
        }

        return result;
    }
}
