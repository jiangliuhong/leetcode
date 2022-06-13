package com.jarome.leetcode.algointo;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> firstFloor = new ArrayList<>();
        firstFloor.add(1);
        list.add(firstFloor);
        for (int i = 1; i < numRows; i++) {
            List<Integer> floor = new ArrayList<>();
            List<Integer> preFloor = list.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    floor.add(1);
                } else {
                    floor.add(preFloor.get(j - 1) + preFloor.get(j));
                }
            }
            list.add(floor);
        }
        return list;
    }
}
