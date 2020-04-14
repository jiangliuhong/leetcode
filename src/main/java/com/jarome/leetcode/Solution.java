package com.jarome.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // public int[] twoSum(int[] nums, int target) {
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = 0; j < nums.length; j++) {
    // if (i == j) {
    // continue;
    // }
    // if (nums[i] + nums[j] == target) {
    // return new int[] {i, j};
    // }
    // }
    // }
    // return null;
    // }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                return new int[] {map.get(res), i};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] ints = solution.twoSum(nums, target);
        System.out.println(ints[0] + "," + ints[1]);
    }
}
