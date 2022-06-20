package com.jarome.leetcode.algobase;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[] dx = new int[] {1, 0, 0, -1};
        int[] dy = new int[] {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = poll[1] + dx[k];
                            int y = poll[0] + dy[k];
                            if (x >= 0 && y >= 0 && x < grid[i].length && y < grid.length && grid[y][x] == '1') {
                                grid[y][x] = '0';
                                queue.offer(new int[] {y, x});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumIslands nil = new NumIslands();
        char[][] grid = new char[][] {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};
        System.out.println(nil.numIslands(grid));
    }
}
