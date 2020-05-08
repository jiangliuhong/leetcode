package com.jarome.leetcode.test2;

// 买卖股票的最佳时机 I
public class SolutionMaxProfit1 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        if(prices == null || prices.length<=0){
            return sum;
        }
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int val = prices[i];
            min = Math.min(val, min);
            sum = Math.max(val - min, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        SolutionMaxProfit1 smp = new SolutionMaxProfit1();
        int i = smp.maxProfit(prices);
        System.out.println(i);
    }
}
