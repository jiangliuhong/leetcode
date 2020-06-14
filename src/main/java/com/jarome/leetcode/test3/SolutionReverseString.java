package com.jarome.leetcode.test3;

public class SolutionReverseString {
    public void reverseString(char[] s) {
        int n = s.length / 2;
        for (int i = 0; i < n; i++) {
            int pi = s.length - i - 1;
            char temp = s[i];
            s[i] = s[pi];
            s[pi] = temp;
        }
    }
}
