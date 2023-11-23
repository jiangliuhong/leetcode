package com.jarome.leetcode.algobase;

public class DpRob {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        int max = Math.max(dp[nums.length - 2][0], dp[nums.length - 2][1]);
        dp = new int[nums.length][2];
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        max = Math.max(max, Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]));
        return max;
    }

    public static void main(String[] args) {
        DpRob d = new DpRob();
        System.out.println(d.rob(new int[] {2, 2, 3}));
        System.out.println(d.rob(new int[] {1, 2, 3}));
        System.out.println(d.rob(new int[] {1, 2, 3, 1}));
        System.out.println(d.rob(new int[] {1}));
        System.out.println(d.rob(new int[] {1, 2}));
    }
}
