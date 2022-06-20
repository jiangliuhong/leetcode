package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] ps = new int[26];
        int[] ss = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ps[p.charAt(i) - 97] = ps[p.charAt(i) - 97] + 1;
            if (i < p.length() - 1) {
                ss[s.charAt(i) - 97] = ss[s.charAt(i) - 97] + 1;
            }
        }
        for (int i = p.length() - 1; i < s.length(); i++) {
            ss[s.charAt(i) - 97] = ss[s.charAt(i) - 97] + 1;
            if (i - p.length() >= 0) {
                ss[s.charAt(i - p.length()) - 97] = ss[s.charAt(i - p.length()) - 97] - 1;
            }
            if(Arrays.equals(ps,ss)){
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
        System.out.println(f.findAnagrams("af", "be"));
    }
}
