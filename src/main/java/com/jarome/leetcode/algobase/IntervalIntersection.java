package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int first = 0;
        int second = 0;
        while (first < firstList.length && second < secondList.length) {
            int left = Math.max(firstList[first][0], secondList[second][0]);
            int right = Math.min(firstList[first][1], secondList[second][1]);
            if (left <= right) {
                list.add(new int[] {left, right});
            }
            if (firstList[first][1] < secondList[second][1]) {
                first++;
            } else {
                second++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
