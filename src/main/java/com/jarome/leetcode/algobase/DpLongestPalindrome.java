package com.jarome.leetcode.algobase;

public class DpLongestPalindrome {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (chars[i] != chars[j]) {
                    continue;
                }
                if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return "";
    }
}
