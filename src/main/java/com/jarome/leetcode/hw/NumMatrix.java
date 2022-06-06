package com.jarome.leetcode.hw;

/**
 * 二维码和检索 - 矩阵不可变
 */
public class NumMatrix {
    int[][][] sums;

    public NumMatrix(int[][] matrix) {
        this.sums = new int[matrix.length][matrix[0].length][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int left = 0;
                int top = 0;
                if (j > 0) {
                    left = this.sums[i][j - 1][1];
                }
                if (i > 0) {
                    top = this.sums[i - 1][j][2];
                }
                this.sums[i][j][0] = matrix[i][j];
                this.sums[i][j][1] = left + matrix[i][j];
                this.sums[i][j][2] = top + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        while (row2 >= row1 && col2 >= col1) {
            int left = 0;
            int top = 0;
            if (row1 > 0) {
                top = this.sums[row1 - 1][col2][2];
            }
            if (col1 > 0) {
                left = this.sums[row2][col1 - 1][1];
            }
            sum += this.sums[row2][col2][1] + this.sums[row2][col2][2] - this.sums[row2][col2][0] - left - top;
            row2--;
            col2--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix n = new NumMatrix(arr);
        System.out.println(n.sumRegion(2, 1, 4, 3));
    }

    public class NumMatrix2 {
        private final int[][] sums;

        public NumMatrix2(int[][] matrix) {
            this.sums = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int pre = 0;
                    if (j > 0) {
                        pre = this.sums[i][j - 1];
                    }
                    this.sums[i][j] = matrix[i][j] + pre;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                int left = 0;
                if (col1 > 0) {
                    left = this.sums[i][col1 - 1];
                }
                sum += this.sums[i][col2] - left;
            }
            return sum;
        }
    }
}
