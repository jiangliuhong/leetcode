package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solve {
    public void solve(char[][] board) {
        int[] dx = new int[] {1, 0, 0, -1};
        int[] dy = new int[] {0, 1, -1, 0};
        int m = board.length;
        int n = board[0].length;
        int[][] visit = new int[m][n];
        List<int[]> changeList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == 1 || board[i][j] == 'X') {
                    continue;
                }
                visit[i][j] = 1;
                queue.offer(new int[] {i, j});
                boolean change = true;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    if (poll[0] == 0 || poll[1] == 0 || poll[0] == m - 1 || poll[1] == n - 1) {
                        change = false;
                    } else if (change) {
                        changeList.add(poll);
                    }
                    for (int k = 0; k < 4; k++) {
                        int x = poll[1] + dx[k];
                        int y = poll[0] + dy[k];
                        if (x >= 0 && y >= 0 && x < n && y < m && visit[y][x] != 1 && board[y][x] == 'O') {
                            visit[y][x] = 1;
                            queue.offer(new int[] {y, x});
                        }
                    }
                }
                if (change) {
                    for (int[] ints : changeList) {
                        board[ints[0]][ints[1]] = 'X';
                    }
                } else {
                    changeList.clear();
                }
            }
        }
    }
}
