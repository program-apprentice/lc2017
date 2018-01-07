package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class DecodeString_394_T {
    DecodeString_394 solution = new DecodeString_394();

    @Test
    public void test1() {
        String s = "3[a]2[bc]";
        String actual = solution.decodeString(s);
        Assert.assertEquals("aaabcbc", actual);
    }

    @Test
    public void test2() {
        String s = "3[a2[c]]";
        String actual = solution.decodeString(s);
        Assert.assertEquals("accaccacc", actual);
    }

    @Test
    public void test3() {
        String s = "2[abc]3[cd]ef";
        String actual = solution.decodeString(s);
        Assert.assertEquals("abcabccdcdcdef", actual);
    }

    @Test
    public void test4() {
        String s = "2[2[b]]";
        String actual = solution.decodeString(s);
        Assert.assertEquals("bbbb", actual);
    }
}
