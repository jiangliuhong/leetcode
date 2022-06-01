package com.jarome.leetcode.test4.math;

/**
 * 是否为3的幂
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        boolean res = false;
        for (int i = 1;; i = 3 * i) {
            if (i == n) {
                res = true;
                break;
            } else if (i > n || i < 0) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        IsPowerOfThree pt = new IsPowerOfThree();
        System.out.println(pt.isPowerOfThree(2147483647));
    }
}
