package com.jarome.leetcode.test4.os;

/**
 * 合并两个有序数组
 */
public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        m--;
        n--;
        while (end >= 0) {
            if (m < 0 && n >= 0) {
                nums1[end] = nums2[n];
                n--;
            } else if (n < 0 && m >= 0) {
                nums1[end] = nums1[m];
                m--;
            } else {
                if (nums1[m] > nums2[n]) {
                    nums1[end] = nums1[m];
                    m--;
                } else {
                    nums1[end] = nums2[n];
                    n--;
                }
            }
            end--;
        }
    }
}
