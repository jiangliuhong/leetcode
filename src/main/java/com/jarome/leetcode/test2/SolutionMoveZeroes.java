package com.jarome.leetcode.test2;

public class SolutionMoveZeroes {
    public void moveZeroes(int[] nums) {
        // 0 的数量
        int zeroNums = 0;
        // 当前最大非0数坐标
        int notZero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNums++;
            } else {
                nums[notZero + 1] = nums[i];
                notZero++;
            }
        }
        for (int i = 1; i <= zeroNums; i++) {
            nums[nums.length - i] = 0;
        }
    }

    public static void main(String[] args) {
        SolutionMoveZeroes smz = new SolutionMoveZeroes();
        int[] nums = {0, 1, 0, 3,0, 12,2,0};
        smz.moveZeroes(nums);
        String str = "";
        for (int i = 0; i < nums.length; i++) {
            str = str + nums[i] + " ";
        }
        System.out.println(str);
    }
}
