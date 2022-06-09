package com.jarome.leetcode.algointo;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        int orange = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    orange++;
                }
            }
        }
        int rottenNum = queue.size();
        int time = 0;
        while (queue.peek() != null) {
            int rottenTemp = 0;
            for (int i = 0; i < rottenNum; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = poll[1] + dx[j];
                    int y = poll[0] + dy[j];
                    if (x >= 0 && y >= 0 && x < grid[0].length && y < grid.length && grid[y][x] == 1) {
                        grid[y][x] = 2;
                        queue.offer(new int[] {y, x});
                        rottenTemp++;
                        orange--;
                    }
                }
            }
            rottenNum = rottenTemp;
            if (queue.peek() != null) {
                time++;
            }
        }
        if (orange > 0) {
            return -1;
        } else {
            return time;
        }
    }

    public static void main(String[] args) {
        OrangesRotting o = new OrangesRotting();
        System.out.println(o.orangesRotting(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
