package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        Set<Integer> select = new HashSet<>();
        backtrack(candidates, target, list, temp, select, 0);
        return list;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> list, List<Integer> temp,
        Set<Integer> select, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !select.contains(i - 1)) {
                continue;
            }
            select.add(i);
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], list, temp, select, i + 1);
            temp.remove(temp.size() - 1);
            select.remove(i);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        System.out.println(c.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(c.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5));
        System.out.println(c.combinationSum2(new int[] {5}, 5));
        System.out.println(c.combinationSum2(new int[] {5}, 4));
    }

}
