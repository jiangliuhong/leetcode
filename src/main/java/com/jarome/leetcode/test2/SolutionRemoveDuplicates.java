package com.jarome.leetcode.test2;

// 删除排序数组中的重复项
public class SolutionRemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int newSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (newSize == 0) {
                newSize++;
                continue;
            }
            if (nums[newSize - 1] == nums[i]) {
                continue;
            }
            newSize++;
            nums[newSize - 1] = nums[i];
        }
        return newSize;
    }

    public static void main(String[] args) {
        SolutionRemoveDuplicates srd = new SolutionRemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = srd.removeDuplicates(nums);
        String line = "";
        for (int i = 0; i < len; i++) {
            line = line + nums[i] + "  ";
        }
        System.out.println(line);
    }
}
