package com.jarome.leetcode.algointo;

/**
 * 第一个错误的版本 https://leetcode-cn.com/problems/first-bad-version/
 */
public class SolutionVersionControl {

    public static class VersionControl {
        boolean isBadVersion(int version) {
            if (version >= 1702766719) {
                return true;
            } else {
                return false;
            }
        }
    }

    // FFFFFTTTTTTTTTTTT
    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int min = 1, max = n;
            while (min < max) {
                int seq = min + (max - min) / 2;
                boolean val = isBadVersion(seq);
                if (val) {
                    max = seq;
                } else {
                    min = seq + 1;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstBadVersion(2126753390));
    }
}