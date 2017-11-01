package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class PalindromicSubstrings_647_T {
    PalindromicSubstrings_647 solution = new PalindromicSubstrings_647();

    @Test
    public void test1() {
        String s = "fdsklf";
        int actual = solution.countSubstrings(s);
        Assert.assertEquals(6, actual);
    }
}
