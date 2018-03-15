package com.programapprentice.app.google.hard;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class CountOfSmallerNumbers_315_T {
    CountOfSmallerNumbers_315 solution = new CountOfSmallerNumbers_315();

    @Test
    public void test1() {
        int[] nums = {8, 5, 2, 7, 6, 4};
        List<Integer> result = solution.countSmaller(nums);
        TestUtil.printArrayList(result);
    }

    @Test
    public void test2() {
        int[] nums = {-1, -1};
        List<Integer> result = solution.countSmaller(nums);
        TestUtil.printArrayList(result);
    }
}
