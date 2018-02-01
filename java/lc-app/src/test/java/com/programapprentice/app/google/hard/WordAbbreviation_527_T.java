package com.programapprentice.app.google.hard;

import com.programapprentice.app.util.TestUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordAbbreviation_527_T {
    WordAbbreviation_527 solution = new WordAbbreviation_527();

    @Test
    public void test1() {
        String word = "internal";
        String abbrev = solution.getAbbreviation(word, 7);
        System.out.println(abbrev);
    }

    @Test
    public void test2() {
        String[] words = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
        List<String> dict = Arrays.asList(words);
        List<String> result = solution.wordsAbbreviation(dict);
        TestUtil.printArray(result);
    }
}
