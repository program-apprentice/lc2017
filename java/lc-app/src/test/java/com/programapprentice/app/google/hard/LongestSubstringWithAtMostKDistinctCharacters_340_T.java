package com.programapprentice.app.google.hard;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithAtMostKDistinctCharacters_340_T {
    LongestSubstringWithAtMostKDistinctCharacters_340 solution = new LongestSubstringWithAtMostKDistinctCharacters_340();

    @Test
    public void test1() {
        String s = "eceba";
        int k = 2;
        Assert.assertEquals(3, solution.lengthOfLongestSubstringKDistinct(s, k));
    }

}
