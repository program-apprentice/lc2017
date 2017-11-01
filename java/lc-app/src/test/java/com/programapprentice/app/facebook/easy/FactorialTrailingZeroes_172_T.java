package com.programapprentice.app.facebook.easy;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTrailingZeroes_172_T {
    FactorialTrailingZeroes_172 solution = new FactorialTrailingZeroes_172();

    @Test
    public void test1() {
        int result = solution.trailingZeroes(1808548329);
        int expected = 452137076;
        Assert.assertEquals(result, expected);
    }
}
