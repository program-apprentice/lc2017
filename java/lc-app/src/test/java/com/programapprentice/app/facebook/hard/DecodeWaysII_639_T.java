package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class DecodeWaysII_639_T {
    DecodeWaysII_639 solution = new DecodeWaysII_639();

    @Test
    public void test1() {
        String s = "*";
        int num = solution.numDecodings(s);
        Assert.assertEquals(9, num);
    }

    @Test
    public void test2() {
        String s = "1*";
        int num = solution.numDecodings(s);
        Assert.assertEquals(18, num);
    }

    @Test
    public void test3() {
        String s = "2*";
        int num = solution.numDecodings(s);
        Assert.assertEquals(15, num);
    }

    @Test
    public void test4() {
        String s = "3*";
        int num = solution.numDecodings(s);
        Assert.assertEquals(9, num);
    }

    @Test
    public void test5() {
        String s = "**";
        int num = solution.numDecodings(s);
        Assert.assertEquals(96, num);
    }

    @Test
    public void test6() {
        String s = "*1";
        int num = solution.numDecodings(s);
        Assert.assertEquals(11, num);
    }

    @Test
    public void test7() {
        String s = "***";
        int num = solution.numDecodings(s);
        Assert.assertEquals(999, num);
    }

    @Test
    public void test8() {
        String s = "1*72*";
        int num = solution.numDecodings(s);
        Assert.assertEquals(285, num);
    }

    @Test
    public void test9() {
        String s = "*********";
        int num = solution.numDecodings(s);
        System.out.println(Integer.MAX_VALUE);
        Assert.assertEquals(291868912, num);
    }
}
