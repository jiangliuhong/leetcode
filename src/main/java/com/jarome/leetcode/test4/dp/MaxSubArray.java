package com.jarome.leetcode.test4.dp;

/**
 * MaxSubArray <br/>
 * 最大子序和
 * 
 * @author jiangliuhong
 * @date 2022/4/26 10:15 PM
 * @version 1.0.0
 *
 * TODO https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
