package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class GuessNumberHigherOrLowerII_375_T {
    GuessNumberHigherOrLowerII_375 solution = new GuessNumberHigherOrLowerII_375();

    @Test
    public void test1() {
        int actual = solution.getMoneyAmount(3);
        System.out.println(actual);
        Assert.assertEquals(2, actual);
    }
}
