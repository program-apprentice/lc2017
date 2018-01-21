package com.programapprentice.app.google.medium;

public class BestTimeToBuyAndSellStockWithCooldown_309 {
    /**
     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
     Say you have an array for which the ith element is the price of a given stock on day i.

     Design an algorithm to find the maximum profit. You may complete as many transactions
     as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

     You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     Example:

     prices = [1, 2, 3, 0, 2]
     maxProfit = 3
     transactions = [buy, sell, cooldown, buy, sell]
     * */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] opts = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                opts[i] = Math.max( opts[Math.max(0, j-2)] + prices[i] - prices[j], max);
                max = Math.max(opts[i], max);
            }
        }
        return opts[n-1];
    }

}
