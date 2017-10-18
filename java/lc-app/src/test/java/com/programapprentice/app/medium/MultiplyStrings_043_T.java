package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyStrings_043_T {
    MultiplyStrings_043 solution = new MultiplyStrings_043();


    @Test
    public void test1() {
        String s1 = "98";
        String s2 = "9";
        String actual = solution.multiply(s1, s2);
        Assert.assertEquals("882", actual);
    }

    @Test
    public void test2() {
        String s1 = "123";
        String s2 = "456";
        String actual = solution.multiply(s1, s2);
        Assert.assertEquals("56088", actual);
    }
}
