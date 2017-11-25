package com.programapprentice.app.google.easy;

import org.junit.Assert;
import org.junit.Test;

public class ValidWordAbbreviation_408_T {
    ValidwordAbbreviation_408 solution = new ValidwordAbbreviation_408();

    @Test
    public void test1() {
        String word = "internationalization";
        String abbr = "i12iz4n";
        Boolean actual = solution.validWordAbbreviation(word, abbr);
        Assert.assertTrue(actual);
    }

    @Test
    public void test2() {
        String word = "hi";
        String abbr = "2i";
        Boolean actual = solution.validWordAbbreviation(word, abbr);
        Assert.assertFalse(actual);
    }

    @Test
    public void test3() {
        String word = "internationalization";
        String abbr = "i5a11o1";
        Boolean actual = solution.validWordAbbreviation(word, abbr);
        Assert.assertTrue(actual);
    }

    @Test
    public void test4() {
        String word = "a";
        String abbr = "01";
        Boolean actual = solution.validWordAbbreviation(word, abbr);
        Assert.assertFalse(actual);
    }

    @Test
    public void test5() {
        String word = "hi";
        String abbr = "1";
        Boolean actual = solution.validWordAbbreviation(word, abbr);
        Assert.assertFalse(actual);
    }
}
