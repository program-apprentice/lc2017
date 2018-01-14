package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class AndroidUnlockPattern_351_T {
    AndroidUnlockPattern_351 solution = new AndroidUnlockPattern_351();

    @Test
    public void test1() {
        int actual = solution.numberOfPatterns(1, 2);
        Assert.assertEquals(65, actual);
    }

    @Test
    public void test2() {
        int actual = solution.numberOfPatterns(1, 3);
        Assert.assertEquals(385, actual);
    }

    @Test
    public void test3() {
        int actual = solution.numberOfPatterns(3, 7);
        Assert.assertEquals(108024, actual);
    }

    @Test
    public void test4() {
        int actual = solution.numberOfPatterns(4, 9);
        Assert.assertEquals(389112, actual);
    }
}
