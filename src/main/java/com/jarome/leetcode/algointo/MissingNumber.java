package com.jarome.leetcode.algointo;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i] ^ i;
        }
        sum = sum ^ nums.length;
        return sum;
    }
}
