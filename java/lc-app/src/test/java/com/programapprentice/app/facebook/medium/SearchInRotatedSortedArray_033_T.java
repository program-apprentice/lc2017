package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArray_033_T {
    SearchInRotatedSortedArray_033 solution = new SearchInRotatedSortedArray_033();

    @Test
    public void test1() {
        int[] nums = {1, 3};
        int actual = solution.search(nums, 3);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test2() {
        int[] nums = {1, 3, 5};
        int actual = solution.search(nums, 1);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void test3() {
        int[] nums = {3, 5, 1};
        int actual = solution.search(nums, 1);
        Assert.assertEquals(2, actual);
    }
}
