package com.programapprentice.app.facebook.hard;

import org.junit.Assert;
import org.junit.Test;

public class AlienDictionary_269_T {
    AlienDictionary_269 solution = new AlienDictionary_269();

    @Test
    public void test1() {
        String[] words = {  "wrt", "wrf", "er", "ett", "rftt"};
        String result = solution.alienOrder(words);
        Assert.assertEquals("wertf", result);
    }

    @Test
    public void test2() {
        String[] words = {  "z", "x"};
        String result = solution.alienOrder(words);
        Assert.assertEquals("zx", result);
    }

    @Test
    public void test3() {
        String[] words = {  "z", "x", "z"};
        String result = solution.alienOrder(words);
        Assert.assertEquals("", result);
    }

    @Test
    public void test4() {
        String[] words = {  "z",  "z"};
        String result = solution.alienOrder(words);
        Assert.assertEquals("z", result);
    }


    @Test
    public void test5() {
        String[] words = {  "zy",  "zx"};
        String result = solution.alienOrder(words);
        Assert.assertEquals("yxz", result);
    }

    @Test
    public void test6() {
        String[] words = {  "ab",  "adc"};
        String result = solution.alienOrder(words);
        Assert.assertEquals("yxz", result);
    }
}
