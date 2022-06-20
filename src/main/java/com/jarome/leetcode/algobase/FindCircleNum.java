package com.jarome.leetcode.algobase;

import java.util.LinkedList;
import java.util.Queue;

public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                isConnected[i][i] = 0;
                count++;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[poll][j] == 1) {
                            isConnected[poll][j] = 0;
                            queue.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }
}
