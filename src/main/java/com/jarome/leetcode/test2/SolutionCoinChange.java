package com.jarome.leetcode.test2;

import java.util.HashMap;
import java.util.Map;

public class SolutionCoinChange {

    public int coinChange(int[] coins, int amount) {
        return ccRec(coins,amount,new HashMap<>());
    }

    //递归求解，超出时间限制
    private int ccRec(int[] coins, int amount, Map<Integer,Integer> temp){
        if(amount == 0){
            return 0;
        }else if(amount < 0){
            return -1;
        }
        // 备忘录
        Integer amountVal = temp.get(amount);
        if(amountVal != null) {
            return amountVal;
        }
        Integer res = null;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            // 递归求值
            int ccRes = ccRec(coins,  amount - coin,temp);
            if (ccRes == -1) {
                continue;
            }
            if(res == null){
                res = 1 + ccRes;
            }else {
                res = Math.min(res, 1 + ccRes);
            }
        }
        res =  res ==null ? -1 : res;
        temp.put(amount,res);
        return res;
    }

    public int dp(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            

        }
        return dp[amount];
    }

    public static void main(String[] args) {
        SolutionCoinChange sc = new SolutionCoinChange();
        int[] coins = {1, 2, 5};
//        int[] coins = {2};
        int amount = 11;
//        int amount = 3;
        int res = sc.coinChange(coins, amount);
        System.out.println(res);
    }

}
