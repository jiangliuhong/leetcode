package com.jarome.leetcode.test1.summary;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionUpdateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        // 移动方向的数组 分别对应 右、左、下、上
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[] start = {0, 0};
        Queue<int[]> queue = new LinkedList<>();

        return matrix;
    }

    /*public int[][] updateMatrix(int[][] matrix) {
        Map<String, Integer> valTemp = new HashMap<>();
        // 移动方向的数组 分别对应 右、左、下、上
        int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                String key = i + "," + j;
                if (valTemp.containsKey(key)) {
                    // 已经处理了，跳过
                    continue;
                }
                queue.offer(new int[] {i, j});
                int num = 0;
                while (!queue.isEmpty()) {
                    num++;
                    // 坐标
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] coor = queue.poll();
                        int val = matrix[coor[0]][coor[1]];
                        String key_ = coor[0] + "," + coor[1];
                        if (val == 0) {
                            queue.clear();
                            matrix[coor[0]][coor[1]] = num;
                            valTemp.put(key_, num);
                            break;
                        } else if (valTemp.containsKey(key_)) {
    
                        }
                        for (int[] d : direct) {
                            int x = coor[0] + d[0];
                            int y = coor[1] + d[1];
                            // 判断坐标是否有效
                            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[x].length) {
                                queue.offer(new int[] {x, y});
                            }
                        }
                    }
                }
            }
        }
        return matrix;
    }*/

}
