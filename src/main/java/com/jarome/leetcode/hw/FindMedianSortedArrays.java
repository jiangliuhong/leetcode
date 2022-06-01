package com.jarome.leetcode.hw;

/**
 * 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int index = 0, i1 = 0, i2 = 0; index < nums.length; index++) {
            if (i1 < nums1.length && i2 < nums2.length) {
                if (nums1[i1] > nums2[i2]) {
                    nums[index] = nums2[i2];
                    i2++;
                } else {
                    nums[index] = nums1[i1];
                    i1++;
                }
            } else if (i1 < nums1.length) {
                nums[index] = nums1[i1];
                i1++;
            } else if (i2 < nums2.length) {
                nums[index] = nums2[i2];
                i2++;
            }
        }
        if (nums.length % 2 == 0) {
            return (double) (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }
}
