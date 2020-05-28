package com.jarome.leetcode.test2;

import java.util.ArrayList;
import java.util.List;

public class SolutionIntersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 先对两个数组进行排序
        orderAsc(nums1);
        orderAsc(nums2);
        int i1 = 0;
        int i2 = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (i1 >= nums1.length || i2 >= nums2.length) {
                break;
            }
            int num1 = nums1[i1];
            int num2 = nums2[i2];
            if (num1 == num2) {
                list.add(num1);
                i1++;
                i2++;
            } else if (num1 > num2) {
                i2++;
            } else {
                i1++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void orderAsc(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionIntersect si = new SolutionIntersect();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = si.intersect(nums1, nums2);
        String str = "";
        for (int i = 0; i < intersect.length; i++) {
            str = str + intersect[i] + " ";
        }
        System.out.println(str);
    }
}
