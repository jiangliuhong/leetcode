package com.jarome.leetcode.algobase;

public class FindMin {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int endVal = nums[nums.length - 1];
        int index = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int left = mid > 0 ? mid - 1 : nums.length - 1;
            int right = mid < nums.length - 1 ? mid + 1 : 0;
            if (nums[mid] <= nums[left] && nums[mid] <= nums[right]) {
                index = mid;
                break;
            }
            if (nums[mid] > endVal) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[index];
    }

    public static void main(String[] args) {
        FindMin f = new FindMin();
        System.out.println(f.findMin(new int[] {3, 4, 5, 1, 2}));
        System.out.println(f.findMin(new int[] {3, 4}));
        System.out.println(f.findMin(new int[] {3, 4, 5}));
        System.out.println(f.findMin(new int[] {3}));
    }
}
