package com.programapprentice.app.google.hard;

import org.junit.Test;

public class MinimumUniqueWordAbbreviation_411_T {
    MinimumUniqueWordAbbreviation_411 solution = new MinimumUniqueWordAbbreviation_411();

    @Test
    public void test1() {
        String[] dictionary = {"blade"};
        String target = "apple";
        String result = solution.minAbbreviation(target, dictionary);
        System.out.println(result);
    }
}
