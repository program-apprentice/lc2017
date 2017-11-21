package com.programapprentice.app.facebook.hard;

import org.junit.Test;

import java.util.List;

public class TextJustification_068_T {
    TextJustification_068 solution = new TextJustification_068();

    @Test
    public void test1() {
        String[] words = {"a","b","c","d","e"};
        int maxWidth = 1;
        List<String> result = solution.fullJustify(words, maxWidth);
    }

    @Test
    public void test2() {
        String[] words = {"a","b","c","d","e"};
        int maxWidth = 3;
        List<String> result = solution.fullJustify(words, maxWidth);
    }

    @Test
    public void test3() {
        String[] words = {"What","must","be","shall","be."};
        int maxWidth = 12;
        List<String> result = solution.fullJustify(words, maxWidth);
    }
}
