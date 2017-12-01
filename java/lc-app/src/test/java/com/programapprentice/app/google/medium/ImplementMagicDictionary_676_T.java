package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class ImplementMagicDictionary_676_T {
    ImplementMagicDictionary_676 solution = new ImplementMagicDictionary_676();

    @Test
    public void test1() {
        ImplementMagicDictionary_676.MagicDictionary dictionary = new ImplementMagicDictionary_676.MagicDictionary();
        String[] dicts = {"hello", "leetcode"};
        dictionary.buildDict(dicts);
        Assert.assertFalse(dictionary.search("hello"));
        Assert.assertTrue(dictionary.search("hhllo"));
        Assert.assertFalse(dictionary.search("hell"));
        Assert.assertFalse(dictionary.search("leetcoded"));
    }

    @Test
    public void test2() {
        ImplementMagicDictionary_676.MagicDictionary dictionary = new ImplementMagicDictionary_676.MagicDictionary();
        String[] dicts = {"hello", "leetcode", "hallo"};
        dictionary.buildDict(dicts);
        Assert.assertTrue(dictionary.search("hello"));
        Assert.assertTrue(dictionary.search("hhllo"));
        Assert.assertFalse(dictionary.search("hell"));
        Assert.assertTrue(dictionary.search("leetcodd"));
    }

    @Test
    public void test3() {
        ImplementMagicDictionary_676.MagicDictionary dictionary = new ImplementMagicDictionary_676.MagicDictionary();
        String[] dicts = {"hello", "leetcode", "hallo", "judge", "judgg"};
        dictionary.buildDict(dicts);
        Assert.assertTrue(dictionary.search("hello"));
        Assert.assertTrue(dictionary.search("hhllo"));
        Assert.assertFalse(dictionary.search("hell"));
        Assert.assertTrue(dictionary.search("leetcodd"));
        Assert.assertTrue(dictionary.search("judge"));
        Assert.assertTrue(dictionary.search("judgg"));
    }

}
