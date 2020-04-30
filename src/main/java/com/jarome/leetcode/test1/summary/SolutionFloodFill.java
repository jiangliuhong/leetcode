package com.jarome.leetcode.test1.summary;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 图像渲染 该题和岛屿问题相同,并且相对要简单一些
 */
public class SolutionFloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 先记录一下需要替换的值
        int oldColor = image[sr][sc];
        // 如果oldColor与newColor相等，直接返回
        if (oldColor == newColor) {
            return image;
        }
        int xSize = image[0].length;
        int ySize = image.length;

        // 记录坐标的栈
        Queue<int[]> coordinate = new LinkedList<>();
        // 缓存已经处理的坐标
        Set<String> cache = new HashSet<>();
        coordinate.offer(new int[] {sr, sc});
        while (!coordinate.isEmpty()) {
            int[] cd = coordinate.poll();

            int _sr = cd[0];
            int _sc = cd[1];
            if (cache.contains(_sr + "," + _sc)) {
                // 已经处理，直接跳过
                continue;
            }
            int imageVal = image[_sr][_sc];
            // if (imageVal != newColor && imageVal != oldColor) {
            // continue;
            // }
            if (imageVal != oldColor) {
                continue;
            }
            cache.add(_sr + "," + _sc);
            image[_sr][_sc] = newColor;
            // 分别计算上下左右
            // 右
            if (_sc + 1 < xSize) {
                coordinate.offer(new int[] {_sr, _sc + 1});
            }
            // 左
            if (_sc - 1 >= 0) {
                coordinate.offer(new int[] {_sr, _sc - 1});
            }
            // 下
            if (_sr + 1 < ySize) {
                coordinate.offer(new int[] {_sr + 1, _sc});
            }
            // 上
            if (_sr - 1 >= 0) {
                coordinate.offer(new int[] {_sr - 1, _sc});
            }
        }
        return image;
    }

    public static void main(String[] args) {
        SolutionFloodFill sff = new SolutionFloodFill();
        // int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        // int sr = 1;
        // int sc = 1;
        // int newColor = 2;
        int[][] image = {{0, 1, 0}, {0, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        int[][] ints = sff.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < ints.length; i++) {
            String line = "";
            for (int j = 0; j < ints[i].length; j++) {
                line = line + ints[i][j] + " ";
            }
            System.out.println(line);
        }
    }

}
