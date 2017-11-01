package com.programapprentice.app.facebook.easy;

import org.junit.Assert;
import org.junit.Test;

public class StrStr038_T {
    StrStr038 solution = new StrStr038();

    @Test
    public void test1() {
        String hackstack = "ABC ABCDAB ABCDABCDABDE";
        String needle = "ABCDABD";
        int result = solution.strStr(hackstack, needle);
        Assert.assertEquals(15, result);
    }

    @Test
    public void test3() {
        String hackstack = "aaa";
        String needle = "aaaa";
        int result = solution.strStr(hackstack, needle);
        System.out.println(result);
    }

    @Test
    public void test4() {
        String hackstack = "mississippi";
        String needle = "a";
        int result = solution.strStr(hackstack, needle);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void test5() {
        String hackstack = "mississippi";
        String needle = "issi";
        int result = solution.strStr(hackstack, needle);
        Assert.assertEquals(1, result);
    }
}
