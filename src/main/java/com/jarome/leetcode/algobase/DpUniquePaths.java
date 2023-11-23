package com.jarome.leetcode.algobase;

public class DpUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        DpUniquePaths d = new DpUniquePaths();
        System.out.println(d.uniquePaths(3, 2));
    }
}
