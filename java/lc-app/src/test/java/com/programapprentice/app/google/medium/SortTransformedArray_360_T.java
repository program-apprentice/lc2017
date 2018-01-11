package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class SortTransformedArray_360_T {
    SortTransformedArray_360 solution = new SortTransformedArray_360();

    @Test
    public void test1() {
        int[] nums = {-4, -2, 2, 4};
        int[] result = solution.sortTransformedArray(nums, -1, 3, 5);
        TestUtil.printArray(result);
    }
}
