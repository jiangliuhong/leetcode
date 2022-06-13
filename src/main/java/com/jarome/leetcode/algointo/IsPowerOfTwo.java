package com.jarome.leetcode.algointo;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(~1);
    }
}
