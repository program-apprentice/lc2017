package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class MissingRanges_163_T {
    MissingRanges_163 solution = new MissingRanges_163();

    @Test
    public void test1() {
        int[] nums = {0,1,2,4,5,7};
        List<String> result = solution.findMissingRanges(nums, 0, 99);
        TestUtil.printArray(result);
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 3, 50, 75};
        List<String> result = solution.findMissingRanges(nums, 0, 99);
        TestUtil.printArray(result);
    }

    @Test
    public void test3() {
        int[] nums = {};
        List<String> result = solution.findMissingRanges(nums, 1, 1);
        TestUtil.printArray(result);
    }

    @Test
    public void test4() {
        int[] nums = {-1};
        List<String> result = solution.findMissingRanges(nums, -1, 0);
        TestUtil.printArray(result);
    }

    @Test
    public void test5() {
        int[] nums = {-2147483648,-2147483648,0,2147483647,2147483647};
        List<String> result = solution.findMissingRanges(nums, -2147483648, 2147483647);
        TestUtil.printArray(result);
    }
}
