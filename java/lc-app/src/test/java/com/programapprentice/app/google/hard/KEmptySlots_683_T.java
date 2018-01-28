package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class KEmptySlots_683_T {
    KEmptySlots_683 solution = new KEmptySlots_683();

    @Test
    public void test1() {
        int[] flowers = {1, 3, 2};
        int actual = solution.kEmptySlots(flowers, 1);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test2() {
        int[] flowers = {1, 2, 3};
        int actual = solution.kEmptySlots(flowers, 1);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void test3() {
        int[] flowers = {3,9,2,8,1,6,10,5,4,7};
        int actual = solution.kEmptySlots(flowers, 1);
        Assert.assertEquals(6, actual);
    }
}
