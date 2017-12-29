package com.programapprentice.app.contest.costest63;

import com.programapprentice.app.contest63.ShortestCompletingWord_748;
import org.junit.Assert;
import org.junit.Test;

public class ShortestCompletingWord_748_T {
    ShortestCompletingWord_748 solution = new ShortestCompletingWord_748();

    @Test
    public void test1() {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        String actual = solution.shortestCompletingWord(licensePlate, words);
        Assert.assertEquals("steps", actual);
    }

    @Test
    public void test2() {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        String actual = solution.shortestCompletingWord(licensePlate, words);
        Assert.assertEquals("pest", actual);
    }

    @Test
    public void test3() {
        String licensePlate = "GrC8950";
        String[] words = {"measure","other","every","base","according","level","meeting","none","marriage","rest"};
        String actual = solution.shortestCompletingWord(licensePlate, words);
        Assert.assertEquals("according", actual);
    }
}
