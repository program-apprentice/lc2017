package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class LongestAbsoluteFilePath_388_T {
    LongestAbsoluteFilePath_388 solution = new LongestAbsoluteFilePath_388();

    @Test
    public void test1() {
        String input = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        int actual = solution.lengthLongestPath(input);
        System.out.println(actual);
        Assert.assertEquals(39, actual);
    }

    @Test
    public void test2() {
        String input = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
        int actual = solution.lengthLongestPath(input);
        System.out.println(actual);
        Assert.assertEquals(89, actual);
    }

    @Test
    public void test3() {
        String input = "a\n\tb.txt\na2\n\tb2.txt";
        int actual = solution.lengthLongestPath(input);
        System.out.println(actual);
        Assert.assertEquals(9, actual);
    }

    @Test
    public void test4() {
        String input = "a";
        int actual = solution.lengthLongestPath(input);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void test5() {
        String input = "dir\n        file.txt";
        int actual = solution.lengthLongestPath(input);
        Assert.assertEquals(16, actual);
    }
}
