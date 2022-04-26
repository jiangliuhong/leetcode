package com.jarome.leetcode.test4.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {

             max = Math.max(max, prices[i] - prices[i-1]);

        }
        return max;
    }
}
