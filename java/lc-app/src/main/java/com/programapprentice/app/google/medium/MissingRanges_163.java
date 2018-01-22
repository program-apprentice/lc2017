package com.programapprentice.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
    /**
     https://leetcode.com/problems/missing-ranges/description/

     Given a sorted integer array where the range of elements are in the inclusive
     range [lower, upper], return its missing ranges.

     For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
     return ["2", "4->49", "51->74", "76->99"].
     * */

    public String getMissingRange(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        } else {
            return String.format("%d->%d", start, end);
        }
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length ==0) {
            result.add(getMissingRange(lower, upper));
            return result;
        }
        if (lower < nums[0]) {
            result.add(getMissingRange(lower, nums[0]-1));
        }
        int pre = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == pre) {
                continue;
            }
            if (cur > pre + 1) {
                int start = pre+1;
                int end = cur-1;
                result.add(getMissingRange(start, end));
            }
            pre = cur;
        }
        int cur = nums[nums.length-1];
        if (cur < upper) {
            result.add(getMissingRange(cur+1, upper));
        }
        return  result;
    }
}
