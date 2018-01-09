package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class UTF8Validation_393_T {
    UTF8Validation_393 solution = new UTF8Validation_393();

    @Test
    public void test1() {
        int[] data = {197, 130, 1};
        boolean actual = solution.validUtf8(data);
        Assert.assertEquals(actual, true);
    }

    @Test
    public void test2() {
        int[] data = {235, 140, 4};
        boolean actual = solution.validUtf8(data);
        Assert.assertEquals(actual, false);
    }

    @Test
    public void test3() {
        int[] data = {240, 162, 138, 147, 145};
        for(int num : data) {
            System.out.print(Integer.toBinaryString(num) + "  ");
        }
        boolean actual = solution.validUtf8(data);
        Assert.assertEquals(actual, false);
    }
}
