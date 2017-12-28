package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class AddBoldTagInString_616_T {
    AddBoldTagInString_616 solution = new AddBoldTagInString_616();

    @Test
    public void test1() {
        String[] dict = {"aaa","aab","bc"};
        String s = "aaabbcc";
        String actual = solution.addBoldTag(s, dict);
        Assert.assertEquals(actual, "<b>aaabbc</b>c");
    }

    @Test
    public void test2() {
        String[] dict = {"abc","123"};
        String s = "abcxyz123";
        String actual = solution.addBoldTag(s, dict);
        Assert.assertEquals(actual, "<b>abc</b>xyz<b>123</b>");
    }
}
