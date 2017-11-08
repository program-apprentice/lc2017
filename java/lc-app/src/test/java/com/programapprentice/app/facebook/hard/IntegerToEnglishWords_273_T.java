package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToEnglishWords_273_T {
    IntegerToEnglishWords_273 solution = new IntegerToEnglishWords_273();

    @Test
    public void test1() {
        int num = 3234;
        String output = solution.numberToWords(num);
        Assert.assertEquals("Three Thousand Two Hundred Thirty Four", output);
    }

    @Test
    public void test2() {
        int num = 1000;
        String output = solution.numberToWords(num);
        Assert.assertEquals("One Thousand", output);
    }

    @Test
    public void test3() {
        int num = 1000000;
        String output = solution.numberToWords(num);
        Assert.assertEquals("One Million", output);
    }
}
