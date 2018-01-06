package com.programapprentice.app.google.medium;

import org.junit.Test;

public class MaximumXOROfTwoNumbers_421_T {
    MaximumXOROfTwoNumbers_421 solution = new MaximumXOROfTwoNumbers_421();

    @Test
    public void test1() {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int result = solution.findMaximumXOR(nums);
        System.out.println(String.format("result is %d", result));
    }
}
