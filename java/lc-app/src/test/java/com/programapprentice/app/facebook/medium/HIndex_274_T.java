package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class HIndex_274_T {
    HIndex_274 solution = new HIndex_274();

    @Test
    public void test1() {
        int[] citations = {3, 0, 6, 1, 5};
        int actual = solution.hIndex(citations);
        Assert.assertEquals(3, actual);
    }
}
