package com.jarome.leetcode.algobase;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[] dx = new int[] {1, 0, 0, -1, 1, -1, 1, -1};
        int[] dy = new int[] {0, 1, -1, 0, 1, -1, -1, 1};
        int n = grid.length;
        int len = 0;
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.offer(new int[] {0, 0});
        grid[0][0] = 2;
        while (!queue.isEmpty()) {
            len++;
            int newCount = 0;
            for (int i = 0; i < count; i++) {
                int[] poll = queue.poll();
                if (poll[0] == poll[1] && poll[0] == n - 1) {
                    return len;
                }
                for (int k = 0; k < 8; k++) {
                    int x = poll[1] + dx[k];
                    int y = poll[0] + dy[k];
                    if (x >= 0 && y >= 0 && x < n && y < n && grid[y][x] == 0) {
                        queue.offer(new int[] {y, x});
                        grid[y][x] = 2;
                        newCount++;
                    }
                }
            }
            count = newCount;
        }
        return -1;
    }

}
