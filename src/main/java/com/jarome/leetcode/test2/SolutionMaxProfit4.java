package com.jarome.leetcode.test2;

// 买卖股票的最佳时机 III
public class SolutionMaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int size = prices.length;
        if (k > size / 2) {
            // 解决超出内存大小的错误
            // 如果传入的值大于的数组长度的一般，可以忽略k的限制，直接使用贪心算法
            int sum = 0;
            for (int i = 1; i < size; i++) {
                int sub = prices[i] - prices[i - 1];
                if (sub > 0) {
                    sum += sub;
                }
            }
            return sum;
        }
        int[][][] dp = new int[size][2][k + 1];
        // 初始化第一天持股的情况，方便下方从第二天开始循环
        for (int i = 0; i < k; i++) {
            dp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < size; i++) {
            int price = prices[i];
            // 卖股票的次数为k ，循环进行
            for (int j = 0; j <= k; j++) {
                // 分两种情况，今天持股，今天不持股
                // 今天持股，可能今天买入，可能昨天买入
                if (j < k) {
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - price);
                }
                // 今天不持股，可能今天卖出，可能昨天卖出
                if (j >= 1) {
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + price);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= k; i++) {
            max = Math.max(max, dp[size - 1][0][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = {2, 4, 1};
        int k = 2;
        SolutionMaxProfit4 smp = new SolutionMaxProfit4();
        int i = smp.maxProfit(k, prices);
        System.out.println(i);
    }
}
