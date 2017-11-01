package com.programapprentice.app.facebook.medium;

import org.junit.Assert;
import org.junit.Test;

public class AddAndSearchWordDataStructureDesign_211_T {
    AddAndSearchWordDataStructureDesign_211 solution = new AddAndSearchWordDataStructureDesign_211();

    @Test
    public void test1() {
        AddAndSearchWordDataStructureDesign_211.WordDictionary dict = new AddAndSearchWordDataStructureDesign_211.WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        Assert.assertFalse(dict.search("pad"));
        Assert.assertTrue(dict.search("mad"));
        Assert.assertTrue(dict.search(".ad"));
        Assert.assertTrue(dict.search("b.."));
    }
}
