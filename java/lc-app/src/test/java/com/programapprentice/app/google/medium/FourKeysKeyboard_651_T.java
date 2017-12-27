package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class FourKeysKeyboard_651_T {
    FourKeysKeyboard_651 solution = new FourKeysKeyboard_651();

    @Test
    public void test1() {
        int result = solution.maxA(7);
        Assert.assertEquals(9, result);
    }

    @Test
    public void test2() {
        int result = solution.maxA(12);
        Assert.assertEquals(36, result);
    }
}
