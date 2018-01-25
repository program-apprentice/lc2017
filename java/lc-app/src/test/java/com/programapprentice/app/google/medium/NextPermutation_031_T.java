package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class NextPermutation_031_T {
    NextPermutation_031 solution = new NextPermutation_031();

    @Test
    public void test1() {
        int[] nums = {1, 2, 4, 9, 8, 7};
        solution.nextPermutation(nums);
        TestUtil.printArray(nums);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        solution.nextPermutation(nums);
        TestUtil.printArray(nums);
    }

    @Test
    public void test3() {
        int[] nums = {2, 3, 1};
        solution.nextPermutation(nums);
        TestUtil.printArray(nums);
    }
}
