package com.jarome.leetcode.hw;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> site = new HashMap<>();
        site.put(0, 0);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (site.containsKey(sum)) {
                len = Math.max(len, i - site.get(sum) );
            } else {
                site.put(sum, i+1);
            }
        }
        return len;
    }

    public int findMaxLength1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int len = 0;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        for (int i = nums.length - nums.length % 2; i >= 2; i = i - 2) {
            for (int j = 1; j + i <= sums.length; j++) {
                if (sums[j + i - 1] - sums[j - 1] == 0) {
                    return i;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        FindMaxLength f = new FindMaxLength();
        System.out.println(f.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
