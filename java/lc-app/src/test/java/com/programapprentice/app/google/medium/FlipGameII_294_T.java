package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class FlipGameII_294_T {
    FlipGameII_294 solution = new FlipGameII_294();

    @Test
    public void test1() {
        String s = "++++++++";
        boolean actual = solution.canWin(s);
        Assert.assertEquals(true, actual);
    }

    @Test
    public void test2() {
        String s = "++++";
        boolean actual = solution.canWin(s);
        Assert.assertEquals(true, actual);
    }
}
