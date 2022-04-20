package com.jarome.leetcode.algointo;

/**
 * 第一个错误的版本 https://leetcode-cn.com/problems/first-bad-version/
 */
public class SolutionVersionControl {

    public class VersionControl {
        boolean isBadVersion(int version) {
            return true;
        }
    }

    // TTTTTFFFFFFFF
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int min = 1, max = n;
            while (min <= max) {
                int seq = (max + min) / 2;
                boolean val = isBadVersion(seq);
                if (val) {
                    if (seq == min) {
                        return seq;
                    }
                    max = seq;

                } else {
                    min = seq + 1;
                }
            }
            return -1;
        }
    }
}