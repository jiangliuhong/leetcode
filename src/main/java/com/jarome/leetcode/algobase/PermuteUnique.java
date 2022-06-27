package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, list, new ArrayList<>(), new HashSet<>());
        return list;
    }

    private void backtrack(int[] nums, List<List<Integer>> list, List<Integer> subList, Set<Integer> filters) {
        for (int i = 0; i < nums.length; i++) {
            if (filters.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !filters.contains(i - 1)) {
                continue;
            }
            subList.add(nums[i]);
            if (filters.size() == nums.length - 1) {
                list.add(new ArrayList<>(subList));
                subList.remove(subList.size() - 1);
                return;
            }
            filters.add(i);
            backtrack(nums, list, subList, filters);
            filters.remove(i);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermuteUnique p = new PermuteUnique();
        System.out.println(p.permuteUnique(new int[] {1, 1, 1}));
        System.out.println(p.permuteUnique(new int[] {1, 1, 2}));
        System.out.println(p.permuteUnique(new int[] {1, 1, 1, 2}));
    }

}
