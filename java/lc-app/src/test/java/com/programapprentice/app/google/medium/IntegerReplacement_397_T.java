package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class IntegerReplacement_397_T {
    IntegerReplacement_397 solution = new IntegerReplacement_397();

    @Test
    public void test1() {
        int actual = solution.integerReplacement(8);
        System.out.println(actual);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test2() {
        int actual = solution.integerReplacement(2147483647);
        System.out.println(actual);
        Assert.assertEquals(32, actual);
    }
}
