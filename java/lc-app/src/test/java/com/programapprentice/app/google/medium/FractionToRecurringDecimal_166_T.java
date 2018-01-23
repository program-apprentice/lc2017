package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class FractionToRecurringDecimal_166_T {
    FractionToRecurringDecimal_166 solution = new FractionToRecurringDecimal_166();

    @Test
    public void test1() {
        String actual = solution.fractionToDecimal(1, 12344);
        System.out.println(actual);
    }

    @Test
    public void test2() {
        String actual = solution.fractionToDecimal(1, 8);
        System.out.println(actual);
    }

    @Test
    public void test3() {
        String actual = solution.fractionToDecimal(1, 800);
        System.out.println(actual);
    }

    @Test
    public void test4() {
        String actual = solution.fractionToDecimal(2, 3);
        System.out.println(actual);
    }

    @Test
    public void test5() {
        String actual = solution.fractionToDecimal(1, 6);
        System.out.println(actual);
    }

    @Test
    public void test6() {
        String actual = solution.fractionToDecimal(1, 99);
        System.out.println(actual);
        Assert.assertEquals("0.(01)", actual);
    }

    @Test
    public void test7() {
        String actual = solution.fractionToDecimal(-50, 8);
        System.out.println(actual);
        Assert.assertEquals("-6.25", actual);
    }

    @Test
    public void test8() {
        String actual = solution.fractionToDecimal(7, -12);
        System.out.println(actual);
        Assert.assertEquals("-0.58(3)", actual);
    }

    @Test
    public void test9() {
        String actual = solution.fractionToDecimal(-1, Integer.MIN_VALUE);
        System.out.println(actual);
        Assert.assertEquals("0.0000000004656612873077392578125", actual);
    }
}
