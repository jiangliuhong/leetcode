package com.jarome.leetcode.test3;

public class SolutionCountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            String tempString = "";
            char tempChar = str.charAt(0);
            int tempNum = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == tempChar) {
                    tempNum++;
                } else {
                    tempString = tempString + tempNum + tempChar;
                    tempChar = c;
                    tempNum = 1;
                }
            }
            if (tempNum > 0) {
                tempString = tempString + tempNum + tempChar;
            }
            str = tempString;
        }
        return str;
    }

    public static void main(String[] args) {
        SolutionCountAndSay sc = new SolutionCountAndSay();
        System.out.println(sc.countAndSay(1));
        System.out.println(sc.countAndSay(2));
        System.out.println(sc.countAndSay(3));
        System.out.println(sc.countAndSay(4));
        System.out.println(sc.countAndSay(5));
        System.out.println(sc.countAndSay(6));
        System.out.println(sc.countAndSay(7));
        System.out.println(sc.countAndSay(8));
    }
}
