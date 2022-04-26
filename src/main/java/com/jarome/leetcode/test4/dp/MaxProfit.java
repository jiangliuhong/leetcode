package com.jarome.leetcode.test4.dp;

/**
 * 买卖股票
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int income = 0;
        if (prices == null || prices.length <= 0) {
            return income;
        }
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            income = Math.min(income, prices[i] - buy);

        }
        return income;
    }
}
