package com.jarome.leetcode.test1;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionIsland {

    public int numIslands(char[][] grid) {
        int islandSize = 0;
        int ySize = grid.length;
        // 遍历grid数组
        for (int i = 0; i < ySize; i++) {
            char[] item = grid[i];
            int xSize = item.length;
            for (int j = 0; j < xSize; j++) {
                char itemValue = item[j];
                if (itemValue != '1') {
                    // 当前不为1，直接跳过
                    continue;
                }
                // 岛屿数加1
                islandSize++;
                // 将当前标记为已处理
                grid[i][j] = '0';
                // 队列，用于进行广度搜索
                Queue<Point> queue = new LinkedList<Point>();
                Point start = new Point(j, i);
                queue.add(start);
                while (!queue.isEmpty()) {
                    // 移除当前
                    Point remove = queue.remove();
                    int x = remove.getX();
                    int y = remove.getY();
                    // 分别计算上下左右
                    // 上
                    deal(queue, grid, x, y - 1, xSize, ySize);
                    // 下
                    deal(queue, grid, x, y + 1, xSize, ySize);
                    // 左
                    deal(queue, grid, x - 1, y, xSize, ySize);
                    // 右
                    deal(queue, grid, x + 1, y, xSize, ySize);

                }
            }
        }
        return islandSize;
    }

    private void deal(Queue<Point> queue, char[][] grid, int x, int y, int xSize, int ySize) {
        if ((x >= 0 && x < xSize) && (y >= 0 && y < ySize) && grid[y][x] == '1') {
            grid[y][x] = '0';
            Point next = new Point(x, y);
            queue.add(next);
        }
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
