package com.jarome.leetcode.algointo;

/**
 * 二分查找 https://leetcode-cn.com/problems/binary-search/
 */
public class SolutionSearch {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int min = 0, max = nums.length - 1;
        while (min < max) {
            if (max - min == 1) {
                if (nums[max] == target) {
                    return max;
                } else if (nums[min] == target) {
                    return min;
                } else {
                    return -1;
                }
            }
            int seq = (max + min) / 2;
            int val = nums[seq];
            if (target < val) {
                max = seq;
            } else if (target > val) {
                min = seq;
            } else {
                return seq;
            }

        }
        return -1;
    }
}
