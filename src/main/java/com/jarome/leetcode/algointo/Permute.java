package com.jarome.leetcode.algointo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, new HashSet<>(), nums.length);
    }

    private List<List<Integer>> dfs(int[] nums, Set<Integer> filters, int size) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (filters.contains(nums[i])) {
                continue;
            }
            if (size > 1) {
                Set<Integer> newFilters = new HashSet<>();
                newFilters.addAll(filters);
                newFilters.add(nums[i]);
                List<List<Integer>> subList = dfs(nums, newFilters, size - 1);
                for (List<Integer> integers : subList) {
                    integers.add(0, nums[i]);
                }
                res.addAll(subList);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
}
