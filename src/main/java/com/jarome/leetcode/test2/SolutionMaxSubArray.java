package com.jarome.leetcode.test2;

public class SolutionMaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        // 给第一个数一个默认值
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1};
        SolutionMaxSubArray sms = new SolutionMaxSubArray();
        int i = sms.maxSubArray(nums);
        System.out.println(i);
    }
}
