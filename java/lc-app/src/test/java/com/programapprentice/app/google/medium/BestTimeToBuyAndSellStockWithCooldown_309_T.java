package com.programapprentice.app.google.medium;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStockWithCooldown_309_T {
    BestTimeToBuyAndSellStockWithCooldown_309 solution = new BestTimeToBuyAndSellStockWithCooldown_309();

    @Test
    public void test1() {
        int[] prices = {1, 2, 3, 1, 2, 1, 3, 4};
        int actual = solution.maxProfit(prices);
        Assert.assertEquals(actual, 5);
    }
}
