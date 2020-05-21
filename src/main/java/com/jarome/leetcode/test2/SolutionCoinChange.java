package com.jarome.leetcode.test2;

import java.util.HashMap;
import java.util.Map;

public class SolutionCoinChange {

    public int coinChange(int[] coins, int amount) {
        // return ccRec(coins, amount, new HashMap<>());
        return dp(coins, amount);
    }

    // 递归求解，超出时间限制
    private int ccRec(int[] coins, int amount, Map<Integer, Integer> temp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        // 备忘录
        Integer amountVal = temp.get(amount);
        if (amountVal != null) {
            return amountVal;
        }
        Integer res = null;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            // 递归求值
            int ccRes = ccRec(coins, amount - coin, temp);
            if (ccRes == -1) {
                continue;
            }
            if (res == null) {
                res = 1 + ccRes;
            } else {
                res = Math.min(res, 1 + ccRes);
            }
        }
        res = res == null ? -1 : res;
        temp.put(amount, res);
        return res;
    }

    public int dp(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        // 设置第一位为0
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                int sub = i - coin;;
                if (sub < 0 || dp[sub] == -1) {
                    continue;
                }
                if (dp[i] == null) {
                    dp[i] = 1 + dp[sub];
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[sub]);
                }
            }
            // 如过结束循环后，仍然为空，设置为-1，标记为未找到
            if (dp[i] == null) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        SolutionCoinChange sc = new SolutionCoinChange();
        int[] coins = {1, 2, 5};
        // int[] coins = {2};
        int amount = 11;
        // int amount = 3;
        int res = sc.coinChange(coins, amount);
        System.out.println(res);
    }

}
