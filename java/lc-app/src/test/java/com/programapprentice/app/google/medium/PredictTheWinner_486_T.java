package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class PredictTheWinner_486_T {
    PredictTheWinner_486 solution = new PredictTheWinner_486();

    @Test
    public void test1() {
        int[] nums = {1, 5 ,2};
        boolean actual = solution.PredictTheWinner(nums);
        Assert.assertFalse(actual);
    }
}
