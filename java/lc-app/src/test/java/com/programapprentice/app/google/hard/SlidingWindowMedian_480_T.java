package com.programapprentice.app.google.hard;

import org.junit.Test;

import java.util.PriorityQueue;

public class SlidingWindowMedian_480_T {
    SlidingWindowMedian_480 solution = new SlidingWindowMedian_480();

    @Test
    public void test1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = solution.medianSlidingWindow(nums, k);

    }
}
