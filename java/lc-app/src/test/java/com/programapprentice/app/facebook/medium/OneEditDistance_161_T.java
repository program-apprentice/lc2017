package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class OneEditDistance_161_T {
    OneEditDistance_161 solution = new OneEditDistance_161();

    @Test
    public void  test1() {
        String s1 = "a";
        String s2 = "ba";
        Boolean actual = solution.isOneEditDistance(s1, s2);
        Assert.assertTrue(actual);
    }

    @Test
    public void  test2() {
        String s1 = "a";
        String s2 = "a";
        Boolean actual = solution.isOneEditDistance(s1, s2);
        Assert.assertFalse(actual);
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "ac";
        Boolean actual = solution.isOneEditDistance(s1, s2);
        Assert.assertTrue(actual);
    }
}
