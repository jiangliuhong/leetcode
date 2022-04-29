package com.jarome.leetcode.test4.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 I and II
 */
public class GenerateTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    List<Integer> after = list.get(i - 1);
                    subList.add(after.get(j - 1) + after.get(j));
                }
            }
            list.add(subList);
        }
        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(list.get(j - 1) + list.get(j));
                }
            }
            list = temp;
        }
        return list;
    }

    public static void main(String[] args) {
        GenerateTriangle gt = new GenerateTriangle();
        gt.generate(5);
    }
}
