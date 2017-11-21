package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class MinimumWindowSubstring_076_T {
    MinimumWindowSubstring_076 solution = new MinimumWindowSubstring_076();

    @Test
    public void test1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String actual = solution.minWindow(s, t);
        Assert.assertEquals(actual, "BANC");
    }

    @Test
    public void test2() {
        String s = "AA";
        String t = "AA";
        String actual = solution.minWindow(s, t);
        Assert.assertEquals(actual, "AA");
    }

    @Test
    public void test3() {
        String s = "bba";
        String t = "ab";
        String actual = solution.minWindow(s, t);
        Assert.assertEquals(actual, "ba");
    }

    @Test
    public void test4() {
        String s = "ab";
        String t = "b";
        String actual = solution.minWindow(s, t);
        Assert.assertEquals(actual, "b");
    }
}
