package com.jarome.leetcode.hw;

/**
 * 862.和可被 k 整除的子数组
 */
public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k) {
        int len = Integer.MAX_VALUE;
        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];

        }
        return len;
    }

    // 超时
    public int shortestSubarray2(int[] nums, int k) {
        int len = Integer.MAX_VALUE;
        int start = 0;
        int[] summax = new int[nums.length + 1];
        summax[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            int sum = summax[i - 1] + nums[i - 1];
            if (sum < nums[i - 1]) {
                summax[i] = nums[i - 1];
            } else {
                summax[i] = sum;
            }
            if (summax[i] >= k) {

                for (int j = i - 1; j >= start; j--) {
                    if (summax[i] - summax[j] >= k) {
                        len = Math.min(len, i - j);
                        start = j;
                        break;
                    }
                }

            }

        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }

    public static void main(String[] args) {
        ShortestSubarray s = new ShortestSubarray();
        System.out.println(s.shortestSubarray(new int[] {1}, 1));
        System.out.println(s.shortestSubarray(new int[] {17, 85, 93, -45, -21}, 150));
        System.out.println(s.shortestSubarray(new int[] {-28, 81, -20, -1, 29, -29}, 89));
    }
}