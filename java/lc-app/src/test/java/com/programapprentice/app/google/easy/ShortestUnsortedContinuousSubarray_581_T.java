package com.programapprentice.app.google.easy;

import org.junit.Assert;
import org.junit.Test;

public class ShortestUnsortedContinuousSubarray_581_T {
    ShortestUnsortedContinuousSubarray_581 solution = new ShortestUnsortedContinuousSubarray_581();

    @Test
    public void test1() {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int result = solution.findUnsortedSubarray(nums);
        Assert.assertEquals(5, result);
    }

}
