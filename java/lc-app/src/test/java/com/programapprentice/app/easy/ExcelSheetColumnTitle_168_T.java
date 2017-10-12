package com.programapprentice.app.easy;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumnTitle_168_T {
    ExcelSheetColumnTitle_168 solution = new ExcelSheetColumnTitle_168();
    @Test
    public void test1() {
        int x = 1;
        String actual = solution.convertToTitle(x);
        String expected = "A";
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        int x = 26;
        String actual = solution.convertToTitle(x);
        String expected = "Z";
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }
}
