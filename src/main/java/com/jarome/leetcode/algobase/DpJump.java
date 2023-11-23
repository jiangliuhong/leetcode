package com.jarome.leetcode.algobase;

import java.util.Arrays;

public class DpJump {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int stepMax = 0;
        for (int i = 0; i < nums.length; i++) {
            stepMax = Math.max(stepMax, i + nums[i]);
            if (i == end) {
                step++;
                end = stepMax;
            }
        }
        return step;
    }

    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int target = Math.min(j + i, nums.length - 1);
                dp[target] = Math.min(dp[i] + 1, dp[target]);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        DpJump d = new DpJump();
        System.out.println(d.jump(new int[] {1}));
        System.out.println(d.jump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(d.jump(new int[] {4, 1, 1, 3, 1, 1, 1}));
    }
}
