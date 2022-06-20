package com.jarome.leetcode.algobase;

import java.util.Arrays;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target, true);
        int right = search(nums, target, false);
        return new int[] {left, right};
    }

    private int search(int[] nums, int target, boolean little) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((little && nums[mid] < target) || (!little && nums[mid] <= target)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int index = little ? start : end;
        if (index < 0 || index >= nums.length || nums[index] != target) {
            index = -1;
        }
        return index;
    }

    public static void main(String[] args) {
        SearchRange s = new SearchRange();
        // System.out.println(Arrays.toString(s.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)));
        // System.out.println(Arrays.toString(s.searchRange(new int[] {5, 5}, 5)));
        System.out.println(Arrays.toString(s.searchRange(new int[] {1}, 0)));
    }

}
