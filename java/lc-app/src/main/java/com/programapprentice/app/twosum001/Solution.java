package com.programapprentice.app.twosum001;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
    * https://leetcode.com/problems/two-sum
     Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].
    * */

    /**
     * What to think
     * 1. Is this array ordered?
     * 2. Is there any duplication?
     * 3. What are edge cases?
     *
     * Solution 1: Sort it, then traverse from head and end. Time Complexity: O(nLogn)
     * Solution 2: Create a hash map and then traverse. Time Complexity: O(n)
     *
     * Further thinking, how can we scale this solution?
     * It depends on how data is stored or partitioned? Ordered or not ordered?
     *
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            Integer otherIdx = map.get(left);
            if(otherIdx != null && i != otherIdx) {
                result[0] = i;
                result[1] = otherIdx;
                return result;
            }
        }

        return result;
    }
}
