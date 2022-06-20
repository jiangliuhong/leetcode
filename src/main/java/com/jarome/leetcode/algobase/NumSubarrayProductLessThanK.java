package com.jarome.leetcode.algobase;

public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int multi = 1;
        int start = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            multi *= nums[i];
            while (multi >= k && start <= i) {
                multi /= nums[start];
                start++;
            }
            n += i - start + 1;
        }
        return n;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK n = new NumSubarrayProductLessThanK();
        System.out.println(n.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
        System.out.println(n.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 0));
        System.out.println(n.numSubarrayProductLessThanK(new int[] {1, 1, 1}, 2));
        System.out.println(n.numSubarrayProductLessThanK(new int[] {1, 1, 1}, 1));
        System.out.println(n.numSubarrayProductLessThanK(new int[] {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
        System.out.println(n.numSubarrayProductLessThanK(new int[] {10, 2, 2, 5, 4, 4, 4, 3, 7, 7}, 289));
    }
}
