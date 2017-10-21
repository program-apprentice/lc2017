package com.programapprentice.app.medium;

public class MinimumSizeSubarraySum_209 {
    /**
     [209] Minimum Size Subarray Sum

     https://leetcode.com/problems/minimum-size-subarray-sum

     Given an array of n positive integers and a positive integer s,
     find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

     For example, given the array [2,3,1,2,4,3] and s = 7,
     the subarray [4,3] has the minimal length under the problem constraint.

     click to show more practice.

     More practice:

     If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
    * */

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int startIdx = 0;
        int endIdx = 0;
        int sum = 0;
        int min = -1;
        while(endIdx < nums.length) {
            sum += nums[endIdx];

            if (sum < s) {
                endIdx++;
                continue;
            } else if (sum > s) {
                min = min == -1 ? endIdx - startIdx + 1 : Math.min(min, endIdx - startIdx + 1);
                while(sum >= s) {
                    sum -= nums[startIdx];
                    if (sum < s) {
                        startIdx++;
                        break;
                    } else if (sum - nums[startIdx] > s) {
                        startIdx++;
                    } else {
                        startIdx++;
                        min = min == -1 ? endIdx - startIdx + 1 : Math.min(min, endIdx - startIdx + 1);
                    }
                }
                endIdx++;
            } else { // sum == s
                min = min == -1 ? endIdx - startIdx + 1 : Math.min(min, endIdx - startIdx + 1);
                startIdx++;
                endIdx++;
            }
        }
        return min == -1 ? 0 : min;
    }
}
