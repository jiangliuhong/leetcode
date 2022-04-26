package com.jarome.leetcode.test4.dp;

/**
 * 打家劫舍
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + val;
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
