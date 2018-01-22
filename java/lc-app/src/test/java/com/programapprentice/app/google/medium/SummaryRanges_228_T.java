package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class SummaryRanges_228_T {
    SummaryRanges_228 solution = new SummaryRanges_228();

    @Test
    public void test1() {
        int[] nums = {0,1,2,4,5,7};
        List<String> result = solution.summaryRanges(nums);
        TestUtil.printArray(result);
    }

    @Test
    public void test2() {
        int[] nums = {0,2,3,4,6,8,9};
        List<String> result = solution.summaryRanges(nums);
        TestUtil.printArray(result);
    }
}
