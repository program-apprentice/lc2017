package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class DecodeWays_091_T {
    DecodeWays_091 solutuion = new DecodeWays_091();

    @Test
    public void test1() {
        String input = "100";
        int actual = solutuion.numDecodings(input);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void test2() {
        String input = "1212";
        int actual = solutuion.numDecodings(input);
        Assert.assertEquals(5, actual);
    }

    @Test
    public void test3() {
        String input = "227";
        int actual = solutuion.numDecodings(input);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test4() {
        String input = "301";
        int actual = solutuion.numDecodings(input);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void test5() {
        String input = "10";
        int actual = solutuion.numDecodings(input);
        Assert.assertEquals(1, actual);
    }
}
