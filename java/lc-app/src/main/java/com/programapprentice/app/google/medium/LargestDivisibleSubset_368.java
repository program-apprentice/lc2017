package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
    /**
     https://leetcode.com/problems/largest-divisible-subset/description/
     Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

     If there are multiple solutions, return any subset is fine.

     Example 1:

     nums: [1,2,3]

     Result: [1,2] (of course, [1,3] will also be ok)
     Example 2:

     nums: [1,2,4,8]

     Result: [1,2,4,8]

     Solution:
     http://www.cnblogs.com/grandyang/p/5625209.html
     * */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        int n = nums.length;
        int[] opts = new int[n];
        int[] parent = new int[n];
        int max = 0;
        int maxIdx = 0;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if (nums[j] % nums[i] == 0 && opts[i] < opts[j] + 1) { // if can be divided, also it has more dividable
                    opts[i] = opts[j] + 1;
                    parent[i] = j;
                    if (max < opts[i]) {
                        max = opts[i];
                        maxIdx = i;
                    }
                }
            }
        }
        for(int i = 0; i < max; i++) {
            list.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }

        return list;
    }
}
