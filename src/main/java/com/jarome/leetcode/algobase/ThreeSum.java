package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (second < third && nums[first] + nums[second] + nums[third] != 0) {
                    third--;
                }
                if (second == third) {
                    continue;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    list.add(l);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
//        t.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        t.threeSum(new int[] {1,-1,-1,0});
    }
}
