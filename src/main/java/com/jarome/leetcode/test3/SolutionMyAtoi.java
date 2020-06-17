package com.jarome.leetcode.test3;

public class SolutionMyAtoi {

    public int myAtoi(String str) {
        int res = 0;
        // 是否开始
        boolean isBegin = false;
        // 是否为加法
        boolean isAdd = true;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (c == 32 && !isBegin) {
                // 空格，跳过
                continue;
            }
            // 数字：48~57 - 45 + 43
            if ((c == 45 || c == 43) && !isBegin) {
                isBegin = true;
                if (c == 45) {
                    isAdd = false;
                }
                continue;
            }
            if ((c < 48 || c > 57)) {
                return res;
            }
            if(!isBegin){
                isBegin = true;
            }
            // 转为数字
            c = isAdd ? c - 48 : 48 - c;
            if ((Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && c > 7))
                || Integer.MIN_VALUE / 10 > res || (Integer.MIN_VALUE / 10 == res && c < -8)) {
                return isAdd ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + c;
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionMyAtoi sa = new SolutionMyAtoi();
//         String str = " -42";
        // String str = "42";
//         String str = "4193 with words";
        // String str = "-91283472332";
        // String str = "91283472332";
//        String str = "words and 987";
//        String str = "   +0 123";
        String str = "0-1";
        int i = sa.myAtoi(str);
        System.out.println(i);

    }
}
