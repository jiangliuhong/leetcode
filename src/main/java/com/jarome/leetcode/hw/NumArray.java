package com.jarome.leetcode.hw;

/**
 * 区域和检索 - 数组不可变
 */
public class NumArray {
    private final int[] sums;

    public NumArray(int[] nums) {
        this.sums = new int[nums.length];
        this.sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.sums[i] =  this.sums[i-1]+ nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.sums[right];
        }
        return this.sums[right] - this.sums[left - 1];
    }
}
