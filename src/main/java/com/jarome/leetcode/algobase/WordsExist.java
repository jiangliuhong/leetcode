package com.jarome.leetcode.algobase;

public class WordsExist {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] path = new int[board.length][board[0].length];
                if (backtrack(board, word, new StringBuilder(), path, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, StringBuilder temp, int[][] path, int y, int x) {
        temp.append(board[y][x]);
        path[y][x] = 1;
        if (temp.toString().equals(word)) {
            return true;
        } else if (!word.startsWith(temp.toString())) {
            path[y][x] = 0;
            temp.deleteCharAt(temp.length() - 1);
            return false;
        }
        for (int k = 0; k < 4; k++) {
            int x2 = x + dx[k];
            int y2 = y + dy[k];
            if (x2 >= 0 && y2 >= 0 && x2 < board[0].length && y2 < board.length && path[y2][x2] == 0) {
                if (backtrack(board, word, temp, path, y2, x2)) {
                    return true;
                }
            }
        }
        path[y][x] = 0;
        temp.deleteCharAt(temp.length() - 1);
        return false;
    }

    public static void main(String[] args) {
        WordsExist w = new WordsExist();
        System.out.println(
            w.exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(w.exist(new char[][]{{'a','b'},{'c','d'}},"acdb"));
    }
}
