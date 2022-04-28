package com.jarome.leetcode.test4.dp;

/**
 * CountBits <br/>
 * 比特位计数
 * 
 * @author jiangliuhong
 * @date 2022/4/28 10:37 PM
 * @version 1.0.0
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            dp[i] = dp[i - high] + 1;
        }
        return dp;
    }

}
