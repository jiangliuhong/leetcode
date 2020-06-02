package com.jarome.leetcode.test2;

/**
 * 旋转图像
 */
public class SolutionRotateImg {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                // 循环移动数组
                int thisI = i;
                int thisJ = j;
                // 方向 1234 上下左右，默认第一个向右
                int direction = 4;
                // 计算当前点所在层级，最外层，还是里层
                int tier = Math.min(Math.min(thisI, n - thisI), Math.min(thisJ, n - thisJ));
                while (true) {
                    // 需要移动的次数为总数监区层级的两倍
                    int move = n - tier * 2;
                    // 计算下一个坐标
                    int nextI = thisI;
                    int nextJ = thisJ;
                    for (int m = move; m > 0;) {
                        if (nextJ - m >= tier) {
                            nextJ = nextJ - m;
                            m = 0;
                            continue;
                        }else{

                        }
                    }
                }
            }
        }
    }
}
