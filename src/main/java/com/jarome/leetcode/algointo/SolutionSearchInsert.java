package com.jarome.leetcode.algointo;

/**
 * 搜索插入位置
 */
public class SolutionSearchInsert {

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int indexOf = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                index = i + 1;
            }
            if (nums[i] == target) {
                indexOf = i;
            }
        }
        return indexOf != -1 ? indexOf : index;
    }
}
