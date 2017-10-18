package com.programapprentice.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_015 {
    /**
     [15] 3Sum

     https://leetcode.com/problems/3sum

     Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     Find all unique triplets in the array which gives the sum of zero.

     Note: The solution set must not contain duplicate triplets.

     For example, given array S = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     * */

    /**
     * 1. sort it O(nlogn)
     * 2. find target
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            List<List<Integer>> items = twoSum(nums, 0-nums[i], i);
            result.addAll(items);
        }
        return result;
    }

    public int moveToRight(int[] nums, int curIdx) {
        int pre = nums[curIdx];
        while(curIdx < nums.length-1) {
            curIdx++;
            if(nums[curIdx] != pre) {
                return curIdx;
            }
        }
        return nums.length;
    }

    public int moveToLeft(int[] nums, int curIdx) {
        int pre = nums[curIdx];
        while(curIdx > 0) {
            curIdx--;
            if(nums[curIdx] != pre) {
                return curIdx;
            }
        }
        return -1;
    }

    /* 1 2 3 4 5 6 7 8 9 10 target = 11*/
    public List<List<Integer>> twoSum(int[] nums, int target, int startIdx) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int beg = startIdx + 1;
        int end = nums.length - 1;

        while(beg < end) {
            int sum = nums[beg] + nums[end];
            if (sum == target) {
                List<Integer> answer = new ArrayList<Integer>();
                answer.add(nums[startIdx]);
                answer.add(nums[beg]);
                answer.add(nums[end]);
                result.add(answer);
                beg = moveToRight(nums, beg);
                end = moveToLeft(nums, end);
            } else if (sum < target) {
                beg = moveToRight(nums, beg);
            } else {
                end = moveToLeft(nums, end);
            }
        }

        return result;
    }

}
