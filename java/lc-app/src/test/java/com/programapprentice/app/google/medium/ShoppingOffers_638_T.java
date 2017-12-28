package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers_638_T {
    ShoppingOffers_638 solution = new ShoppingOffers_638();

    /**
     [2,5]
     [[3,0,5],[1,2,10]]
     [3,2]
     * */

    @Test
    public void test1() {
        List<Integer> prices = new ArrayList<Integer>();
        prices.add(2);
        prices.add(5);
        List<List<Integer>> special = new ArrayList<List<Integer>>();
        List<Integer> offer = new ArrayList<Integer>();
        offer.add(3);
        offer.add(0);
        offer.add(5);
        special.add(offer);
        offer = new ArrayList<Integer>();
        offer.add(1);
        offer.add(2);
        offer.add(10);
        special.add(offer);
        List<Integer> needs = new ArrayList<Integer>();
        needs.add(3);
        needs.add(2);
        int actual = solution.shoppingOffers(prices, special, needs);
        Assert.assertEquals(14, actual);
    }
}
