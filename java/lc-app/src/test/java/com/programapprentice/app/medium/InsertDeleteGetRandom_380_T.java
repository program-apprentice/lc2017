package com.programapprentice.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class InsertDeleteGetRandom_380_T {
    InsertDeleteGetRadom_380 solution = new InsertDeleteGetRadom_380();

    @Test
    public void test1() {
        InsertDeleteGetRadom_380.RandomizedSet set = new InsertDeleteGetRadom_380.RandomizedSet();
        Assert.assertTrue(set.insert(1));
        Assert.assertFalse(set.remove(2));
        Assert.assertTrue(set.insert(2));
        System.out.println(set.getRandom());
        Assert.assertTrue(set.remove(1));
        Assert.assertFalse(set.insert(2));
    }

    @Test
    public void tes2() {
        InsertDeleteGetRadom_380.RandomizedSet set = new InsertDeleteGetRadom_380.RandomizedSet();
        Assert.assertTrue(set.insert(1));
        Assert.assertTrue(set.insert(2));
        Assert.assertFalse(set.insert(2));
        Assert.assertTrue(set.insert(3));
        System.out.println(set.getRandom());
        Assert.assertTrue(set.remove(3));
        Assert.assertTrue(set.insert(1));
        Assert.assertFalse(set.remove(3));
    }


}
