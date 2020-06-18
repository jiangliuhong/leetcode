package com.jarome.leetcode.test3;

public class SolutionCountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            int num = 0;
            String temp = "";
            for (int j = 0; j < str.length(); j++) {
                
            }
        }
        return str;
    }

    public static void main(String[] args) {
        SolutionCountAndSay sc = new SolutionCountAndSay();
        System.out.println(sc.countAndSay(1));
    }
}
