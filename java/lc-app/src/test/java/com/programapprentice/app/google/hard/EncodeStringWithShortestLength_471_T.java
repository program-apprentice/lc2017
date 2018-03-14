package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class EncodeStringWithShortestLength_471_T {
    EncodeStringWithShortestLength_471 solution = new EncodeStringWithShortestLength_471();

    @Test
    public void test1() {
        String s = "aaa";
        System.out.println(s.substring(0, 3));
        String result = solution.encode(s);
        Assert.assertEquals("aaa", result);
    }


    @Test
    public void test2() {
        String s = "aaaaa";
        String result = solution.encode(s);
        Assert.assertEquals("5[a]", result);
    }
}
