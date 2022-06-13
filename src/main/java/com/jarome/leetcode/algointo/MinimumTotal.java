package com.jarome.leetcode.algointo;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        if (dp.length == 1) {
            return dp[0][0];
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> triangle2 = triangle.get(i);
            for (int j = 0; j < triangle2.size(); j++) {
                int p1 = Integer.MAX_VALUE;
                int p2 = Integer.MAX_VALUE;
                if (j > 0) {
                    p1 = dp[i - 1][j - 1];
                }
                if (j < triangle2.size() - 1) {
                    p2 = dp[i - 1][j];
                }
                dp[i][j] = Math.min(p1, p2) + triangle2.get(j);
            }
        }
        int maxTotal = Integer.MAX_VALUE;
        for (int i = 0; i < dp[triangle.size() - 1].length; i++) {
            maxTotal = Math.min(maxTotal, dp[triangle.size() - 1][i]);
        }
        return maxTotal;
    }

    public static void main(String[] args) {
        MinimumTotal m = new MinimumTotal();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(){{add(2);}});
        list.add(new ArrayList<Integer>(){{add(3);add(4);}});
        list.add(new ArrayList<Integer>(){{add(6);add(5);add(7);}});
        list.add(new ArrayList<Integer>(){{add(4);add(1);add(8);add(3);}});
        System.out.println(m.minimumTotal(list));
    }
}
