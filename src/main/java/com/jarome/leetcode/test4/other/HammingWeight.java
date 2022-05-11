package com.jarome.leetcode.test4.other;

public class HammingWeight {

    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            n &= n - 1;
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        HammingWeight hw = new HammingWeight();
        System.out.println(hw.hammingWeight(10));
    }
}
