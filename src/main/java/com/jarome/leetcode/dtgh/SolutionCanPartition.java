package com.jarome.leetcode.dtgh;

public class SolutionCanPartition {
    public boolean canPartition(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            size = size + nums[i];
        }
        // 非偶数直接返回false
        if (size % 2 != 0) {
            return false;
        }
        int sum = size / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        // 设置和为0时的默认值
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        SolutionCanPartition scp = new SolutionCanPartition();
        //int[] nums = {1, 5, 11, 5};
        int[] nums = {1, 2, 3, 5,4,5};
        boolean b = scp.canPartition(nums);
        System.out.println(b);
    }
}
