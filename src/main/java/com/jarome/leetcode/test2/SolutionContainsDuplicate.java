package com.jarome.leetcode.test2;

import java.util.HashSet;
import java.util.Set;

public class SolutionContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if(set.contains(val)){
                return true;
            }
            set.add(val);
        }
        return false;
    }
}
