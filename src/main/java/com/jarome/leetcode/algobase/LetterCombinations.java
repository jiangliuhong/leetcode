package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        StringBuilder temp = new StringBuilder();
        selectWord(digits, list, temp, 0);
        return list;
    }

    private void selectWord(String digits, List<String> list, StringBuilder temp, int index) {
        if (index >= digits.length()) {
            list.add(temp.toString());
            return;
        }
        int num = digits.charAt(index) - 48;
        int max = num == 7 || num == 9 ? 4 : 3;
        int sub = num > 7 ? 1 : 0;
        for (int i = 1; i <= max; i++) {
            char c = (char)(96 + 3 * (num - 2) + i + sub);
            temp.append(c);
            selectWord(digits, list, temp, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations("2"));
        System.out.println(l.letterCombinations("7"));
        System.out.println(l.letterCombinations("8"));
        System.out.println(l.letterCombinations("9"));
    }
}
