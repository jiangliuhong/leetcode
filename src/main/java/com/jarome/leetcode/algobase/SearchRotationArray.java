package com.jarome.leetcode.algobase;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchRotationArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        int first = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = nums[mid];
            if (val == target) {
                index = mid;
                break;
            }
            if (target > first) {
                if (val < target) {
                    if (first <= val) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    end = mid - 1;
                }
            } else if (target == first) {
                index = 0;
                break;
            } else {
                if (val > target) {
                    if (val < first) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    start = mid + 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        SearchRotationArray s = new SearchRotationArray();
//        System.out.println(s.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(s.search(new int[] {3,1}, 1));
    }

}
