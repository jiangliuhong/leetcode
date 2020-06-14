package com.jarome.leetcode.test3;

public class SolutionFirstUniqChar {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndexOf = s.lastIndexOf(String.valueOf(c));
            int indexOf = s.indexOf(String.valueOf(c));
            if(lastIndexOf == indexOf){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionFirstUniqChar sf = new SolutionFirstUniqChar();
        System.out.println(sf.firstUniqChar("loveleetcode"));
    }
}
