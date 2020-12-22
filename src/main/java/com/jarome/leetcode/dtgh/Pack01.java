package com.jarome.leetcode.dtgh;

// 0-1 背包问题
public class Pack01 {
    /**
     * 计算背包问题
     * 
     * @param n 物品数
     * @param w 背包可装载重量
     * @param wt 物品重量
     * @param val 物品价值
     * @return 最大价值
     */
    public int exec(int n, int w, int[] wt, int[] val) {
        // 二维数组:总物品数量；总物品重量
        int[][] dp = new int[n + 1][w + 1];
        dp[0][0] = 0;
        dp[1][wt[0]] = val[0];
        // 遍历物品
        for (int i = 1; i <= n; i++) {
            // 遍历重量，处理每个物品的对应每种情况下的最值,j代表背包可用重量
            for (int j = 1; j <= w; j++) {
                // 两种情况
                if (j - wt[i - 1] < 0) {
                    // 当前背包装不下这个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 当前背包能装下这个物品
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        Pack01 p = new Pack01();
        System.out.println(p.exec(n, w, wt, val));
    }
}
