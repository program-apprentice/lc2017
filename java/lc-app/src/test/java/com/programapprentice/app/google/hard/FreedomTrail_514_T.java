package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class FreedomTrail_514_T {
    FreedomTrail_514 solution = new FreedomTrail_514();

    @Test
    public void test1() {
        String ring = "godding";
        String key = "gd";
        int actual = solution.findRotateSteps(ring, key);
        Assert.assertEquals(4, actual);
    }
}
