package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LongestWordInDictionaryThroughDeleting_524_T {
    LongestWordInDictionaryThroughDeleting_524 solution = new LongestWordInDictionaryThroughDeleting_524();

    @Test
    public void test1() {
        String s = "bab";
        String[] dict = {"ba","ab","a","b"};
        String actual = solution.findLongestWord(s, Arrays.asList(dict));
        Assert.assertEquals("ab", actual);
    }

    @Test
    public void test2() {
        String s = "wordgoodgoodgoodbestword";
        String[] dict = {"word","good","best","good"};
        String actual = solution.findLongestWord(s, Arrays.asList(dict));
        Assert.assertEquals("best", actual);
    }

    @Test
    public void test3() {
        String str = "best";
        String result = "good";
        Assert.assertTrue(solution.isSmaller(str, result));
        Assert.assertFalse(solution.isSmaller(result, str));
    }
}
