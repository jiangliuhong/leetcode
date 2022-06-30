package com.jarome.leetcode.algobase;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n, n, list, new StringBuilder());
        return list;
    }

    private void backtrack(int left, int right, List<String> list, StringBuilder temp) {
        if (left > right) {
            return;
        } else if (left == 0 && right == 0) {
            list.add(temp.toString());
            return;
        }
        for (int i = left; i > 0; i--) {
            for (int n = 0; n < i; n++) {
                temp.append("(");
            }
            for (int j = 1; j <= right; j++) {
                for (int n = 0; n < j; n++) {
                    temp.append(")");
                }
                backtrack(left - i, right - j, list, temp);
                temp.delete(temp.length() - j, temp.length());
            }
            temp.delete(temp.length() - i, temp.length());
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(3));
        System.out.println(g.generateParenthesis(1));
    }
}
