package com.jarome.leetcode.algobase;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int m1 = mid / n;
            int n1 = mid - m1 * n;
            int val = matrix[m1][n1];
            if (val == target) {
                return true;
            }
            if (val > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
        System.out.println(s.searchMatrix(new int[][] {{1},{ 3}}, 2));
    }

}
