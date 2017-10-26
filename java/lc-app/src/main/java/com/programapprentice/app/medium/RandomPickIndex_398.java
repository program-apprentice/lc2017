package com.programapprentice.app.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomPickIndex_398 {
    /**
     https://leetcode.com/problems/random-pick-index/description/
     Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

     Note:
     The array size can be very large. Solution that uses too much extra space will not pass the judge.

     Example:

     int[] nums = new int[] {1,2,3,3,3};
     Solution solution = new Solution(nums);

     // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
     solution.pick(3);

     // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
     solution.pick(1);
     * */
    class Solution {
        Random random;
//        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] nums;
        public Solution(int[] nums) {
            random = new Random();
            this.nums = nums;
        }

        public int pick(int target) {
            int count = 0;
            int res = -1;
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;

                    if (random.nextInt() % count == 0) { // This is the key.
                        res = i;
                    }
                }
            }
            return res;
        }
    }
}
