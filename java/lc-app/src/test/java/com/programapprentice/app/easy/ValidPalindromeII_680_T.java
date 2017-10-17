package com.programapprentice.app.easy;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeII_680_T {
    ValidPalindromeII_680 solution = new ValidPalindromeII_680();

    @Test
    public void test1() {
        String s = "deeee";
        boolean result = solution.validPalindrome(s);
        Assert.assertEquals(true, result);
    }
}
