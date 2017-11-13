package com.programapprentice.app.google.easy;

public class ShortestUnsortedContinuousSubarray_581 {
    /**
     https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
     Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

     You need to find the shortest such subarray and output its length.

     Example 1:
     Input: [2, 6, 4, 8, 10, 9, 15]
     Output: 5
     Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     Note:
     Then length of the input array is in range [1, 10,000].
     The input array may contain duplicates, so ascending order here means <=.

     Solution: http://www.cnblogs.com/grandyang/p/6876457.html
     http://blog.csdn.net/gqk289/article/details/72528965
     * */

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = -1;
        int end = -2;
        int min = nums[n-1];
        int max = nums[0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max > nums[i]) {
                end = i;
            }
            min = Math.min(min, nums[n-1-i]);
            if (min < nums[n-1-i]) {
                start = n-1-i;
            }
        }
        return end - start + 1;
    }
}
