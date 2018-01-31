package com.programapprentice.app.google.hard;

import org.junit.Test;

public class MaximumAverageSubarray_II_644_T {
    MaximumAverageSubarray_II_644 solution = new MaximumAverageSubarray_II_644();

    @Test
    public void test1() {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(solution.findMaxAverage(nums, k));
    }
}
