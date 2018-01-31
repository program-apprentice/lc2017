package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class TwentyFourGame_679_T {
    TwentyFourGame_679 solution = new TwentyFourGame_679();

    @Test
    public void test1() {
        int[] nums = {1, 4, 8, 7};
        Assert.assertTrue(solution.judgePoint24(nums));
    }
}
