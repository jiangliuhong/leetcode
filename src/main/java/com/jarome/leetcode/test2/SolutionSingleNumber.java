package com.jarome.leetcode.test2;

public class SolutionSingleNumber {


    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
