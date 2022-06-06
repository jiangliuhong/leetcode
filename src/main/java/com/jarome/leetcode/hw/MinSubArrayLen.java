package com.jarome.leetcode.hw;

/**
 * 长度最小的子数组
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int count = 0;
        int start = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            size += nums[i];

            while (size >= target) {
                size = size - nums[start];
                if (count == 0) {
                    count = i - start + 1;
                } else {
                    count = Math.min(count, i - start + 1);
                }
                start++;
            }
        }
        return count;
    }
}
