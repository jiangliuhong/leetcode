package com.jarome.leetcode.test3;

public class SolutionStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            char hayChar = haystack.charAt(i);
            char needleStart = needle.charAt(0);
            if (hayChar == needleStart) {
                int hayEnd = i + needle.length();
                if (hayEnd > haystack.length()) {
                    // 超过了最大长度限制
                    return -1;
                } else {
                    int n = needle.length();
                    while (true) {
                        n--;
                        hayEnd--;
                        if (n == 0) {
                            return i;
                        }
                        char hc = haystack.charAt(hayEnd);
                        char needleEnd = needle.charAt(n);
                        if (hc != needleEnd) {
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionStr ss = new SolutionStr();
         System.out.println(ss.strStr("a", "a"));
        // System.out.println(ss.strStr("hello", "ll"));
        // System.out.println(ss.strStr("aaaaa", "bba"));
        // System.out.println(ss.strStr("sfjsd klfjslkdjfdlskjfds", "klfjsl"));
        // System.out.println(ss.strStr("mississippi", "issip"));
    }
}
