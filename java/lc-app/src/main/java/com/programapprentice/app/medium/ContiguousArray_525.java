package com.programapprentice.app.medium;

import java.util.HashMap;

public class ContiguousArray_525 {
    /**
     Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

     Example 1:
     Input: [0,1]
     Output: 2
     Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     Example 2:
     Input: [0,1,0]
     Output: 2
     Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     Note: The length of the given binary array will not exceed 50,000.
     * */

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int[] diff = new int[n+1];
        map.put(0, 0);
        int res = 0;
        for(int i = 1; i <= n; i++) {
            diff[i] = diff[i-1] + (nums[i-1] == 0 ? -1 : 1);
            if(!map.containsKey(diff[i]))
                map.put(diff[i], i);
            else {
                res = Math.max(res, i-map.get(diff[i]));
            }
        }
        return res;

    }
}
