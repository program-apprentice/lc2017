package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class SentenceScreenFitting_418_T {
    SentenceScreenFitting_418 solution = new SentenceScreenFitting_418();

    @Test
    public void test1() {
        String[] sentence = {"try","to","be","better"};
        int actual = solution.wordsTyping(sentence, 10000, 9001);
        Assert.assertEquals(actual, 5293333);
        System.out.println(actual);
    }

}
