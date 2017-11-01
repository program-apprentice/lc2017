package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_139_T {
    WordBreak_139 solution = new WordBreak_139();

    @Test
    public void test1() {
        String str = "leetcode";
        List<String> wordList = new ArrayList<String>();
        wordList.add("leet");
        wordList.add("code");
        boolean result = solution.wordBreak(str, wordList);
        Assert.assertTrue(result);
    }
}
