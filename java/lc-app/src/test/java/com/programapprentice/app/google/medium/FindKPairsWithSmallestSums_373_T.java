package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.List;

public class FindKPairsWithSmallestSums_373_T {
    FindKPairswithSmallestSums_373 solution = new FindKPairswithSmallestSums_373();

    @Test
    public void test1() {
        int[] nums1 = {-13,23,44,117,900,990};
        int[] nums2 = {-15,20,35,118,223,500,663,717,789,813};
        List<int[]> result = solution.kSmallestPairs(nums1, nums2, 10);
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        List<int[]> result = solution.kSmallestPairs(nums1, nums2, 10);
        TestUtil.printListOfArray(result);
    }
}
