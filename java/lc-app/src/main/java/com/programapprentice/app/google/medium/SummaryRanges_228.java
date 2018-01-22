package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    /**
     https://leetcode.com/problems/summary-ranges/description/
     Given a sorted integer array without duplicates, return the summary of its ranges.

     Example 1:
     Input: [0,1,2,4,5,7]
     Output: ["0->2","4->5","7"]

     Example 2:
     Input: [0,2,3,4,6,8,9]
     Output: ["0","2->4","6","8->9"]
     * */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length ==0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int pre = nums[0];
        int start = 0;
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > pre + 1) {
                if (i - start == 1) {
                    result.add(Integer.toString(nums[start]));
                } else {
                    result.add(String.format("%d->%d", nums[start], nums[i-1]));
                }
                start = i;
            }
            pre = cur;
        }
        if (nums.length-start == 1) {
            result.add(Integer.toString(nums[start]));
        } else {
            result.add(String.format("%d->%d", nums[start], nums[nums.length-1]));
        }

        return  result;
    }
}
