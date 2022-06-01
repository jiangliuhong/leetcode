package com.jarome.leetcode.test4.math;

/**
 * 计算质数
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int[] primes = new int[n];
        for (int i = 2; i < n; i++) {
            if (primes[i] == 0) {
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        primes[j] = 1;
                    }
                }
            }
        }
        int num = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 0) {
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(100000));
    }
}
