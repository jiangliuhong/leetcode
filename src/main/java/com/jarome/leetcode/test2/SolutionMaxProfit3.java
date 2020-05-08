package com.jarome.leetcode.test2;

// 买卖股票的最佳时机 III
public class SolutionMaxProfit3 {
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
        int[] prices = {3,3,5,0,0,3,1,4};
        SolutionMaxProfit3 smp = new SolutionMaxProfit3();
        int i = smp.maxProfit(prices);
        System.out.println(i);
    }
}
