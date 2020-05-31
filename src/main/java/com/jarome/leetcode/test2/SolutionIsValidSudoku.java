package com.jarome.leetcode.test2;

public class SolutionIsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 行缓存
        int[][] row = new int[9][9];
        // 列缓存
        int[][] vertical = new int[9][9];
        // 小九宫格缓存
        int[][] grid = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                int b = (int)board[i][j] - 48;
                if (row[i][b - 1] == b) {
                    return false;
                } else {
                    row[i][b - 1] = b;
                }
                if (vertical[j][b - 1] == b) {
                    return false;
                } else {
                    vertical[j][b - 1] = b;
                }
                // int gridRowNum = i / 3;
                // int gridVerticalNum = j / 3;
                // int verticalNum = gridRowNum + gridVerticalNum * 3;
                int verticalNum = i / 3 + (j / 3) * 3;
                if (grid[verticalNum][b - 1] == b) {
                    return false;
                } else {
                    grid[verticalNum][b - 1] = b;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char c = '2';
        int i = (int)c - 48;
        System.out.println(i);
    }
}
