package com.jarome.leetcode.algointo;

public class HammingWeight {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int n = x ^ y;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight h = new HammingWeight();
        System.out.println(Integer.toBinaryString(-3));
        // System.out.println(h.hammingWeight(-4));
    }
}
