package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakElement_162_T {
    FindPeakElement_162 solution = new FindPeakElement_162();

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        int actual = solution.findPeakElement(nums);
        Assert.assertEquals(2, actual);
    }
}
