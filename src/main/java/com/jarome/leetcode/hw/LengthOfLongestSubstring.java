package com.jarome.leetcode.hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] bucket = new int[123];
        Arrays.fill(bucket, -1);
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (bucket[c] != -1) {
                start = Math.max(start, bucket[c] + 1);
            }
            max = Math.max(max, i - start);
            bucket[c] = i;
        }
        return max + 1;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            max = Math.max(max, i - start);
            map.put(c, i);
        }
        return max + 1;
    }

}
