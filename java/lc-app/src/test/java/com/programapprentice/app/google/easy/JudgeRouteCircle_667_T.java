package com.programapprentice.app.google.easy;

import org.junit.Assert;
import org.junit.Test;

public class JudgeRouteCircle_667_T {
    JudgeRouteCircle_657 solution = new JudgeRouteCircle_657();

    @Test
    public void test1() {
        boolean result = solution.judgeCircle("UD");
        Assert.assertTrue(result);
    }

    @Test
    public void test2() {
        boolean result = solution.judgeCircle("LL");
        Assert.assertFalse(result);
    }
}
