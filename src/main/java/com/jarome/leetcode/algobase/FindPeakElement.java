package com.jarome.leetcode.algobase;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];
            if ((mid == 0 || val > nums[mid - 1]) && (mid == nums.length - 1 || val > nums[mid + 1])) {
                index = mid;
                break;
            } else if (!(mid == 0 || val > nums[mid - 1])) {
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4}));
        System.out.println(f.findPeakElement(new int[] {1, 2, 3, 1}));
        System.out.println(f.findPeakElement(new int[] {1, 2}));
        System.out.println(f.findPeakElement(new int[] {2, 1}));
        System.out.println(f.findPeakElement(new int[] {2}));
        System.out.println(f.findPeakElement(new int[] {-2147483648,-2147483647}));
    }
}
