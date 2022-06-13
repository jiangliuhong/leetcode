package com.jarome.leetcode.algointo;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        return dfs(n, k, 1);
    }

    private List<List<Integer>> dfs(int n, int k, int start) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = start; i <= n; i++) {
            if (k > 1) {
                List<List<Integer>> subList = dfs(n, k - 1, i + 1);
                if (!subList.isEmpty()) {
                    for (int i1 = 0; i1 < subList.size(); i1++) {
                        List<Integer> item = subList.get(i1);
                        item.add(0, i);
                    }
                    list.addAll(subList);
                }
            } else {
                List<Integer> one = new ArrayList<>();
                one.add(i);
                list.add(one);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Combine c = new Combine();
        System.out.println(c.combine(4, 2));
    }
}
