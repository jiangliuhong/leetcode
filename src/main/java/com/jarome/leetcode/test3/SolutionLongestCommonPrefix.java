package com.jarome.leetcode.test3;

// 公共前缀
public class SolutionLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = -1;
        boolean flag = true;
        while (flag) {
            index++;
            if(index >= strs[0].length()){
                break;
            }
            int c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    flag = false;
                    break;
                }
            }
        }
        if (index == 0) {
            return "";
        } else {
            return strs[0].substring(0, index);
        }
    }

    public static void main(String[] args) {
        SolutionLongestCommonPrefix sl = new SolutionLongestCommonPrefix();
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"dog", "d", "dcar"};
        String[] strs = {"a"};
        String s = sl.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
