package com.jarome.leetcode.algointo;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == 32) {
                for (int j = i - 1; j >= start; j--) {
                    sb.append(cs[j]);
                }
                sb.append(c);
                start = i + 1;
            }
        }
        for (int j = cs.length - 1; j >= start; j--) {
            sb.append(cs[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords("Let's take LeetCode contest"));
    }
}
