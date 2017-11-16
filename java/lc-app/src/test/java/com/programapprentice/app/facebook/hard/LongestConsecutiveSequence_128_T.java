package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequence_128_T {
    LongestConsecutiveSequence_128 solution = new LongestConsecutiveSequence_128();

    @Test
    public void test1() {
    int[] nums = {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, solution.longestConsecutive(nums));
    }
}
