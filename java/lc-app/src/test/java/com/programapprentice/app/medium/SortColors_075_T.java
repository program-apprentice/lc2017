package com.programapprentice.app.medium;

import org.junit.Test;

public class SortColors_075_T {
    SortColors_075 solution = new SortColors_075();

    @Test
    public void test1() {
        int[] nums = {0, 0};
        solution.sortColors(nums);
    }

    @Test
    public void test2() {
        int[] nums = {0, 1};
        solution.sortColors(nums);
    }
}
