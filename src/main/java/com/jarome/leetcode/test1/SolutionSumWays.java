package com.jarome.leetcode.test1;

public class SolutionSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        return count(nums, S, 0, 0);
    }

    private int count(int[] nums, int S, int base, int index) {
        if (index == nums.length) {
            if (base == S) {
                return 1;
            }
            return 0;
        }
        // 两种处理，一个加 一个减
        int newIndex = index + 1;
        int count = 0;
        count = count + count(nums, S, base - nums[index], newIndex);
        count = count + count(nums, S, base + nums[index], newIndex);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        SolutionSumWays s = new SolutionSumWays();
        int targetSumWays = s.findTargetSumWays(nums, 3);
        System.out.println(targetSumWays);
    }
}
