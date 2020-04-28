package com.jarome.leetcode.test1;

public class SolutionIslandDFS {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    res++;
                    island(i, j, grid);
                }
            }
        }
        return res;
    }

    private void island(int i, int j, char[][] grid) {
        int ySize = grid.length;
        int xSize = grid[0].length;
        if (i < 0 || i >= ySize || j < 0 || j >= xSize) {
            // 有一个超出边界，返回true
            return;
        }
        char c = grid[i][j];
        if (c == '0') {
            return;
        }
        grid[i][j] = '0';
        // 分别处理四个方向
        // 上
        island(i, j - 1, grid);
        // 下
        island(i, j + 1, grid);
        // 左
        island(i - 1, j, grid);
        // 右
        island(i + 1, j, grid);
    }
}
