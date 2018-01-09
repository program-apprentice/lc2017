package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class RemoveKDigits_402_T {
    RemoveKDigits_402 solution = new RemoveKDigits_402();

    @Test
    public void test1() {
        String actual = solution.removeKdigits("1432219", 3);
        Assert.assertEquals(actual, "1219");
    }

    @Test
    public void test2() {
        String actual = solution.removeKdigits("10200", 1);
        Assert.assertEquals(actual, "200");
    }

    @Test
    public void test3() {
        String actual = solution.removeKdigits("10200", 2);
        Assert.assertEquals(actual, "0");
    }
}
