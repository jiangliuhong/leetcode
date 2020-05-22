package com.jarome.leetcode.test2;

public class SolutionLengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // 给数组每一位，设置一个默认值1，既，默认认为他是最大的数，最长子序列为1
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 从dp中取出最大值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        SolutionLengthOfLIS lis = new SolutionLengthOfLIS();
        int i = lis.lengthOfLIS(nums);
        System.out.println(i);
    }
}
