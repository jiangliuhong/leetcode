package com.jarome.leetcode.algointo;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {


    public int[][] updateMatrix(int[][] mat) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (queue.peek() != null) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = poll[1] + dx[i];
                int y = poll[0] + dy[i];
                if (x >= 0 && y >= 0 && x < mat[0].length && y < mat.length && mat[y][x] == -1) {
                    mat[y][x] = mat[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{y, x});
                }
            }
        }
        return mat;
    }


}
