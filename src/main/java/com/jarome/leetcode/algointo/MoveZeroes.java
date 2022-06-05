package com.jarome.leetcode.algointo;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        int zeroSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroSize++;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = zeroSize; i > 0; i--) {
            nums[nums.length - i] = 0;
        }
    }
}
