package com.jarome.leetcode.test2;

/**
 * 旋转图像
 */
public class SolutionRotateImg {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int isize = n / 2;
        for (int i = 0; i <= isize; i++) {
            for (int j = i; j < (n - i); j++) {
                // 1,1 => 1,2
                // 3,0 => 0,0
                int thisI = i;
                int thisJ = j;
                int temp = matrix[i][j];
                do {
                    // 旋转90度，坐标的变化规则为：1.交换x、y坐标，2.y=len-y
                    int nextI = thisJ;
                    int nextJ = n - thisI;
                    // 交换两数
                    int nextVal = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = temp;
                    temp = nextVal;
                    thisI = nextI;
                    thisJ = nextJ;
                } while (!(thisI == i && thisJ == j));
            }
        }
    }

    public static void main(String[] args) {
        SolutionRotateImg sri = new SolutionRotateImg();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        sri.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            String row = "";
            for (int j = 0; j < matrix[i].length; j++) {
                row = row + matrix[i][j] + " ";
            }
            System.out.println(row);
        }
    }
}
