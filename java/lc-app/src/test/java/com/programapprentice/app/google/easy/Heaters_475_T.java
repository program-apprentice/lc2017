package com.programapprentice.app.google.easy;

import org.junit.Assert;
import org.junit.Test;

public class Heaters_475_T {
    Heaters_475 solution = new Heaters_475();

    @Test
    public void test1() {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        Assert.assertEquals(1, solution.findRadius(houses, heaters));
    }

    @Test
    public void test2() {
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        Assert.assertEquals(1, solution.findRadius(houses, heaters));
    }
}
