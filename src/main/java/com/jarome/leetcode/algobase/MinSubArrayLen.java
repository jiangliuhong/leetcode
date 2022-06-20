package com.jarome.leetcode.algobase;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (target == 1) {
            return 1;
        }
        int len = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                len = Math.min(len, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
