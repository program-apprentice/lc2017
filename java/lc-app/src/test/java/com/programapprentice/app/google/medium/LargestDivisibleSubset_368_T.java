package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class LargestDivisibleSubset_368_T {
    LargestDivisibleSubset_368 solution = new LargestDivisibleSubset_368();

    @Test
    public void test1() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        TestUtil.printArrayList(result);
    }
}
