package com.jarome.leetcode.test2;

// 买卖股票的最佳时机 III
public class SolutionMaxProfit3 {
    public int maxProfit(int[] prices) {
        // 针对空数组进行处理
        if(prices.length == 0){
            return 0;
        }
        // 天数、是否持有股票、卖出次数(0、1、2)
        int[][][] dp = new int[prices.length][2][3];
        // 初始化第一天的情况
        // 第一天持有股票，卖出一次
        dp[0][1][0] = -prices[0];
        // 第一天持有股票，卖出一次，这里主要是对下面第二步计算时进行容错
        dp[0][1][1] = -prices[0];
        // 第一天啥也不干;因为第一天不可能卖出股票;由于数组默认为0，所以就两种不设置初始值，默认为0即可
        // 从第二天开始计算
        for (int i = 1; i < prices.length; i++) {
            // 今天的股价
            int price = prices[i];
            // 今天不持有股票不卖股票,使用数组默认值0，不做操作
            // 1.今天未持有股票，并卖出去一次，有可能今天卖出，有可能昨天卖出，比较两次的值，取最大值
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + price);
            // 2.今天未持有股票，并卖出去两次，有可能今天卖出，有可能昨天卖出，比较两次的值，取最大值
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + price);
            // 3.今天持有股票，未卖出过股票，可能是今天买入的，也可能是昨天买入的
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - price);
            // 4.今天持有股票，卖出过一次股票，可能是今天买入的，也可能是昨天买入的
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - price);
            // 今天持有股票，卖出过两次股票，按照题意这是不可能，顾不做扩展
        }
        int max = Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]);
        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = {7,6,4,3,1};
        SolutionMaxProfit3 smp = new SolutionMaxProfit3();
        int i = smp.maxProfit(prices);
        System.out.println(i);
    }
}
