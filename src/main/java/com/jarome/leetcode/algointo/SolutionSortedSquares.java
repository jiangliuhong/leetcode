package com.jarome.leetcode.algointo;

/**
 * 有序数组的平方
 */
public class SolutionSortedSquares {

    public int[] sortedSquares(int[] nums) {
        int max = Math.abs(nums[0]);
        int min = max;
        for (int i = 1; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            bucket[n] += 1;
        }
        int[] res = new int[nums.length];
        int resIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                res[resIndex] = i * i;
                resIndex++;
            }
        }
        return res;
    }
}
