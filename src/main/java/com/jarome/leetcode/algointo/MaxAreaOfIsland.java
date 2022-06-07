package com.jarome.leetcode.algointo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 695.岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int areaTemp = 1;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while (!queue.isEmpty()) {
                        int[] ord = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = ord[1] + dx[k];
                            int y = ord[0] + dy[k];
                            if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] == 1) {
                                queue.offer(new int[]{y, x});
                                grid[y][x] = 0;
                                areaTemp++;
                            }
                        }
                    }
                    area = Math.max(area, areaTemp);
                }
            }
        }
        return area;
    }
}
