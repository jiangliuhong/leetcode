package com.jarome.leetcode.hw;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxSubLen = 1, begin = 0;
        char[] chars = s.toCharArray();
        for (int subLen = 2; subLen <= len; subLen++) {
            for (int i = 0; i < len; i++) {
                int j = subLen + i - 1;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxSubLen) {
                    maxSubLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxSubLen);
    }

    public String longestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                String s1 = s.charAt(i - 1) + "" + s.charAt(i);
                int p = 1;
                for (; i + p < s.length() && i - p - 1 >= 0; p++) {
                    if (s.charAt(i + p) == s.charAt(i - p - 1)) {
                        s1 = s.charAt(i - p - 1) + s1 + s.charAt(i + p);
                    } else {
                        break;
                    }
                }
                if (s1.length() > res.length()) {
                    res = s1;
                }
            }
            String s2 = s.charAt(i) + "";
            int p = 1;
            for (; i + p < s.length() && i - p >= 0; p++) {
                if (s.charAt(i + p) == s.charAt(i - p)) {
                    s2 = s.charAt(i + p) + s2 + s.charAt(i - p);
                } else {
                    break;
                }
            }
            if (s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("tattarrattat"));
    }
}