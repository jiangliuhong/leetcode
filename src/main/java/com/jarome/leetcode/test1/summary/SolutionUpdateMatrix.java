package com.jarome.leetcode.test1.summary;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionUpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        // 移动方向的数组 分别对应 右、左、下、上
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        // 先遍历一次，先把所有的0加入到队列中，把所有的1置为-1，-1标记为未处理
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            // 判断是否已经被处理
            int ox = coor[0];
            int oy = coor[1];
            // 上下左右四个方向进行
            for (int[] d : direct) {
                int x = ox + d[0];
                int y = oy + d[1];
                // 判断坐标是否有效
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length && matrix[x][y] == -1) {
                    if (matrix[x][y] != 0) {
                        matrix[x][y] = matrix[ox][oy] + 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        SolutionUpdateMatrix sum = new SolutionUpdateMatrix();
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = sum.updateMatrix(matrix);
        for (int i = 0; i < ints.length; i++) {
            String line = "";
            for (int j = 0; j < ints[i].length; j++) {
                line = line + ints[i][j] + "  ";
            }
            System.out.println(line);
        }
    }

}
