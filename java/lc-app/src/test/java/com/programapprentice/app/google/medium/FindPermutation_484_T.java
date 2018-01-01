package com.programapprentice.app.google.medium;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

public class FindPermutation_484_T {
    FindPermutation_484 solution = new FindPermutation_484();

    @Test
    public void test1() {
        String s = "DDIIDI";
        int[] actual = solution.findPermutation(s);
        TestUtil.printArray(actual);
    }

    @Test
    public void test2() {
        String s = "D";
        int[] actual = solution.findPermutation(s);
        TestUtil.printArray(actual);
    }
}
