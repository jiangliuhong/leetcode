package com.jarome.leetcode.algobase;

public class DpCanJump {
    public boolean canJump(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= step) {
                step = Math.max(step, nums[i] + i);
                if (step >= nums.length - 1) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        DpCanJump d = new DpCanJump();
         System.out.println(d.canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(d.canJump(new int[] {3, 2, 1, 0, 4}));
    }
}
