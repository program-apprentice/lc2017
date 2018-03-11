package com.programapprentice.app.google.hard;

import org.junit.Test;

import java.util.List;

public class WordSquares_425_T {
    WordSquares_425 solution = new WordSquares_425();

    @Test
    public void test1() {
        String[] words = {"area","lead","wall","lady","ball"};
        List<List<String>> result = solution.wordSquares(words);
    }

}
