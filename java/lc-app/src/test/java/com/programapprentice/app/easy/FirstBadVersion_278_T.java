package com.programapprentice.app.easy;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersion_278_T {
    FirstBadVersion_278 solution = new FirstBadVersion_278();

    @Test
    public void test1() {
        int actual = solution.firstBadVersion(2);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        /**
        2126753390 versions
        1702766719 is the first bad version.*/
        int actual = solution.firstBadVersion(2126753390);
        Assert.assertEquals(1702766719, actual);
    }
}
