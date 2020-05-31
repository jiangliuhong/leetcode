package com.jarome.leetcode.test2;

public class SolutionPlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    // 最后一个为9，需要对数组进行扩容
                    int[] newdigts = new int[digits.length + 1];
                    newdigts[0] = 1;
                    // 由于数组默认为0，所以不需要执行下面的方法
                    // for (int j = 0; j < digits.length; j++) {
                    // newdigts[j + 1] = digits[j];
                    // }
                    return newdigts;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        SolutionPlusOne spo = new SolutionPlusOne();
        int[] digits = {9, 9};
        int[] ints = spo.plusOne(digits);
        String str = "";
        for (int i = 0; i < ints.length; i++) {
            str = str + ints[i] + " ";
        }
        System.out.println(str);
    }
}
