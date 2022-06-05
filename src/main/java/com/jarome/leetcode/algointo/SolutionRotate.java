package com.jarome.leetcode.algointo;

public class SolutionRotate {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            nums[index] = temp[i];
        }
    }
    public void rotate1(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                int temp2 = nums[j];
                nums[j] = temp;
                temp = temp2;
            }
        }
    }
}
