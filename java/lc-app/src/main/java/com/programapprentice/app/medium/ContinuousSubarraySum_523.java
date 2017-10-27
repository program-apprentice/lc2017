package com.programapprentice.app.medium;

import java.util.HashMap;

public class ContinuousSubarraySum_523 {
    /**
     Given a list of non-negative numbers and a target integer k,
     write a function to check if the array has a continuous subarray of size at
     least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

     Example 1:
     Input: [23, 2, 4, 6, 7],  k=6
     Output: True
     Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
     Example 2:
     Input: [23, 2, 6, 4, 7],  k=6
     Output: True
     Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
     Note:
     The length of the array won't exceed 10,000.
     You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
     * */

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int n = nums.length;
        if (0 == k) {
            for(int i = 1; i < n; i++) {
                if (nums[i-1] == 0 && nums[i] == 0) {
                    return true;
                }
            }
            return false;
        }
        if (nums.length == 2) {
            return ((nums[0] + nums[1]) % k) == 0;
        }
        HashMap<Integer, Integer> remainingToIdxMap = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            count += nums[i];
            count = count % k;
            if (i == 0) {
                remainingToIdxMap.put(count, i);
                continue;
            }
            if (count == 0) {
                return true;
            }
            if (remainingToIdxMap.containsKey(count)) {
                int idx = remainingToIdxMap.get(count);
                if (idx == i-1) {
                    continue;
                } else {
                    return true;
                }
            } else {
                remainingToIdxMap.put(count, i);
            }
        }
        return false;
    }

}
