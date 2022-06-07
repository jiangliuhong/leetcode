package com.jarome.leetcode.hw;

/**
 * 862.和可被 k 整除的子数组
 */
public class ShortestSubarray {
    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE;
        int start = 0;
        int[] summax = new int[nums.length + 1];
        summax[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            int sum = summax[i - 1] + nums[i - 1];
            if (sum < nums[i - 1]) {
                start = i;
                summax[i] = nums[i - 1];
            } else {
                summax[i] = sum;
            }
            if (summax[i] >= k) {
                len = Math.min(len, i - start + 1);
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }

    public static void main(String[] args) {
        ShortestSubarray s = new ShortestSubarray();
        System.out.println(s.shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89));
    }
}
