package com.jarome.leetcode.algointo;

/**
 * 字符串排列
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] countArr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 97;
            countArr[index] = countArr[index] + 1;
        }
        int[] tempArr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int index = s2.charAt(i) - 97;
            tempArr[index] = tempArr[index] + 1;
        }
        if (checkArr(countArr, tempArr)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int last = s2.charAt(i - s1.length()) - 97;
            tempArr[last] = tempArr[last] - 1;
            int curr = s2.charAt(i) - 97;
            tempArr[curr] = tempArr[curr] + 1;
            if (checkArr(countArr, tempArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        System.out.println(c.checkInclusion("abc", "cccbbbbaaaa"));
    }

}
