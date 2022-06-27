package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = dfs(nums, 0);
        res.add(0, new ArrayList<>());
        return res;
    }

    private List<List<Integer>> dfs(int[] nums, int index) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(nums[index]);
        list.add(l);
        if (index == nums.length - 1) {
            return list;
        }
        List<List<Integer>> subList = dfs(nums, index + 1);
        for (List<Integer> integers : subList) {
            List<Integer> nl = new ArrayList<>();
            nl.add(nums[index]);
            nl.addAll(integers);
            list.add(nl);
        }
        list.addAll(subList);
        return list;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = dfsDup(nums, 0);
        lists.add(0, new ArrayList<>());
        return lists;
    }

    private List<List<Integer>> dfsDup(int[] nums, int index) {
        List<List<Integer>> list = new ArrayList<>();

        if (index == nums.length - 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[index]);
            list.add(l);
            return list;
        }
        int d = 0;
        for (int i = index; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                break;
            }
            d++;
        }
        if (d == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[index]);
            list.add(l);
        }
        List<List<Integer>> subList = dfsDup(nums, index + 1);
        for (List<Integer> integers : subList) {
            if ((d > 0 && integers.size() >= d && integers.get(d - 1) == nums[index]) || d == 0) {
                List<Integer> nl = new ArrayList<>();
                nl.add(0, nums[index]);
                nl.addAll(integers);
                list.add(nl);
            }
        }
        list.addAll(subList);
        return list;
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsetsWithDup(new int[] {1, 2, 2}));
        System.out.println(s.subsetsWithDup(new int[] {1, 1, 2, 2}));
        System.out.println(s.subsetsWithDup(new int[] {5, 5, 5, 5, 5}));
    }
}
