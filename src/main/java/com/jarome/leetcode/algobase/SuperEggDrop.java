package com.jarome.leetcode.algobase;

public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][][] dp = new int[k + 1][n + 1][n+1];
        dp[1][1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
//                dp[i][j][0] =
                for (int l = 1; l < i; l++) {
                    //dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    dp[i][j][l] = dp[i - 1][j][l] + 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SuperEggDrop s = new SuperEggDrop();
        System.out.println(s.superEggDrop(3, 14));
    }
}
