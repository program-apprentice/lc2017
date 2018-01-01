package com.programapprentice.app.google.medium;

import com.programapprentice.app.model.Interval;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnesII_487 {
    /**
     https://leetcode.com/problems/max-consecutive-ones-ii/description/
     Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

     Example 1:
     Input: [1,0,1,1,0]
     Output: 4
     Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     After flipping, the maximum number of consecutive 1s is 4.
     Note:

     The input array will only contain 0 and 1.
     The length of input array is a positive integer and will not exceed 10,000

     Follow up:
     What if the input numbers come in one by one as an infinite stream? In other words,
     you can't store all numbers coming from the stream as it's too large to hold in memory.
     Could you solve it efficiently?
     * */
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findMaxConsecutiveOnesWrong(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Interval> intervals = new ArrayList<Interval>();
        int start = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i == nums.length - 1) {
                    intervals.add(new Interval(start, nums.length-1));
                } else {
                    end = i;
                }
            } else {
                if (i > 0 && nums[i-1] == 1) {
                    intervals.add(new Interval(start, end));
                }
                start = i+1;
                end = start;
            }
        }
        int result = 0;
        if (intervals.size() == 0) {
            return 1;
        } else if (intervals.size() == 1) {
            Interval interval = intervals.get(0);
            if (interval.end -interval.start + 1 < nums.length) {
                return interval.end -interval.start + 2;
            } else {
                return nums.length;
            }
        }
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start - pre.end == 2) {
                result = Math.max(result, cur.end - pre.start + 1);
            }
            pre = cur;
        }
        return result;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        boolean changeToZero = false;
        int counter = 0;
        int counterAfterZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                counter++;
                counterAfterZero++;
                result = Math.max(result, counter);
            } else {
                if (!changeToZero) {
                    counterAfterZero = 0;
                    counter++;
                    result = Math.max(result, counter);
                    changeToZero = true;
                } else {
                    counter = counterAfterZero;
                    counter++;
                    counterAfterZero = 0;
                }
            }

        }
        return result;
    }
}
