package com.jarome.leetcode.test4.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转换为整数
 */
public class RomanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> mapping = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
                put("IV", 4);
                put("IX", 9);
                put("XL", 40);
                put("XC", 90);
                put("CD", 400);
                put("CM", 900);
            }
        };
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == 'I' || c == 'X' || c == 'C') && (i + 1) < s.length()) {
                char r = s.charAt(i + 1);
                Integer rci = mapping.get(c + "" + r);
                if (rci != null) {
                    res += rci;
                    i++;
                } else {
                    res += mapping.get(String.valueOf(c));
                }

            } else {
                res += mapping.get(String.valueOf(c));
            }
        }
        return res;
    }
}
