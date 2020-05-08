package com.jarome.leetcode.test2;

// 买卖股票的最佳时机 II
public class SolutionMaxProfit2 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int lastVal = prices[i - 1];
            int val = prices[i];
            int sub = val - lastVal;
            if (sub > 0) {
                sum += sub;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices = {1,2,3,4,5};
        // int[] prices = {2, 4, 1};
        int[] prices = {2, 1, 4, 5, 2, 9, 7};
        SolutionMaxProfit2 smp = new SolutionMaxProfit2();
        int i = smp.maxProfit(prices);
        System.out.println(i);
    }
}
