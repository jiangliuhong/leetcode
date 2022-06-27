package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private List<Integer> tempList = new ArrayList<>();
    private List<List<Integer>> list = new ArrayList<>();
    private Integer tempSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return list;
    }

    private void backtrack(int[] candidates, int target, Integer index) {
        for (int i = index; i < candidates.length; i++) {
            tempSum += candidates[i];
            tempList.add(candidates[i]);
            if (tempSum == target) {
                list.add(new ArrayList<>(tempList));
                tempSum -= candidates[i];
                tempList.remove(tempList.size() - 1);
            } else if (tempSum < target) {
                backtrack(candidates, target, i);
                tempSum -= candidates[i];
                tempList.remove(tempList.size() - 1);
            } else {
                tempSum -= candidates[i];
                tempList.remove(tempList.size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        // System.out.println(c.combinationSum(new int[] {2, 3, 6, 7}, 7));
        System.out.println(c.combinationSum(new int[] {2}, 2));
        // System.out.println(c.combinationSum(new int[] {2,3,5}, 8));
    }
}
