package com.jarome.leetcode.test3;

import java.util.HashMap;
import java.util.Map;

public class SolutionIsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            cache.put(c, cache.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            String c = String.valueOf(t.charAt(i));
            Integer integer = cache.get(c);
            if (integer == null) {
                return false;
            } else {
                integer = integer - 1;
                if (integer == 0) {
                    cache.remove(c);
                } else {
                    cache.put(c, integer);
                }
            }
        }
        return cache.isEmpty();
    }

}
