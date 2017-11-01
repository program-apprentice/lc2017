package com.programapprentice.app.facebook.easy;

public class BestTimeToBuyAndSellStock121 {
    /**
     [121] Best Time to Buy and Sell Stock

     https://leetcode.com/problems/best-time-to-buy-and-sell-stock

     Say you have an array for which the ith element is the price of a given stock on day i.

     If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

     Example 1:

     Input: [7, 1, 5, 3, 6, 4]
     Output: 5

     max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

     Example 2:

     Input: [7, 6, 4, 3, 1]
     Output: 0

     In this case, no transaction is done, i.e. max profit = 0.
    * */

    public int findBottom(int[] prices) {
        if(prices[1] > prices[0]) {
            return 0;
        }
        for(int i = 0; i < prices.length-2; i++) {
            if(prices[i+1] < prices[i]) {
                return i+1;
            }
        }
        return -1;
    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int startIdx = findBottom(prices);
        if(startIdx == -1) {
            return Math.max(0, prices[prices.length-1] - prices[0]);
        }
        int max = 0;
        for(int i = startIdx; i < prices.length-1; i++) {
            max = Math.max(max, prices[i] - prices[startIdx]);
            if(prices[i+1] < prices[i]) {
                if(prices[i+1] < prices[startIdx]) {
                    startIdx = i+1;
                }
            }
        }
        max = Math.max(max, prices[prices.length-1] - prices[startIdx]);
        return max;
    }

}
