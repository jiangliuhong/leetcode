package com.jarome.leetcode.test2;

// 买卖股票的最佳时机 II
public class SolutionMaxProfit {
    public int maxProfit(int[] prices) {
        int sum = 0;
        // 股价最低
        int min = prices[0];
        // 股价最高
        int max = -1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                if (max == -1) {
                    min = prices[i];
                } else if (max > prices[i]) {
                    sum = sum + max - min;
                    min = prices[i];
                    max = -1;
                }
            } else if (prices[i] > min) {
                if (max == -1) {
                    max = prices[i];
                } else if (max > prices[i]) {
                    sum = sum + max - min;
                    min = prices[i];
                    max = -1;
                }
            }
        }
        if (max != -1) {
            sum = sum + prices[prices.length - 1] - min;
        }
        return sum;
    }

    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices = {1,2,3,4,5};
        int[] prices = {2, 4, 1};
        SolutionMaxProfit smp = new SolutionMaxProfit();
        int i = smp.maxProfit(prices);
        System.out.println(i);
    }
}
