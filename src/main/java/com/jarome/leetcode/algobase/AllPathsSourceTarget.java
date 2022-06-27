package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph, 0);
    }

    private List<List<Integer>> dfs(int[][] graph, int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (graph[n].length == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(n);
            list.add(l);
            return list;
        }
        for (int i = 0; i < graph[n].length; i++) {
            int target = graph[n][i];
            List<List<Integer>> targetList = dfs(graph, target);
            for (List<Integer> integers : targetList) {
                integers.add(0, n);
            }
            list.addAll(targetList);
        }
        return list;
    }

    public static void main(String[] args) {
        AllPathsSourceTarget a = new AllPathsSourceTarget();
        int[][] graph = new int[][] {{1, 2}, {3}, {3}, {}};
        System.out.println(a.allPathsSourceTarget(graph));
    }
}
