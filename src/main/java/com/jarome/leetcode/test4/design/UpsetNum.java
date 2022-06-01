package com.jarome.leetcode.test4.design;

import java.util.Random;

public class UpsetNum {

    class Solution {

        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            if (this.nums == null) {
                return null;
            }
            int[] newNums = nums.clone();
            for (int i = 0; i < newNums.length; i++) {
                int r = this.random.nextInt(i + 1);
                swap(newNums, r, i);
            }
            return nums;
        }

        private void swap(int[] a, int i, int j) {
            if (i != j) {
                a[i] = a[i] + a[j];
                a[j] = a[i] - a[j];
                a[i] = a[i] - a[j];
            }
        }

    }
}
