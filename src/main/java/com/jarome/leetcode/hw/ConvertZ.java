package com.jarome.leetcode.hw;

/**
 * Z 字形变换
 */
public class ConvertZ {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        boolean isSlant = false;
        int indexY = 0;
        int indexX = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[indexY][indexX] = s.charAt(i);
            if (indexY == numRows - 1) {
                isSlant = true;
            } else if (indexY == 0) {
                isSlant = false;
            }
            if (isSlant) {
                indexY--;
                indexX++;
            } else {
                indexY++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= indexX; j++) {
                if (arr[i][j] != 0) {
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertZ c = new ConvertZ();
        System.out.println(c.convert("PAYPALISHIRING", 4));
    }
}
